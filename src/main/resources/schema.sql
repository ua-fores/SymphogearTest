--playersがあれば削除
DROP TABLE IF EXISTS symphogear_players;

--playersがなければ新しく作成
CREATE TABLE IF NOT EXISTS symphogear_players(
id VARCHAR(20) NOT NULL,
name VARCHAR(20) NOT NULL,
symphogear_name VARCHAR(20) NOT NULL,
PRIMARY KEY(id)
);
