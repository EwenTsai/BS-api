package tk.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<eBook> pagination(@RequestParam(defaultValue = "0") int pageNum){ return eBookService.selAll(pageNum); }
}
