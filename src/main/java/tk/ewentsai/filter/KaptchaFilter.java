package tk.ewentsai.filter;

import com.google.code.kaptcha.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class KaptchaFilter extends AccessControlFilter {

    private String kaptchaParam = "kaptchaCode";

    private String failureKeyAttribute = "shiroLoginFailure";

    public String getKaptchaCode(ServletRequest request) {
        return WebUtils.getCleanParam(request, getKaptchaParam());
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        // 从session获取正确的验证码
        Session session = SecurityUtils.getSubject().getSession();
        //页面输入的验证码
        String captchaCode = getKaptchaCode(servletRequest);
        String validateCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        HttpServletRequest httpServletRequest = WebUtils.toHttp(servletRequest);
        //判断验证码是否表单提交（允许访问）
        if ( !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {
            return true;
        }

        // 若验证码为空或匹配失败则返回false
        if(captchaCode == null) {
            return false;
        } else if (validateCode != null) {
            //忽略大小写
            captchaCode = captchaCode.toLowerCase();
            validateCode = validateCode.toLowerCase();
            if(!captchaCode.equals(validateCode)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {		 //如果验证码失败了，存储失败key属性
        servletRequest.setAttribute(failureKeyAttribute, "验证码错误");
        return true;
    }

    public String getKaptchaParam() {
        return kaptchaParam;
    }

    public void setCaptchaParam(String captchaParam) {
        this.kaptchaParam = captchaParam;
    }

}