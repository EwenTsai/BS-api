package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.eBookRepository;
import tk.ewentsai.model.entity.eBook;
import tk.ewentsai.serves.eBookService;

@Service
public class eBookServiceImpl implements eBookService {

    @Autowired
    private eBookRepository eBookRepository;

    @Override
    public Page<eBook> selAll(int pageNum) { return eBookRepository.findAll(PageRequest.of(pageNum, 10)); }

}
