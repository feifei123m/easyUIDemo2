package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.BaseAttrInfo;
import com.atguigu.bean.BaseCatalog1;
import com.atguigu.bean.BaseCatalog2;
import com.atguigu.bean.BaseCatalog3;






public interface ManageService {

	
	public List<BaseCatalog1>  getCatalog1List();
	
	
	public List<BaseCatalog2> getCatalog2List(String catalog1Id);
	
	public List<BaseCatalog3> getCatalog3List(String catalog2Id);
	
	
	public  List<BaseAttrInfo> getAttrInfoList(String catalog3Id);
	
	public void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
