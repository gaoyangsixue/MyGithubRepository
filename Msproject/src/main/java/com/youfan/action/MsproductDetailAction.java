package com.youfan.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.service.MsproductDetailService;
import com.youfan.service.MsproductService;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;

@Controller
@RequestMapping("msproductDetailAction")
public class MsproductDetailAction {
	
	@Autowired
	private MsproductDetailService msproductDetailService;
	
	@RequestMapping(value="toinsertMsproductdetail")
	public String toinsertMsproductdetail(HttpServletRequest req,int productid,int merchantid){
		req.setAttribute("productid", productid);
		req.setAttribute("merchantid", merchantid);
		return "msproductDetail/toinsertMsproductdetail";
	}
	
	@RequestMapping(value="insertMsproductdetail",method=RequestMethod.POST)
	public String insertMsproductdetail(Msproductdetail msproductdetail){
		msproductDetailService.insertMsproductdetail(msproductdetail);
		return "redirect:/msproductAction/listmsproduct";
	}
	
	
	
	@RequestMapping(value="queryMsproductdetailByid")
	public String queryMsproductdetailByid(HttpServletRequest req,int productid){
		Msproductdetail msproductdetail = msproductDetailService.queryMsproductdetailByid(productid);
		req.setAttribute("msproductdetail", msproductdetail);
		return "msproductDetail/msproductdetailview";
	}
	
	@RequestMapping(value="toupdateMsproductdetail")
	public String toupdateMsproductdetail(HttpServletRequest req,int productid){
		Msproductdetail msproductdetail = msproductDetailService.queryMsproductdetailByid(productid);
		req.setAttribute("msproductdetail", msproductdetail);
		return "msproductDetail/toupdateMsproductdetail";
	}
	
	@RequestMapping(value="updateMsproductdetail",method=RequestMethod.POST)
	public String updateMsproductdetail(HttpServletRequest req,Msproductdetail msproductdetail){
		msproductDetailService.updateMsproductdetail(msproductdetail);
		return "redirect:/msproductAction/listmsproduct";
	}
	
}
