package tk.ewentsai.contronller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.model.entity.eBook;
import tk.ewentsai.serves.eBookService;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class EBookContronller {
    @Autowired
    private eBookService eBookService;
    //分页显示
    @RequestMapping("/api/EBook")
    public PageInfo<eBook> pagination(@RequestParam(defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum,10);
        PageInfo<eBook> ebookList = new PageInfo<>(eBookService.selAll());
        return ebookList;
    }
}
