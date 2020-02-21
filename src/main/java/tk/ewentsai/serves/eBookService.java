package tk.ewentsai.serves;

import com.github.pagehelper.Page;
import tk.ewentsai.model.entity.eBook;

public interface eBookService {
    Page<eBook> selAll();
}
