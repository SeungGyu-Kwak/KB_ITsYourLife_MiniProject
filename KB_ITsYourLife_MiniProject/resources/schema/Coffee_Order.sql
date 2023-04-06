--DB 생성

--메뉴 테이블 (메뉴코드와 이름, HOT/ICE가격)
CREATE TABLE tbl_menu(
    beverage_code number(8) primary key,
    beverage_name varchar2(50) unique,
    hot_price number(8) not null,
    ice_price number(8) not null
);

CREATE SEQUENCE seq_menu
START WITH 1
INCREMENT BY 1;

INSERT INTO tbl_menu values(1, '아메리카노', 4500, 5000);
INSERT INTO tbl_menu values(2, '카페라떼', 5500, 6000);
INSERT INTO tbl_menu values(3, '카푸치노', 5000, 5500);
INSERT INTO tbl_menu values(4, '마끼야토', 6000, 6500);
INSERT INTO tbl_menu values(5, '카페모카', 5000, 5500);
INSERT INTO tbl_menu values(6, '콜드브루', 4500, 5000);
INSERT INTO tbl_menu values(7, '에스프레소', 4000, 4500);
INSERT INTO tbl_menu values(8, '아포카토', 6500, 7000);
INSERT INTO tbl_menu values(9, '초코라떼', 5800, 6300);

SELECT * FROM tbl_menu;
select * from tbl_menu where beverage_name LIKE '%카페%';
select * from tbl_menu where beverage_name LIKE '%라떼%';

--주문 테이블 (주문번호, 주문아이디, 주문날짜)
CREATE TABLE tbl_order(
    order_num_seq number(4) primary key,
    G_H number(1) check(G_H in(1, 2)), --1이면 GO, 2이면 HERE  
    order_date Date default sysdate,
    total_price number(8)           -- SUM(each_price)
);

CREATE SEQUENCE seq_order
START WITH 1
INCREMENT BY 1;

INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);

SELECT * FROM tbl_order;


--주문상세 테이블(주문번호를 참조하기 위해 주문테이블의 orderNum을 FK 선언)
--(상세주문코드, 주문번호(FK), 메뉴번호(이름), HOT/ICE, 수량, 가격)
CREATE TABLE tbl_detail_order(
    order_code number(4) primary key,
    order_num number(2) constraint fk_seqorder REFERENCES tbl_order(order_num_seq),
    menu_name varchar(20),
    H_I number(1) check(H_I in(1, 2)), --1이면 HOT, 2이면 ICE
    amount number(2),
    each_price number(8)     --AMOUNT X PRICE   
);


INSERT INTO tbl_detail_order(order_code, order_num) VALUES(1, seq_order.currVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(2, seq_order.currVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(3, seq_order.currVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(4, seq_order.currVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(5, seq_order.currVAL);

SELECT * FROM tbl_detail_order;

commit; --테이블 생성되어있지만 COMMIT하지 않음. ROLLBACK 가능!
rollback;








