package site.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import site.ewentsai.serves.eBookService;
import site.ewentsai.model.dao.eBookRepository;
import site.ewentsai.model.entity.eBook;

@Service
public class eBookServiceImpl implements eBookService {

    @Autowired
    private eBookRepository eBookRepository;

    @Override
    public Page<eBook> selAll(int pageNum) { return eBookRepository.findAll(PageRequest.of(pageNum, 10)); }

}
