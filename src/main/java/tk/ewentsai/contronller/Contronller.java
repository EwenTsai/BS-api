package tk.ewentsai.contronller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import tk.ewentsai.pojo.*;
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
//
@RestController
public class Contronller {
    @RequestMapping("/api/refreshCode")
    public void refreshCode(HttpServletResponse response, HttpSession hs) throws IOException {
        response.setContentType("image/jpeg");
        ServletOutputStream sos = response.getOutputStream();
        vaildateCode vaildateCode = new vaildateCode();
        hs.setAttribute("vaildateCode",vaildateCode.getRandomCode());
        ImageIO.write(vaildateCode.getBuffImg(), "jpeg", sos);
        sos.close();
    }
//    //获取购物车信息
//    @RequestMapping("cart.do")
//    public List<Book> cart(HttpSession hs, @RequestParam(defaultValue = "0") int id) {
//        ArrayList<Book> Carts = (ArrayList<Book>) hs.getAttribute("Carts");
//        //获取当前操作购物车的用户
//        User user = (User)hs.getAttribute("user");
//        Carts = manageCart.manage(Carts,id,Integer.parseInt(user.getUid()));
//        hs.setAttribute("Carts",Carts);
//        return Carts;
//    }
//    //购物车结算
//    @RequestMapping("order.do")
//    public void orders(BigDecimal amount, HttpSession hs){
//        User user = (User)hs.getAttribute("user");
//        ArrayList<Book> Carts = (ArrayList<Book>)hs.getAttribute("Carts");
//        int uid = Integer.parseInt(user.getUid());
//        int number = Carts.size();
//        manageOrder.addOrders(uid,number,amount);
//        manageOrder.addOrder(Carts,Integer.parseInt(user.getUid()));
//    }
//    //订单删除
//    @RequestMapping("removeOrder.do")
//    public void removeOrder(int orderId){
//
//        manageOrder.removeOrderBy(orderId);
//    }
//    //订单详情信息获取
//    @RequestMapping("orderDetail.do")
//    public ArrayList orderDetail(int orderId){
//        ArrayList<singalOrder> singalOrder = manageOrder.getOrderByOrderId(orderId);
//        Orders orders = manageOrder.getOrdersByOrderId(orderId);
//        ArrayList result = new ArrayList();
//        result.add(orders);
//        result.add(singalOrder);
//        return result;
//    }
    @RequestMapping("/api/download")
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

