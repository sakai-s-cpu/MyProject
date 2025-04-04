package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.account.data.AccountData;

@Controller
public class MyController
{	
	// 「バリデーション」を行うときは、「Form-Backing Bean」の設定が必要になる。
	//　「Form-Backing Bean」の初期化は 「@ModelAttribute」アノテーションを付与したメソッドでおこなう
	@ModelAttribute
	public AccountData setUpAccountData()
	{
		return new AccountData();
	}
	
	@GetMapping("/")
	public String mainPage()
	{
		return "MainPage";
	}
	
	@GetMapping("page1")
	public String page1()
	{
		return "Page1";
	}
	
	@GetMapping("page2")
	public String page2()
	{
		return "Page2";
	}
	
	@GetMapping("contactUs")
	public String contactUsPage()
	{
		return "ContactUs";
	}
	
	@PostMapping("Login")
	public String Login(Model model, @Validated AccountData data, BindingResult bindingResult)
	{
		// 入力チェック
		if(bindingResult.hasErrors())
		{
			// 入力チェックNG
			return "ContactUs";
		}
		
		// modelに格納する
        model.addAttribute("accountData", data);
		return "LoginPage";
	}
	
/*	@PostMapping("Login")
	public String Login(Model model, @RequestParam String mailadress, @RequestParam String password )
	{
		// modelに格納する
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		return "LoginPage";
	}*/
}