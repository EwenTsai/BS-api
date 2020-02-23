package tk.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ewentsai.model.entity.eBook;

import java.util.List;

public interface eBookRepository extends JpaRepository<eBook,String> {
    List<eBook> findAll();
}
