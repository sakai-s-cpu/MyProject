-- テーブルが存在したら削除する
drop table if exists accountdata;

-- テーブルの作成
CREATE TABLE accountdata
(
	-- id(ユーザーID)：主キー
	id serial primary key,
	-- UNIQUE制約により、一意の値でなければなりません。同じメールアドレスを複数登録することはできない
	email VARCHAR(100) UNIQUE,
	-- パスワードのハッシュ値を格納
	password_hash VARCHAR(255)
)