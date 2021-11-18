package com.dao.Impl;

import com.common.module.Student;
import com.dao.StudentDao;
import com.db.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * Dao接口的方法实现
 */
public class StudentDaoImplA implements StudentDao {
    @Override
    public boolean add(Student student) {
        try{
            Connection connection=DbConnect.getConnection();
            String sql="insert into studenta(name,password,phone) values(?,?,?)";
            PreparedStatement pt=connection.prepareStatement(sql);
            //将信息放到sql语句中问号的位置
            pt.setString(1,student.getName());
            pt.setString(2,student.getPassword());
            pt.setString(3,student.getPhone());
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String name) {
        try{
            Connection connection=DbConnect.getConnection();
            String sql="delete from studenta where is_delete=0 and name=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,name);
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(String name,String password,String phone) {
        try{
            Connection connection=DbConnect.getConnection();
            String sql="update studenta set password=? , phone=? where is_delete=0 and name=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,password);
            pt.setString(2,phone);
            pt.setString(3,name);
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student get(String name) {
        try{
            Connection connection=DbConnect.getConnection();
            String sql="select * from studenta where is_delete=0 and name=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,name);
            ResultSet rs=pt.executeQuery();
            Student student=new Student();
            if(rs.next()){
                student.setId(rs.getLong("id"));
                student.setCreatedTime(rs.getDate("createTime"));
                student.setUpdatedTime(rs.getDate("updateTime"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setPhone(rs.getString("phone"));
                return student;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> allStudent() {
        try{
            List<Student> students=new ArrayList<>();
            Connection connection=DbConnect.getConnection();
            String sql="select * from studenta where is_delete=0";
            PreparedStatement pt=connection.prepareStatement(sql);
            ResultSet rs=pt.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setId(rs.getLong("id"));
                student.setCreatedTime(rs.getDate("createTime"));
                student.setUpdatedTime(rs.getDate("updateTime"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setPhone(rs.getString("phone"));
                students.add(student);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
