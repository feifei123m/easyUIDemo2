package com.atguigu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.atguigu.bean.BaseAttrInfo;
import com.atguigu.service.ManageService;

@Controller
public class AttrInfoController {
	
	@Autowired
	ManageService manageService;
	
	@GetMapping("attrListPage")
	public String attrListPage() {
		return "attrListPage";
	}
	
	@GetMapping("attrInfoList")
	@ResponseBody
	public String getAttrInfoList(HttpServletRequest request) {
		String catalog3Id = request.getParameter("catalog3Id");
		List<BaseAttrInfo> baseAttrInfoList  = manageService.getAttrInfoList(catalog3Id);
		String baseAttrInfoJson = JSON.toJSONString(baseAttrInfoList);
		return baseAttrInfoJson;
	}
	@PostMapping("saveAttrInfo")
	@ResponseBody
	public String saveAttrInfo(BaseAttrInfo saveAttrInfo) {
		manageService.saveAttrInfo(saveAttrInfo);
		String success = JSON.toJSONString("success");
		return success;
	}
}


