--DB 생성

--메뉴 테이블 (메뉴코드와 이름, HOT/ICE가격)
CREATE TABLE tbl_menu(
    beverage_code number(8) primary key, --메뉴코드
    beverage_name varchar2(50) unique,   --메뉴이름
    hot_price number(8) not null,        --뜨거운 음료 가격
    ice_price number(8) not null         --차가운 음료 가격
);


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


select * from tbl_menu where beverage_name LIKE '%카페%'; --확인용
select * from tbl_menu where beverage_name LIKE '%라떼%'; --확인용


--주문 테이블 (주문번호, 포장여부, 주문날짜, 총가격)
CREATE TABLE tbl_order(
    order_num_seq number(4) primary key,       --주문번호
    is_togo number(1) check(is_togo in(1, 2)), --포장여부 : 1이면 GO, 2이면 HERE  
    order_date Date default sysdate,           --주문날짜
    total_price number(8)                      -- SUM(each_price)
);

CREATE SEQUENCE seq_order           --시퀀스문 추가
START WITH 1
INCREMENT BY 1;


INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);
INSERT INTO tbl_order(order_num_seq, order_date) VALUES(seq_order.NEXTVAL, DEFAULT);

SELECT * FROM tbl_order;


--주문상세 테이블(주문번호를 참조하기 위해 주문테이블의 order_num_seq을 참조하는 order_num을 PK와 FK로 잡음)
--(상세주문코드, 주문번호(FK), 메뉴이름, HOT/ICE, 수량, 각메뉴의 총가격)
CREATE TABLE tbl_detail_order(
    order_code number(4) primary key,        --상세주문코드
    order_num number(2) constraint fk_seqorder REFERENCES tbl_order(order_num_seq), --주문번호
    menu_name varchar(20),                   --메뉴이름
    is_hot number(1) check(is_hot in(1, 2)), --HOT/ICE 1이면 HOT, 2이면 ICE
    amount number(2),                        --수량
    each_price number(8)                     --각메뉴의 총가격 AMOUNT X PRICE   
);

CREATE SEQUENCE seq_code                     --시퀀스문 추가
START WITH 1
INCREMENT BY 1;


INSERT INTO tbl_detail_order(order_code, order_num) VALUES(seq_code.NEXTVAL, seq_order.CURRVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(seq_code.NEXTVAL, seq_order.CURRVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(seq_code.NEXTVAL, seq_order.CURRVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(seq_code.NEXTVAL, seq_order.CURRVAL);
INSERT INTO tbl_detail_order(order_code, order_num) VALUES(seq_code.NEXTVAL, seq_order.CURRVAL);

SELECT * FROM tbl_detail_order;

commit; --테이블 생성되어있지만 COMMIT하지 않음. ROLLBACK 가능!
rollback;

DROP TABLE tbl_order;
DROP SEQUENCE seq_code;







