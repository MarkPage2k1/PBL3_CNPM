
package com.appdesktop.qlhv.dao;

import com.appdesktop.qlhv.bean.KhoaHocBean;
import com.appdesktop.qlhv.bean.LopHocBean;
import java.util.List;

/**
 *
 * @author MinhPhu
 */
public interface ThongKeDAO {
    
    public List<LopHocBean> getListByLopHoc();
    public List<KhoaHocBean> getListByKhoaHoc();
    
}