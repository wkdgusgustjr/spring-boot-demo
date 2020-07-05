package com.example.demo.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.test.service.TestService;
import com.example.demo.test.vo.TestVo;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/home")
	public String home() {
		return "index.html";
	}
	
	@ResponseBody
	@RequestMapping("/valueTest")
	public String valueTest() {
		String value = "테스트 String";
		return value;
	}
	
	@RequestMapping("/test")
	public ModelAndView test() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<TestVo> testList = testService.selectTest();
		mav.addObject("list", testList);
		return mav;
	}
	
	@RequestMapping("/thymeleafTest")
	public String thymeleafTest(Model model) {
		TestVo testModel = new TestVo("chs", "최현석");
		model.addAttribute("testModel", testModel);
		
		return "thymeleaf/thymeleafTest";
	}
}

