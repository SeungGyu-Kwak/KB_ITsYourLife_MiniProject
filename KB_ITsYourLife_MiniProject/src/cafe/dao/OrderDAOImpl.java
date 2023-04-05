package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cafe.common.DBManager;
import cafe.dto.OrderDetailDto;
import cafe.dto.OrderDto;

public class OrderDAOImpl implements OrderDAO{
	
	private static OrderDAO instance = new OrderDAOImpl();
	
	/**
	 * 외부에서 객체 생성 막음 (싱글톤)
	 * */
	private OrderDAOImpl() {}
	public static OrderDAO getInstance() {
		return instance;
	}
	

	@Override
	public int orderInsert(OrderDto orderDto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "INSERT INTO tbl_order(order_num_seq, total_price) VALUES(seq_order.NEXTVAL, ?);";
		
		int result = 0;
		
		
		try {
			con =  DBManager.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, orderDto.getTotalPrice());
			
			result = ps.executeUpdate();
			
			if (rs.next()) {
				int re [] = this.orderDetails(con, orderDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("주문 입력에 예외가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}

		return result;
		
	}

	@Override
	public int[] orderDetails(Connection con, OrderDto orderDto) throws SQLException {
		PreparedStatement ps = null;

		String sql = "insert into tbl_detail_order values( ?, seq_order.CURRVAL, ?, ?, ?)";
		
		int result [] = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			
			List<OrderDetailDto> orderDetailList = orderDto.getOrderDetailList();
			result = new int[orderDetailList.size()];
			for( OrderDetailDto orderDetail : orderDetailList) {
				ps.setInt(1, orderDetail.getOrderDetailCode());
				ps.setString(2, orderDetail.getMenuName());
				ps.setInt(3, orderDetail.getMenuEA());
				ps.setInt(4, orderDetail.getKind());
				
				result[count++] = ps.executeUpdate();
				
			}
			
		} finally {
			DBManager.releaseConnection(null,ps);
		}
		return result;
	}


}
