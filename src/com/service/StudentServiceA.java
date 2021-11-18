package com.service;

import com.common.module.Student;
import com.dao.Impl.StudentDaoImplA;

import java.util.List;
import java.util.Objects;

/**
 * 逻辑实现
 * @author Administrator
 */
public class StudentServiceA {
    private StudentDaoImplA dao=new StudentDaoImplA();


    /**
     * 登录
     * @param name 根据姓名查找是否已注册
     * @param password 根据密码匹配是否登录成功
     * @return 返回结果
     */
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

    /**
     * 注册
     * @param name 注册姓名(根据姓名判断能否注册)
     * @param password 注册密码
     * @param phone 注册手机号
     * @return 返回是否注册成功
     */
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

    /**
     * 学生管理
     * 1.显示学生数据
     * @return 返回所有学生数据
     */
    public List<Student> all(){
        return dao.allStudent();
    }

    /**
     * 学生管理
     * 2.删除学生数据
     * @param name
     * @return 返回是否删除成功
     */
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

    /**
     * 学生管理
     * 3.更新学生数据
     * @param name
     * @return 返回是否更新成功
     */
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

    /**
     * 学生管理
     * 4.查询学生数据
     * @param name
     * @return 返回该学生数据
     */
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

    /**
     * 添加学生数据
     * @param name
     * @param password
     * @param phone
     * @return 返回是否成功
     */
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
