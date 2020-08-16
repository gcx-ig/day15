package com.xiaoshu.service;

import java.util.List;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.MajorMapper;
import com.xiaoshu.dao.StuMapper;
import com.xiaoshu.entity.Major;
import com.xiaoshu.entity.Stu;
import com.xiaoshu.entity.StuVo;


@Service
public class StuService {

	@Autowired
	private StuMapper stuMapper;

	@Autowired
	private MajorMapper majorMapper;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination queueTextDestination;
	
	public PageInfo<StuVo> findPage(StuVo stuVo,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<StuVo> list = stuMapper.findAll(stuVo);
		return new PageInfo<>(list);
	}
	public List<Major> findAllM(){
		return majorMapper.selectAll();
	}
	public void addS(Stu stu){
		stuMapper.insert(stu);
	}
	public void updateS(Stu stu){
		stuMapper.updateByPrimaryKeySelective(stu);
	}
	public Stu findByName(String name){
		Stu param = new Stu();
		param.setSdName(name);
		return stuMapper.selectOne(param );
	}
	public List<StuVo> findAll(StuVo stuVo){
		
		return stuMapper.findAll(stuVo);
	}
	public void delS(Integer id){
		stuMapper.deleteByPrimaryKey(id);
	}
	public List<StuVo> findE(){
		return stuMapper.findE();
	}
	public void addM(Major major){
		
		majorMapper.insert(major);
		String mdname = major.getMdname();
		
		Major param = new Major();
		param.setMdname(mdname);
		Major major2 = majorMapper.selectOne(param);
		jmsTemplate.convertAndSend(queueTextDestination,JSONObject.toJSONString(major2));
	}
}
