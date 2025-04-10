package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.account.data.AccountData;
import com.example.demo.score.data.ScoreData;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyController
{	
	//private final RankingDataMapper mapper;
	
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
	public String page1(Model model)
	{
		// スコアデータを生成
		ScoreData scoreData = new ScoreData();
        model.addAttribute("scoreData", scoreData);
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
	
	// フォームから送信されるデータとバインドされるように設定
	@PostMapping("ranking")
	public String Ranking(Model model, @ModelAttribute("scoreData") ScoreData data)
	{
		// modelに格納する
        model.addAttribute("scoreData", data);
		return "Ranking";
	}
	
	// フォームから送信されるデータとバインドされるように設定
	@PostMapping("result")
	public String Result(Model model, @ModelAttribute("scoreData") ScoreData data)
	{
		// modelに格納する
        model.addAttribute("scoreData", data);
		return "Result";
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
}