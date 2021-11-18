package com.dao;

import com.common.module.Student;

import java.util.List;

/**
 * @author Administrator
 * Dao接口
 */
public interface StudentDao {
    /**
     * 新增学生数据
     * @param student
     * @return 返回是否添加成功
     * 只需要添加student中的姓名,密码,手机号
     */
    public boolean add(Student student);

    /**
     * 按姓名删除学生数据
     * @param name
     * @return 返回是否删除成功
     */
    public boolean delete(String name);

    /**
     * 更新学生数据
     * @param name 想要更新的学生姓名
     * @param password 更新后密码
     * @param phone 更新后手机号
     * @return 返回是否更新成功
     */
    public boolean update(String name,String password,String phone);

    /**
     *按姓名查询学生数据
     * @param name
     * @return 返回查询结果
     */
    public Student get(String name);

    /**
     * 查询学生数据
     * @return 返回所有学生数据
     */
    public List<Student> allStudent();
}
