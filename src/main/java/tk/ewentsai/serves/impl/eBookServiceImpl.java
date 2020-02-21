package tk.ewentsai.serves.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.eBookDao;
import tk.ewentsai.model.entity.eBook;
import tk.ewentsai.serves.eBookService;

@Service
public class eBookServiceImpl implements eBookService {
    @Autowired
    private eBookDao eBookDao;

    @Override
    public Page<eBook> selAll() { return eBookDao.selAll(); }

}
