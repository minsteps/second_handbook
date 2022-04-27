use secondHand_book;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS tb_admin;
CREATE TABLE tb_admin (
admin_id int(0) NOT NULL AUTO_INCREMENT,
password varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (admin_id) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS tb_answer;
CREATE TABLE tb_answer (
ans_id int(0) NOT NULL AUTO_INCREMENT,
book_id int(0) NOT NULL,
com_text varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
user_id int(0) NULL DEFAULT NULL,
com_id int(0) NULL DEFAULT NULL,
com_no int(0)  NOT NULL DEFAULT 1,
PRIMARY KEY (ans_id) USING BTREE,
INDEX user_id(user_id) USING BTREE,
INDEX book_id(book_id) USING BTREE,
CONSTRAINT answer_ibfk_1 FOREIGN KEY (user_id) REFERENCES tb_user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT answer_ibfk_2 FOREIGN KEY (book_id) REFERENCES tb_book(book_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT answer_ibfk_3 FOREIGN KEY (com_id) REFERENCES tb_comment(com_id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS tb_book;
CREATE TABLE tb_book (
book_id int(0) NOT NULL AUTO_INCREMENT,
user_id int(0) NOT NULL,
msg tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
price double NULL DEFAULT NULL,
publish int(0) NOT NULL DEFAULT 0,
close_com int(0) NOT NULL DEFAULT 1,
ban int(0) NOT NULL DEFAULT 0,
PRIMARY KEY (book_id) USING BTREE,
INDEX user_id(user_id) USING BTREE,
CONSTRAINT book_ibfk_1 FOREIGN KEY (user_id) REFERENCES tb_user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS tb_comment;
CREATE TABLE tb_comment  (
  com_id int(0) NOT NULL AUTO_INCREMENT,
  book_id int(0) NOT NULL,
  com_text varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  user_id int(0) NULL DEFAULT NULL,
  com_no int(0)  NOT NULL DEFAULT 1,
  PRIMARY KEY (com_id) USING BTREE,
  INDEX user_id(user_id) USING BTREE,
  INDEX book_id(book_id) USING BTREE,
  CONSTRAINT comment_ibfk_1 FOREIGN KEY (user_id) REFERENCES tb_user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT comment_ibfk_2 FOREIGN KEY (book_id) REFERENCES tb_book (book_id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user  (
-- id自动增1
  user_id int(0) NOT NULL AUTO_INCREMENT,
--   防止中文乱码
  username varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  password varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  vip int(0) NULL DEFAULT NULL,
  PRIMARY KEY (user_id) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;