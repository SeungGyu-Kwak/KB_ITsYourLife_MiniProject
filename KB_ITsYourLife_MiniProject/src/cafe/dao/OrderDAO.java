package cafe.dao;

import java.sql.Connection;
import java.sql.SQLException;

import cafe.dto.OrderDto;
import cafe.exception.DMLException;

public interface OrderDAO {

	/**
	 * 주문 테이블에 값 넣는 메소드
	 * @작성자 : 곽승규
	 * @예시)
	 * sql : " INSERT INTO ORDERTABLE( LOGIN_ID, COFFEE_NAME, COFFEE_SIZE, COFFEE_EA, COFFEE_PRICE, ORDER_DATE )"
					+ " VALUES ( ?, ?, ?, ?, ?, SYSDATE )";
	 * */
	public int orderInsert(OrderDto orderDto) throws DMLException;
	
	
	/**
	 * 주문 상세 테이블에 값 넣는 메소드
	 * @작성자 : 곽승규
	 * */
	public int[] orderDetails(Connection con,OrderDto orderDto) throws SQLException;
	
	
	/**
	 * 주문테이블에 total_price 업데이트하기
	 * @작성자 : 곽승규
	 * */
	public int orderUpdate(OrderDto orderDto) throws DMLException;
	
}
