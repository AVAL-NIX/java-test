package com.mango.controller;


import com.mango.core.common.PageRequest;
import com.mango.http.HttpResult;
import com.mango.model.SysLog;
import com.mango.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 操作日志控制器
 * @author zhengxin
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("log")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysLogService.findPage(pageRequest));
	}
	
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysLog> records) {
		return HttpResult.ok(sysLogService.delete(records));
	}
}
