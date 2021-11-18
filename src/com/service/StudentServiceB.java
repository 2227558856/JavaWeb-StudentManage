package com.service;

import com.common.module.Student;
import com.dao.Impl.StudentDaoImplB;

import java.util.List;
import java.util.Objects;

/**
 * 逻辑实现
 * @author Administrator
 */
public class StudentServiceB {
    private StudentDaoImplB dao=new StudentDaoImplB();

    public boolean login(String name,String password){
        Student student=dao.get(name);
        if(student==null){
            System.out.println("用户不存在!");
            return false;
        }
        if(!Objects.equals(student.getPassword(), password)){
            System.out.println("密码错误!");
            return false;
        }
        System.out.println("登录成功!");
        return true;
    }

    public boolean register(String name,String password,String phone){
        Student student=dao.get(name);
        if(student!=null){
            System.out.println("用户已存在!");
            return false;
        }
        Student New=new Student();
        New.setName(name);
        New.setPassword(password);
        New.setPhone(phone);
        return dao.add(New);
    }

    public List<Student> all(){
        return dao.allStudent();
    }

    public boolean delete(String name){
        Student student=dao.get(name);
        if(student==null){
            System.out.println("用户不存在!");
            return false;
        }
        else{
            return dao.delete(name);
        }
    }

    public boolean update(String name,String password,String phone){
        Student student=dao.get(name);
        if(student==null){
            System.out.println("用户不存在!");
            return false;
        }
        else{
            return dao.update(name,password,phone);
        }
    }

    public Student find(String name){
        Student student=dao.get(name);
        if(student==null){
            System.out.println("用户不存在!");
            return null;
        }
        else{
            return dao.get(name);
        }
    }

    public boolean add(String name,String password,String phone){
        Student student=dao.get(name);
        if(student!=null){
            System.out.println("用户已存在!");
            return false;
        }
        Student New=new Student();
        New.setName(name);
        New.setPassword(password);
        New.setPhone(phone);
        return dao.add(New);
    }
}
