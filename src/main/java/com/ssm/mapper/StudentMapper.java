package com.ssm.mapper;

/**
 * Created by dllo on 18/1/26.
 */

import com.ssm.domain.Student;
import com.ssm.page.PageBean;

import java.util.List;

/**
 * student操作的对外接口声明
 * 具体实现见student.xml
 */
public interface StudentMapper {

    /**
     * 查询所有学生列表
     * 方法名对应student.xml中的id属性
     * 方法参数对应student.xml中的parameterType属性
     * 方法返回值对象student.xmL中的resultType属性
     */
    List<Student> selectAll();

    /**
     * 分页查询
     * pageBean中包含分页信息
     */
    List<Student> pageSelect(PageBean<Student> pageBean);

    /**
     * 获取学生表总条数
     */
    Integer getTotalRecord(PageBean<Student> pageBean);

}
