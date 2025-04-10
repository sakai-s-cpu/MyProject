package com.example.demo.score.data;

import lombok.Data;

@Data
public class ScoreData 
{
	private Integer score = 0;
	
	public Integer getScore()
	{
	    return score;
	}
}
