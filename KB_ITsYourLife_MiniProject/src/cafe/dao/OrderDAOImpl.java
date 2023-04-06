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
<<<<<<< HEAD
		//ResultSet rs = null;
		String sql = "INSERT INTO tbl_order(order_num_seq, G_H, order_date, total_price) VALUES(seq_order.NEXTVAL, ?, DEFAULT, ?)";
		
=======

		String sql = "INSERT INTO tbl_order(order_num_seq, is_togo, order_date, total_price) VALUES(seq_order.NEXTVAL, ?, DEFAULT, ?)";

>>>>>>> b32a23882e94390598d4f097be7ecf56fb3fc7a8
		int result = 0;
		
		
		try {
<<<<<<< HEAD
			con =  DBManager.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, orderDto.getOrderNumSeq());
			ps.setInt(1, orderDto.getGH());
			ps.setInt(1, orderDto.getTotalPrice());
			ps.setInt(1, orderDto.getTotalPrice());
			
			result = ps.executeUpdate();
			
			if (rs.next()) {
				int re [] = this.orderDetails(con, orderDto);
			}
			
=======
			con = DBManager.getConnection();

			con.setAutoCommit(false); // 자동커밋 해지

			ps = con.prepareStatement(sql);


			// 금액 부분 코드
			List<OrderDetailDto> orderDetailList = orderDto.getOrderDetailList();
			int totalPrice = 0; // 토탈 금액 저장할 변수

			for( OrderDetailDto orderDetail : orderDetailList) {

				// 각 튜플마다 가격 넣기 위한 코드
				CoffeeDAO coffeeDAO = CoffeeDAOImpl.getInstance();
				CoffeeDto beverage = coffeeDAO.coffeeSelectByName(orderDetail.getMenuName());

				int price = 0; // 주문상세 당 각각의 가격 저장할 변수


				if (orderDetail.getIsHot() == 1) { // hot임
					price = beverage.getHotPrice() * orderDetail.getAmount();
				}else {//ice임
					price = beverage.getIcePrice() * orderDetail.getAmount();
				}

				orderDetail.setEachPrice(price);

				totalPrice += price;

			}


			orderDto.setTotalPrice(totalPrice);
			ps.setInt(1, orderDto.getIsToGo());
			ps.setInt(2, totalPrice); // 총 금액 저장하기

			result = ps.executeUpdate();


			int re [] = this.orderDetails(con, orderDto);

			for(int i : re) {
				if ( i != 1) {
					con.rollback();
					throw new DMLException("주문상세 입력에 예외가 발생했습니다.");
				}
			}

			con.commit(); //커밋하기
>>>>>>> b32a23882e94390598d4f097be7ecf56fb3fc7a8
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("주문 입력에 예외가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}

		return result;
		
	}

<<<<<<< HEAD
=======

	/**
	 * 주문상세 insert 구현, 같은 connection 유지
	 * @작성자 : 곽승규
	 * */
>>>>>>> b32a23882e94390598d4f097be7ecf56fb3fc7a8
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
<<<<<<< HEAD
			for( OrderDetailDto orderDetail : orderDetailList) {
				ps.setInt(1, orderDetail.getOrderDetailCode());
				ps.setString(2, orderDetail.getMenuName());
				ps.setInt(3, orderDetail.getMenuEA());
				ps.setInt(4, orderDetail.getKind());
				
=======
			int totalPrice = 0; // 토탈 금액 저장할 변수

			for( OrderDetailDto orderDetail : orderDetailList) {

				// 각 튜플마다 가격 넣기 위한 코드
				CoffeeDAO coffeeDAO = CoffeeDAOImpl.getInstance();
				CoffeeDto beverage = coffeeDAO.coffeeSelectByName(orderDetail.getMenuName());

				ps.setString(1, orderDetail.getMenuName());
				ps.setInt(2, orderDetail.getIsHot());
				ps.setInt(3, orderDetail.getAmount());
				ps.setInt(4, orderDetail.getEachPrice());

>>>>>>> b32a23882e94390598d4f097be7ecf56fb3fc7a8
				result[count++] = ps.executeUpdate();
				
			}
<<<<<<< HEAD
			
=======

>>>>>>> b32a23882e94390598d4f097be7ecf56fb3fc7a8
		} finally {
			DBManager.releaseConnection(null,ps);
		}
		return result;
	}


}
