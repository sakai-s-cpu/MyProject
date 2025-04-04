package com.example.demo.account.data;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AccountData 
{
	//@Email(message = "※入力フォーマットが正しくありません")
	@NotBlank(message = "※メールアドレス欄が未入力です")
	private String email;
	
	@NotBlank(message = "※パスワード欄が未入力です")
	private String password;
}
