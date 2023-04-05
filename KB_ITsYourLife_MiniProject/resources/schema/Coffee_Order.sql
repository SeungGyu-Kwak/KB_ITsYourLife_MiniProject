--DB 생성

--메뉴 테이블 (메뉴코드와 이름, HOT/ICE가격)
CREATE TABLE tbl_menu(
    beverageName varchar2(50) primary key,
    hot_price number(8) not null,
    ice_price number(8) not null
);


INSERT INTO tbl_menu values('아메리카노', 4500, 5000);
INSERT INTO tbl_menu values('카페라떼', 5500, 6000);
INSERT INTO tbl_menu values('카푸치노', 5000, 5500);
INSERT INTO tbl_menu values('마끼야토', 6000, 6500);
INSERT INTO tbl_menu values('카페모카', 5000, 5500);
INSERT INTO tbl_menu values('콜드브루', 4500, 5000);
INSERT INTO tbl_menu values('에스프레소', 4000, 4500);
INSERT INTO tbl_menu values('아포카토', 6500, 7000);
INSERT INTO tbl_menu values('초코라떼', 5800, 6300);

SELECT * FROM tbl_menu;
select * from tbl_menu where beverageName LIKE '%카페%';
select * from tbl_menu where beverageName LIKE '%라떼%';

--주문 테이블 (주문번호, 주문아이디, 주문날짜)
CREATE TABLE tbl_order(
    orderNum_seq number(4) primary key,
    memberID varchar2(20),
    orderDate Date default sysdate
);

CREATE SEQUENCE seq_order
START WITH 1
INCREMENT BY 1;

INSERT INTO tbl_order(orderNum_seq, orderDate) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(orderNum_seq, orderDate) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(orderNum_seq, orderDate) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(orderNum_seq, orderDate) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(orderNum_seq, orderDate) VALUES(seq_order.NEXTVAL, DEFAULT);

SELECT * FROM tbl_order;


--주문상세 테이블(주문번호를 참조하기 위해 주문테이블의 orderNum을 FK 선언)
--(상세주문코드, 주문번호(FK), 메뉴번호(이름), HOT/ICE, 수량, 가격)
CREATE TABLE tbl_detailorder(
    orderCod number(8) primary key,
    orderNum number(2) constraint fk_seqorder REFERENCES tbl_order(orderNum_seq),
    menuName varchar(20),
    hot varchar(1),
    ice varchar(1),
    amount number(2),
    totalPrice number(8)        
);

CREATE SEQUENCE seq_detailorder
START WITH 1
INCREMENT BY 1;

INSERT INTO tbl_detailorder(orderCod, orderNum) VALUES(001, seq_order.NEXTVAL);
INSERT INTO tbl_detailorder(orderCod, orderNum) VALUES(002, seq_detailorder.NEXTVAL);
INSERT INTO tbl_detailorder(orderCod, orderNum) VALUES(003, seq_detailorder.NEXTVAL);
INSERT INTO tbl_detailorder(orderCod, orderNum) VALUES(004, seq_detailorder.NEXTVAL);
INSERT INTO tbl_detailorder(orderCod, orderNum) VALUES(005, seq_detailorder.NEXTVAL);

SELECT * FROM tbl_detailorder;

commit; --테이블 생성되어있지만 COMMIT하지 않음. ROLLBACK 가능!
rollback;






