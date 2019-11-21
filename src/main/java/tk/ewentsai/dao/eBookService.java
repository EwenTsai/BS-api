package tk.ewentsai.dao;

import tk.ewentsai.pojo.eBook;

import java.util.ArrayList;

public interface eBookService {
    ArrayList<eBook> getAll();
    ArrayList<eBook> paginationBook(int id);
}
