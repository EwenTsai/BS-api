package tk.ewentsai.contronller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import tk.ewentsai.manage.manageBook;
import tk.ewentsai.manage.manageCart;
import tk.ewentsai.manage.manageOrder;
import tk.ewentsai.manage.manageUser;
import tk.ewentsai.pojo.*;
import tk.ewentsai.unit.pagination;
import tk.ewentsai.unit.vaildateCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Contronller {
    @RequestMapping(value = "login.do",produces = {"application/json;charset=UTF-8"})
    public String login(String uname, String pwd, String VaildateCode, HttpSession hs, HttpServletResponse response){
        String returnString;
        //检查验证码
        if(vaildateCode.checkCode((String) hs.getAttribute("vaildateCode"),VaildateCode )){
            String pageName;
            User user = manageUser.checkUname(uname, pwd);
            if (user != null) {
                hs.setAttribute("user", user);
                //登陆成功后添加cookies
                Cookie cookie = new Cookie("uid", user.getUid());
                //设置cookies存活时间
                cookie.setMaxAge(3*24*3600);
                response.addCookie(cookie);
                hs.setAttribute("Carts", manageCart.getCartByUid(Integer.parseInt(user.getUid())));
                returnString = "isLoginSuccess";
            } else {
                returnString = "用户名或密码错误";
            }
        }else{
            returnString = "验证码错误";
        }
        return returnString;
    }
    //使用cookie实现免登录
    @RequestMapping("check.do")
    public User check(int uid,HttpSession hs) {
        User user = manageUser.checkUid(uid+"");
        if(user!=null){
            //将user的信息放入session中
            hs.setAttribute("user", user);
            //将购物车信息放入seesion中
            hs.setAttribute("Carts",manageCart.getCartByUid(uid));
        }
        return user;
    }
    @RequestMapping(value = "register.do",produces = {"application/json;charset=UTF-8"})
    public String register(String uname, String pwd, String VaildateCode, HttpSession hs) {
        String returnString;
        //再次检查验证码
        if(vaildateCode.checkCode((String) hs.getAttribute("vaildateCode"),VaildateCode)){
            //检查用户名是否已存在
            User user = manageUser.checkUname(uname,pwd);
            if(user==null){
                //不存在同名的用户名，进行注册
                manageUser.register(uname,pwd);
                returnString = "isRegisterSuccess";
            }else{
                //存在同名的用户名
                returnString = "此用户名已经被注册";
            }
        }else{
            returnString = "验证码错误";
        }
        return returnString;
    }
    //根据搜索的关键词进行搜索
    @RequestMapping("search.do")
    public List<Book> search(String searchText) {
        return manageBook.searchName(searchText);
    }
    //根据id进行搜索
    @RequestMapping("searchBook.do")
    public Book search(int id) {
        return manageBook.searchID(id);
    }
    @RequestMapping("refreshCode.do")
    public void refreshCode(HttpServletResponse response, HttpSession hs) throws IOException {
        response.setContentType("image/jpeg");
        ServletOutputStream sos = response.getOutputStream();
        vaildateCode vaildateCode = new vaildateCode();
        hs.setAttribute("vaildateCode",vaildateCode.getRandomCode());
        ImageIO.write(vaildateCode.getBuffImg(), "jpeg", sos);
        sos.close();
    }
    //分页
    @RequestMapping("pagination.do")
    public List pagination(String paginationClass, @RequestParam(value = "isNextPage",defaultValue = "0") int isNextPage, HttpSession hs) {
        //当前页数默认为第一页
        int currPage = 1;
        //根据商品类型得到总页数，并记录在session中
        PageBean pageBean = new PageBean<>(manageBook.getBooks(paginationClass).size());
        hs.setAttribute("totalPage",pageBean.getTotalPage());
        hs.setAttribute("paginationClass",paginationClass);
        //根据isNextPage来判断上下页  1为下一页  0返回第一页  —1为下一页
        switch (isNextPage){
            case 1:
                currPage = (int) hs.getAttribute("currPage");
                currPage+=1;
                break;
            case 0:
                currPage = 1;
                break;
            case -1:
                currPage = (int) hs.getAttribute("currPage");
                currPage-=1;
                break;
        }
        pageBean = pagination.findPageBean(currPage,paginationClass);
        hs.setAttribute("currPage",currPage);
        return pageBean.getList();
    }
    //获取购物车信息
    @RequestMapping("cart.do")
    public List<Book> cart(HttpSession hs, @RequestParam(defaultValue = "0") int id) {
        ArrayList<Book> Carts = (ArrayList<Book>) hs.getAttribute("Carts");
        //获取当前操作购物车的用户
        User user = (User)hs.getAttribute("user");
        Carts = manageCart.manage(Carts,id,Integer.parseInt(user.getUid()));
        hs.setAttribute("Carts",Carts);
        return Carts;
    }
    //购物车结算
    @RequestMapping("order.do")
    public void orders(BigDecimal amount, HttpSession hs){
        User user = (User)hs.getAttribute("user");
        ArrayList<Book> Carts = (ArrayList<Book>)hs.getAttribute("Carts");
        int uid = Integer.parseInt(user.getUid());
        int number = Carts.size();
        manageOrder.addOrders(uid,number,amount);
        manageOrder.addOrder(Carts,Integer.parseInt(user.getUid()));
    }
    //订单删除
    @RequestMapping("removeOrder.do")
    public void removeOrder(int orderId){

        manageOrder.removeOrderBy(orderId);
    }
    //订单详情信息获取
    @RequestMapping("orderDetail.do")
    public ArrayList orderDetail(int orderId){
        ArrayList<singalOrder> singalOrder = manageOrder.getOrderByOrderId(orderId);
        Orders orders = manageOrder.getOrdersByOrderId(orderId);
        ArrayList result = new ArrayList();
        result.add(orders);
        result.add(singalOrder);
        return result;
    }
    @RequestMapping("download.do")
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException{
        System.out.println(fileName);
        //设置响应头Content-Disposition default-value=inline浏览器会优先考虑展示文件内容，如不能展示则下载
        //attactment设置为附件，默认下载，重新编码文件名解决下载文件中文名乱码的问题
        response.setHeader("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(fileName, "UTF-8"));
        ServletOutputStream os = response.getOutputStream();
        String path = request.getServletContext().getRealPath("electronic_book");
        File file = new File(path,fileName);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        os.write(bytes);
        os.flush();
        os.close();
    }
}

