package com.xiaoshu.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshu.entity.Major;

import redis.clients.jedis.Jedis;

public class MyMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage msg = (TextMessage)message;
		try {
			String json = msg.getText();
			System.out.println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<"+json);
			Major major = JSONObject.parseObject(json,Major.class);
			Jedis jedis = new Jedis("127.0.0.1",6379);
			jedis.set(major.getMdname(), major.getMdId()+"");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
