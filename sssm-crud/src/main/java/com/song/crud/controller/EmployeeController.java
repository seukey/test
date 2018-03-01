package com.song.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.crud.bean.Employee;
import com.song.crud.service.EmployeeService;

/**
 * 处理员工增删改查请求
 * */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	/**
	 * 查询员工数据（分页查询）
	 * */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//这是一个分页查询
		//引入PageHelper分页插件
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的这个查询是一个分页查询
		
		List<Employee> emps = employeeService.getAll();
		//包装查询后的结果
		//连续显示5页
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo",page);
		
		return "list";
	}
}
