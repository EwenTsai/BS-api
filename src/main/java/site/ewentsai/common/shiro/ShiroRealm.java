package site.ewentsai.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.ewentsai.common.jwt.JWTToken;
import site.ewentsai.common.jwt.JWTUtil;
import site.ewentsai.model.entity.SysPermission;
import site.ewentsai.model.entity.SysRole;
import site.ewentsai.model.entity.User;
import site.ewentsai.serves.UserService;

@Service
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        User user = userService.findUserByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        for (SysRole role : user.getRoles()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getName());
            }
        }
        return authorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        User user = userService.findUserByUsername(username);

        if (user == null) {
            return null;
        }
        if (JWTUtil.verify(token, username, user.getPwd())) {
            return null;
        }
        return new SimpleAuthenticationInfo(token,token,getName());

//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUname(), user.getPwd(),
//                ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
//        return authenticationInfo;
    }

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
}
