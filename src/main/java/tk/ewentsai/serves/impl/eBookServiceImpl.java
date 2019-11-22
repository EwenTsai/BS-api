package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.dao.eBookDao;
import tk.ewentsai.pojo.eBook;
import tk.ewentsai.serves.eBookService;

import java.util.ArrayList;
@Service
public class eBookServiceImpl implements eBookService {
    @Autowired
    private eBookDao eBookDao;
    @Override
    public ArrayList<eBook> selAll() {
        return eBookDao.selAll();
    }

    @Override
    public ArrayList<eBook> paginationBook(int id) {
        return eBookDao.paginationBook(id);
    }
}
