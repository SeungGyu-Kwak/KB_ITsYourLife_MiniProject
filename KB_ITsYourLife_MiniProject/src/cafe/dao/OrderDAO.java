package cafe.dao;

import java.sql.Connection;
import java.sql.SQLException;

import cafe.dto.OrderDto;

public interface OrderDAO {

	/**
	 * 주문 테이블에 값 넣는 메소드
	 * 
	 * @예시)
	 * sql : " INSERT INTO ORDERTABLE( LOGIN_ID, COFFEE_NAME, COFFEE_SIZE, COFFEE_EA, COFFEE_PRICE, ORDER_DATE )"
					+ " VALUES ( ?, ?, ?, ?, ?, SYSDATE )";
	 * */
	public int orderInsert(OrderDto orderDto) throws SQLException;
	
	
	public int[] orderDetails(Connection con,OrderDto orderDto) throws SQLException;
	
}
