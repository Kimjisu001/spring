CREATE TABLE BOOK_TBL_06 (                       --도서정보명세서
    book_no          NUMBER primary key NOT NULL --도서번호
   ,book_name        VARCHAR2(50) NOT NULL       --도서명
   ,book_coverimg    VARCHAR2(20)                --표지
   ,book_date        DATE                        --출판일자
   ,book_price       NUMBER                      --금액
   ,book_publisher   VARCHAR2(50)                --출판사
   ,book_info        VARCHAR2(2000)              --도서소개
   );
   
INSERT INTO BOOK_TBL_06(book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (100, '리눅스', '100.jpg','15/09/02',24000,'나룩스','운영체제, DB기초, 네트워크 기초,개발환경 구축' );

INSERT INTO BOOK_TBL_06(book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (101, '자바', '101.jpg','16/01/10',20000,'이지바', '프로그래밍 언어');

INSERT INTO BOOK_TBL_06(book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (102, '자바웹프로그래밍', '102.jpg','16/10/30',25000,'김프로','개발환경/서버프로그램/배치프로그램' );

INSERT INTO BOOK_TBL_06(book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (103, '오픈소스활용하기', '103.jpg','17/09/01',30000,'박오픈','형상관리,빌드,배포' );

INSERT INTO BOOK_TBL_06(book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (104, 'HTML', '104.jpg','18/04/04',10000,'홍길동','HTML/CSS/JAVASCRIPT/JAUERY' );

DROP TABLE RENT_TBL_06;

CREATE TABLE RENT_TBL_06(                           --도서대여명세서
    rent_no          NUMBER  primary key NOT NULL   --대여번호
   ,book_no          NUMBER  NOT NULL               --도서번호
   ,rent_price       NUMBER  NOT NULL               --대여금액
   ,rent_date        DATE    NOT NULL               --대여일자
   ,rent_status      CHAR(1) NOT NULL               --반납여부
   );
   
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10001,100,2400,'18/07/02','1');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10002,101,2000,'18/07/04','1');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10003,100,2400,'18/08/02','1');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10004,100,2400,'18/08/12','1');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10005,102,2500,'18/08/13','1');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10006,103,3000,'18/08/13','1');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10007,103,3000,'18/08/20','0');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10008,100,2400,'18/09/03','1');

 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10009,100,2400,'18/09/08','1');
 
 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10010,100,2400,'18/09/14','0');

 INSERT INTO RENT_TBL_06( rent_no ,book_no ,rent_price ,rent_date ,rent_status)
 VALUES (10011,102,2500,'18/09/14','0'); 
 