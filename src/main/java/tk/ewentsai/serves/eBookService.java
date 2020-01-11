package tk.ewentsai.serves;

import com.github.pagehelper.Page;
import tk.ewentsai.model.pojo.Book;
import tk.ewentsai.model.pojo.eBook;

import java.util.ArrayList;

public interface eBookService {
    Page<eBook> selAll();
}
