-- テーブルが存在したら削除する
drop table if exists rankingData;

-- テーブルの作成
CREATE TABLE rankingData
(
	-- ユーザー名
    username VARCHAR(255) NOT NULL,
	-- スコア
    score INT NOT NULL,
)