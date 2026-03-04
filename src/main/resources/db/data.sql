-- user dummy data
INSERT INTO user_tb (username, password, created_at) VALUES ('ssar', '1234', NOW());
INSERT INTO user_tb (username, password, created_at) VALUES ('cos', '1234', NOW());

-- board dummy data
INSERT INTO board_tb (title, content, user_id, created_at) VALUES ('first board', 'hello, this is ssar first board', 1, NOW());
INSERT INTO board_tb (title, content, user_id, created_at) VALUES ('second board', 'hello, this is ssar second board', 1, NOW());
INSERT INTO board_tb (title, content, user_id, created_at) VALUES ('third board', 'hello, this is cos first board', 2, NOW());

-- reply dummy data
INSERT INTO reply_tb (comment, user_id, board_id, created_at) VALUES ('first reply', 1, 1, NOW());
INSERT INTO reply_tb (comment, user_id, board_id, created_at) VALUES ('second reply', 2, 1, NOW());
