package com.ewentsai.dao;

import com.ewentsai.pojo.eBook;

import java.util.ArrayList;

public class eBookServiceImpl implements eBookService {
    private eBookMapper eBookMapper;

    public eBookMapper geteBookMapper(){return eBookMapper;}
    public void seteBookMapper(eBookMapper eBookMapper){this.eBookMapper=eBookMapper;}

    @Override
    public ArrayList<eBook> getAll() {
        return eBookMapper.selAll();
    }

    @Override
    public ArrayList<eBook> paginationBook(int id) {
        return eBookMapper.paginationBook(id);
    }
}
