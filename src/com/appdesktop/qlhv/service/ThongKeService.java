/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.qlhv.service;

import com.appdesktop.qlhv.bean.KhoaHocBean;
import com.appdesktop.qlhv.bean.LopHocBean;
import java.util.List;

/**
 *
 * @author MinhPhu
 */
public interface ThongKeService {
    public List<LopHocBean> getListByLopHoc();
    public List<KhoaHocBean> getListByKhoaHoc();
}
