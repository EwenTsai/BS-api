package tk.ewentsai.serves;

import tk.ewentsai.pojo.eBook;

import java.util.ArrayList;

public interface eBookService {
    ArrayList<eBook> selAll();
    ArrayList<eBook> paginationBook(int id);
}
