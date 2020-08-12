package com.xiaoshu.dao;

import java.util.List;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;

public interface StudentMapper extends BaseMapper<Student> {

	List<StudentVo> findAll(StudentVo studentVo);

	List<StudentVo> countStudent();
}