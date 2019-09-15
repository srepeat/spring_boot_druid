package com.sxt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.domain.Person;

@Controller
@RequestMapping("person")
public class PersonController {

	
	/***
	 * 加载所有person数据  返回json
	 */
	@RequestMapping("loadAllPerson")
	@ResponseBody
	public Map<String,Object> loadAllPerson(Integer page,Integer limit){
		Map<String,Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 10);
		List<Person> persons=new ArrayList<>();
		for (int i = 1; i <=10; i++) {
//			persons.add(new Person(i, "小明"+i, "武汉"+i, new Random().nextBoolean()?1:0));
			persons.add(new Person(i, "小明"+i, "武汉"+i, new Random().nextDouble()>=0.5?1:0));
		}
		map.put("data", persons);
		return map;
	}
}
