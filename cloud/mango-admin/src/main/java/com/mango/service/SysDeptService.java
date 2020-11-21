package com.mango.service;

import com.mango.core.service.CurdService;
import com.mango.model.SysDept;

import java.util.List;

/**
 * 机构管理
 * @author zhengxin
 * @date Jan 13, 2019
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
