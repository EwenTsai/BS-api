package site.ewentsai.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import site.ewentsai.model.entity.eBook;

public interface eBookRepository extends JpaRepository<eBook,String> {
    Page<eBook> findAll(Pageable pageable);
}
