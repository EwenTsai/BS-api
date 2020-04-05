package site.ewentsai.serves;

import org.springframework.data.domain.Page;
import site.ewentsai.model.entity.eBook;

public interface eBookService {
    Page<eBook> selAll(int pageNum);
}
