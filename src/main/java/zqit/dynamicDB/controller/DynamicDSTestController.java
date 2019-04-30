package zqit.dynamicDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import zqit.dynamicDB.service.DynamicDSTestService;

@Controller
@RequestMapping("/dynamicDSTest")
public class DynamicDSTestController {

	@Autowired
	DynamicDSTestService dynamicDSTestService;

	// 测试多数据源A
	@ResponseBody
	@GetMapping("/dynamicDSA")
	public Object dynamicDSA() throws JsonProcessingException {
		Object userListA = dynamicDSTestService.getUserListA();
		return userListA;
	}

	// 测试多数据源B
	@ResponseBody
	@GetMapping("/dynamicDSB")
	public Object dynamicDSB() throws JsonProcessingException {
		Object userListB = dynamicDSTestService.getUserListB();
		return userListB;
	}
	
	@ResponseBody
	@GetMapping("/dynamicDSDef")
	public Object dynamicDSDef() throws JsonProcessingException {
		Object userListC = dynamicDSTestService.getUserListC();
		return userListC;
	}

}
