/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Class_Admin;
import java.util.List;

/**
 *
 * @author Duy Ngoc <duylengoc1111@gmail.com>
 */
public interface Class_AdminDAO 
{
    List<Class_Admin> getAll_ClassAdmin();
    public Class_Admin getClass_AdminByID(String idclass_admin);
    public String getId_class_teacher(String idclass, String idcourse);
    public List<Class_Admin> getAll_ClassAdminbyID(String idCourse);
    boolean InsertClass(String idClass, String idCourse, String idteacher);
    public boolean UpdateClass(String idClass, String idCourse, String idteacher, String id_class_teacher);
    boolean DeleteClass(String idclass);
    
}
