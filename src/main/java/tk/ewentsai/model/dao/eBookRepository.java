package tk.ewentsai.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tk.ewentsai.model.entity.eBook;

public interface eBookRepository extends JpaRepository<eBook,String> {
    Page<eBook> findAll(Pageable pageable);
}
