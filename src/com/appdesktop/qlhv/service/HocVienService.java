package com.appdesktop.qlhv.service;

import com.appdesktop.qlhv.model.HocVien;
import java.util.List;

public interface HocVienService {
    public List<HocVien> getList();
    public int createOrUpdate(HocVien hocVien);
}
