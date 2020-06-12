package com.youfan.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.service.MsoderService;
import com.youfan.service.MsproductDetailService;
import com.youfan.service.MsproductService;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;

@Controller
@RequestMapping("pagehomeAction")
public class PagehomeAction {
	
	@Autowired
	private MsproductService msproductService;
	
	@Autowired
	private MsoderService msoderService;
	
	@Autowired
	private MsproductDetailService msproductDetailService;
	
	@RequestMapping("tohome")
	public String tohome(HttpServletRequest req){
		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowstring = dateFormat.format(now);
		constomProduct.setStartendtime(nowstring);
		constomProduct.setAuditstate(2);
		msProductVo.setConstomProduct(constomProduct);
//		private Date startstarttime;//秒杀开始时间查询范围开始时间
//		private Date endstarttime;//秒杀开始时间查询范围结束时间
		msProductVo.setConstomProduct(constomProduct);
		List<Msproductinfo> list = msproductService.listmsproduct(msProductVo);
		req.setAttribute("list", list);
		return "homepage/homepage";
}
	
	@RequestMapping("viewproductdetail")
	public String viewproductdetail(HttpServletRequest req,int id){
		Msproductinfo msproduct = msproductService.querymsproductByid(id);
		Msproductdetail msproductdetail = msproductDetailService.queryMsproductdetailByid(id);
		req.setAttribute("msproduct", msproduct);
		req.setAttribute("msproductdetail", msproductdetail);
		return "order/selldetail";
	}
	
}
