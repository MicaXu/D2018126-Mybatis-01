package com.ssm.controller;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/25.
 */
@Controller
public class StudentController{

    /*
    声明service层中的对外接口对象
     */



    @Resource
    private StudentService studentService;

//    配置起始页
    @RequestMapping(value = {"","/"})
    public String index(){
        return "index";

    }

    //

    /**
     * 获取学生列表数据,用于前端页面表格显示
     * 以json格式返回数据
     */
    @RequestMapping(value = "/searchStudent")
    @ResponseBody
    public BaseResult<Student> searchStudent(){
        List<Student> students = studentService.selectAll();
        /*
        将查询到的结果集进行封装
         */
        BaseResult<Student> result = new BaseResult<Student>();
        result.setTotal(7);// 设置总记录数
        result.setData(students);// 设置当前页显示数据
        return result;
    }

    @RequestMapping(value = "/pageStudent")
    @ResponseBody
    public BaseResult<Student> pageStudent(){


        BaseResult<Student> result = new BaseResult<Student>();


        return result;
    }

    /**
     * 分页查询
     * pageIndex,pageSize是miniUi前端传过来的参数
     * student接收前端页面传递过来的参数
     * @return
     */
    @RequestMapping(value ="/findStudent")
    @ResponseBody
    public BaseResult<Student> findStudent(Student student,int pageIndex,int pageSize){

        // 调用分页查询业务
        BaseResult<Student> result = studentService.pageSelect(student,pageIndex,pageSize);
        return result;

    }
}
