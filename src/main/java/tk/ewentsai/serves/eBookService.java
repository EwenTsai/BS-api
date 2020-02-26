package tk.ewentsai.serves;

import org.springframework.data.domain.Page;
import tk.ewentsai.model.entity.eBook;

public interface eBookService {
    Page<eBook> selAll(int pageNum);
}
