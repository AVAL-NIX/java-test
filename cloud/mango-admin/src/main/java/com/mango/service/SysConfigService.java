package com.mango.service;

import com.mango.core.service.CurdService;
import com.mango.model.SysConfig;

import java.util.List;

/**
 * 系统配置管理
 * @author zhengxin
 * @date Jan 13, 2019
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
