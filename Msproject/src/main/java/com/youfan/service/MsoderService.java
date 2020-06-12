package com.youfan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youfan.dao.MsOrderDao;
import com.youfan.enity.Msorder;
import com.youfan.vo.order.ConstomOrder;
import com.youfan.vo.order.MsorderVo;

@Service
public class MsoderService {
	
	@Autowired
	MsOrderDao msOrderDao;
	
	public void insertMsOrder(Msorder msorder){
		msOrderDao.insertMsOrder(msorder);
	}
	
	public List<Msorder> queryorderbyuserid(int userid){
		return msOrderDao.queryorderbyuserid(userid);
	}
	
	public List<Msorder> queryorderbymerchantid(int merchantid){
		return msOrderDao.queryorderbymerchantid(merchantid);
	}
	
	public void updateorderpaystatusbyid(int paystatus,int id,int paytype){
		MsorderVo msorderVo = new MsorderVo();
		ConstomOrder constomOrder = new ConstomOrder();
		constomOrder.setPaystatus(paystatus);
		constomOrder.setId(id);
		constomOrder.setPaytype(paytype);
		msorderVo.setConstomOrder(constomOrder);
		msOrderDao.updateorderpaystatusbyid(msorderVo);
	}
}
