package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.RankingData;

@Mapper
public interface RankingDataMapper 
{
	// 全てのランキングデータを所得
	List<RankingData> selectAll();
	
	// 登録
	void insert(RankingData data);
}
