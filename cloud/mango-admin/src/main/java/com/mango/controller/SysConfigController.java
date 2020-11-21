package com.mango.controller;


import com.mango.core.common.PageRequest;
import com.mango.http.HttpResult;
import com.mango.model.SysConfig;
import com.mango.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统配置控制器
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;
	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysConfig record) {
		return HttpResult.ok(sysConfigService.save(record));
	}

	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysConfig> records) {
		return HttpResult.ok(sysConfigService.delete(records));
	}

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysConfigService.findPage(pageRequest));
	}
	
	@GetMapping(value="/findByLable")
	public HttpResult findByLable(@RequestParam String lable) {
		return HttpResult.ok(sysConfigService.findByLable(lable));
	}
}
