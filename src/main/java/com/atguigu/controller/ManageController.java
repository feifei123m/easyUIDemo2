package com.atguigu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.atguigu.bean.BaseCatalog1;
import com.atguigu.bean.BaseCatalog2;
import com.atguigu.bean.BaseCatalog3;
import com.atguigu.service.ManageService;


@Controller
public class ManageController {
	
	@Autowired
	ManageService manageService;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("catalog1List")
	@ResponseBody
	public String getCatalog1List() {
		List<BaseCatalog1> catalog1List  = manageService.getCatalog1List();
		String catalog1Json = JSON.toJSONString(catalog1List);
		return catalog1Json;
	}
	
	@GetMapping("catalog2List")
	@ResponseBody
	public String getCatalog2List(HttpServletRequest request) {
		String catalog1Id = request.getParameter("catalog1Id");
		List<BaseCatalog2> catalog2List  = manageService.getCatalog2List(catalog1Id);
		String catalog2Json = JSON.toJSONString(catalog2List);
		return catalog2Json;
	}
	
	
	@GetMapping("catalog3List")
	@ResponseBody
	public String getCatalog3List(HttpServletRequest request) {
		String catalog2Id = request.getParameter("catalog2Id");
		List<BaseCatalog3> catalog3List  = manageService.getCatalog3List(catalog2Id);
		String catalog3Json = JSON.toJSONString(catalog3List);
		return catalog3Json;
	}
	
}
