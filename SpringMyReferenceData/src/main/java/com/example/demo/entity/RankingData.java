package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor			// (引数無しのコンストラクタを自動生成)
@AllArgsConstructor			// (全てのフィールドを引数として持つコンストラクタを自動生成)
public class RankingData 
{
	private Integer rank;
	private Integer score;
	private String username;
}
