package tk.ewentsai.contronller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.ewentsai.serves.BookService;
import tk.ewentsai.serves.OrdersService;
import tk.ewentsai.serves.eBookService;
import tk.ewentsai.common.unit.vaildateCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
public class Contronller {
    @Autowired
    private BookService bookService;
    @Autowired
    private eBookService eBookService;
    @Autowired
    private OrdersService ordersService;


    //验证码刷新
    @RequestMapping("/api/refreshCode")
    public void refreshCode(HttpServletResponse response, HttpSession hs) throws IOException {
        response.setContentType("image/jpeg");
        ServletOutputStream sos = response.getOutputStream();
        vaildateCode vaildateCode = new vaildateCode();
        hs.setAttribute("vaildateCode",vaildateCode.getRandomCode());
        ImageIO.write(vaildateCode.getBuffImg(), "jpeg", sos);
        sos.close();
    }
    //下载资源
    @RequestMapping("/api/download")
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException{
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