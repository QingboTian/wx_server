package com.tqb.score.serivce.impl;

import com.tqb.score.SearchVO;
import com.tqb.score.dao.StudentMapper;
import com.tqb.score.pojo.Student;
import com.tqb.score.pojo.StudentExample;
import com.tqb.score.serivce.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/29 12:39
 * @Version v1.0
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public boolean isExit(String stuNum) {
        StudentExample example = new StudentExample();
        example.createCriteria().andStunumEqualTo(stuNum.trim());
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size() == 0)
            return false;
        else
            return true;
    }

    @Override
    public void add(SearchVO vo) {
        Student student = new Student();
        student.setStunum(vo.getStuNum());
        student.setPwd(vo.getPwd());
        student.setSchoolId(Integer.parseInt(vo.getSchool()));
        studentMapper.insert(student);
    }


}
