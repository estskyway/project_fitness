
CREATE TABLE BOARD
(
  NUMBER   INTEGER     NOT NULL COMMENT '번호',
  ID       VARCHAR(50) NOT NULL COMMENT '아이디',
  TITLE    VARCHAR(50) NOT NULL COMMENT '제목',
  CONTENTS VARCHAR(50) NOT NULL COMMENT '내용',
  DATE     VARCHAR(50) NOT NULL COMMENT '날짜',
  VIEWS    INTEGER     NOT NULL COMMENT '조회수'
) COMMENT '게시판 리스트';
