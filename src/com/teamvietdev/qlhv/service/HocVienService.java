
package com.teamvietdev.qlhv.service;

import com.teamvietdev.qlhv.model.HocVien;
import java.util.List;

public interface HocVienService 
{
    public List<HocVien> getList();
    public int createOrUpdate(HocVien hocVien);
}
