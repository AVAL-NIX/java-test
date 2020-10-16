package com.mango.service.impl;

import com.mango.core.common.MyBatisPageHelper;
import com.mango.core.common.PageRequest;
import com.mango.core.common.PageResult;
import com.mango.dao.SysLogMapper;
import com.mango.model.SysLog;
import com.mango.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl  implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;

	@Override
	public int save(SysLog record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysLogMapper.insertSelective(record);
		}
		return sysLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLog record) {
		return sysLogMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLog> records) {
		for(SysLog record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLog findById(Long id) {
		return sysLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParam("userName");
		if(label != null) {
			return MyBatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", label);
		}
		return MyBatisPageHelper.findPage(pageRequest, sysLogMapper);
	}
	
}
