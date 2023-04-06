package cafe.dao;

import java.sql.Connection;
import java.sql.SQLException;

import cafe.dto.OrderDto;
import cafe.exception.DMLException;

public interface OrderDAO {

	/**
	 * 주문 테이블에 값 넣는 메소드
	 * @작성자 : 곽승규
	 * @return : 1이면 성공, 0이면 실패
	 * @sql : INSERT INTO tbl_order(order_num_seq, is_togo, order_date, total_price)
	 *  	VALUES(seq_order.NEXTVAL, ?, DEFAULT, ?);
	 * */
	public int orderInsert(OrderDto orderDto) throws DMLException;
	
	
	/**
	 * 주문 상세 테이블에 값 넣는 메소드
	 * @return : 리스트로 받아서 각 배열의 값이 1이면 성공, 0이면 실패
	 * @sql :insert into tbl_detail_order values(order_detail_seq.NEXTVAL, seq_order.CURRVAL, ?, ?, ?, ?);
	 * @작성자 : 곽승규
	 * */
	public int[] orderDetails(Connection con,OrderDto orderDto) throws SQLException;
	

	
}
