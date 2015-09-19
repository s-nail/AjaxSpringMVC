package com.hengtiansoft.jia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller：当spring扫描包的时候，将表示为处理请求的一个Bean

 @RequestMapping("/test")：应该处理请求URL地址

 */
@Controller
public class HelloController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		// String str="Spring MVC  test";

		return "abc";

	}

}
