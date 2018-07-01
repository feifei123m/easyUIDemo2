package com.atguigu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.BaseAttrInfo;
import com.atguigu.bean.BaseAttrValue;
import com.atguigu.bean.BaseCatalog1;
import com.atguigu.bean.BaseCatalog2;
import com.atguigu.bean.BaseCatalog3;
import com.atguigu.mapping.BaseAttrInfoMapper;
import com.atguigu.mapping.BaseAttrValueMapper;
import com.atguigu.mapping.BaseCatalog1Mapper;
import com.atguigu.mapping.BaseCatalog2Mapper;
import com.atguigu.mapping.BaseCatalog3Mapper;
import com.atguigu.service.ManageService;

@Service
public class ManageServiceImpl implements ManageService{
	
	@Autowired
	BaseCatalog1Mapper baseCatalog1Mapper;
	
	@Autowired
	BaseCatalog2Mapper baseCatalog2Mapper;
	
	@Autowired
	BaseCatalog3Mapper baseCatalog3Mapper;
	
	@Autowired
	BaseAttrInfoMapper baseAttrInfoMapper;
	
	@Autowired
	BaseAttrValueMapper baseAttrValueMapper;

	@Override
	public List<BaseCatalog1> getCatalog1List() {
		List<BaseCatalog1> catalog1List = baseCatalog1Mapper.selectAll();
		return catalog1List;
	}

	@Override
	public List<BaseCatalog2> getCatalog2List(String catalog1Id) {
	
		BaseCatalog2 baseCatalog2 = new BaseCatalog2();
		baseCatalog2.setCatalog1Id(catalog1Id);
		List<BaseCatalog2>catalog2List = baseCatalog2Mapper.select(baseCatalog2);
		
		
		return catalog2List;
	}
	
	
	@Override
	public List<BaseCatalog3> getCatalog3List(String catalog2Id) {
	
		BaseCatalog3 baseCatalog3 = new BaseCatalog3();
		baseCatalog3.setCatalog2Id(catalog2Id);
		List<BaseCatalog3>catalog3List = baseCatalog3Mapper.select(baseCatalog3);
		
		return catalog3List;
	}

	@Override
	public List<BaseAttrInfo> getAttrInfoList(String catalog3Id) {
		BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
		baseAttrInfo.setCatalog3Id(catalog3Id);
		List<BaseAttrInfo> attrInfoList = baseAttrInfoMapper.select(baseAttrInfo);
		
		return attrInfoList;
	}

	@Override
	public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
		baseAttrInfoMapper.insertSelective(baseAttrInfo);
		List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
		for (BaseAttrValue baseAttrValue : attrValueList) {
			baseAttrValue.setAttrId(baseAttrInfo.getId());
			baseAttrValueMapper.insertSelective(baseAttrValue);
		}
	}
}
