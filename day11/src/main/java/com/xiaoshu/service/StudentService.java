package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CourseMapper;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.entity.Course;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;

@Service
public class StudentService {

	@Autowired
	private StudentMapper sm;
	
	@Autowired
	private CourseMapper cm;

	public PageInfo<StudentVo> findPage(StudentVo studentVo,Integer pageNum,Integer pageSize,String ordername,String order){
		PageHelper.startPage(pageNum, pageSize);
		List<StudentVo> list = sm.findAll(studentVo);
		PageInfo<StudentVo> page = new PageInfo<>(list);
		return page;
	}

	public List<Course> findCourse(){
		List<Course> list = cm.selectAll();
		return list;
	}
	public Student findByName(String name){
		Student param = new Student();
		param.setName(name);
		return sm.selectOne(param );
	}
	public void addStu(Student student){
		sm.insert(student);
	}
	public void updateStu(Student student){
		sm.updateByPrimaryKeySelective(student);
	}
	public void deleteStu(Integer id){
		sm.deleteByPrimaryKey(id);
	}

	public Course findBycode(String code) {
		Course param = new Course();
		param.setCode(code);
		return cm.selectOne(param );
	}

	public void addCou(Course course) {
		cm.insert(course);
	}
	public List<StudentVo> countStudent(){
		return sm.countStudent();
	}

	public List<Course> findList(Course course) {
		return cm.findAll(course);
	}
}
