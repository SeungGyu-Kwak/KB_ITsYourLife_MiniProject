package cafe.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cafe.common.DBManager;
import cafe.dto.CoffeeDto;
import cafe.exception.SearchWrongException;

public class CoffeeDAOImpl implements CoffeeDAO{

	private static CoffeeDAO instance = new CoffeeDAOImpl();
	
	/**
	 * 외부에서 객체 생성 막음 (싱글톤)
	 * */
	private CoffeeDAOImpl() {}
	public static CoffeeDAO getInstance() {
		return instance;
	}
	
	
	@Override
	public List<CoffeeDto> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CoffeeDto> coffeeList = new ArrayList<>();
		String sql = "select * from tbl_menu";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CoffeeDto dto = new CoffeeDto(
						rs.getInt("beverage_code"),rs.getString("beverage_name"),
						rs.getInt("hot_price"), rs.getInt("ice_price")
						);
				
				coffeeList.add(dto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("전체메뉴 검색에 예외가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return coffeeList;
	}

	@Override
	public List<CoffeeDto> coffeeSelectByKeyWord(String keyWord) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CoffeeDto> list = new ArrayList<>();
		
		String sql = "select * from tbl_menu where beverage_name like ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%" + keyWord + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int beverageCode = rs.getInt(1);
				String beverageName = rs.getString(2);
				int hotPrice = rs.getInt(3);
				int incPrice = rs.getInt(4);
				
				CoffeeDto dto = new CoffeeDto(beverageCode, beverageName, hotPrice, incPrice);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("음료키워드 검색에 예외가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return list;
	}
	@Override
	public CoffeeDto coffeeSelectByName(String beverageName) throws SearchWrongException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		CoffeeDto beverage = null;
		
		String sql = "select * from tbl_menu where beverage_name = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, beverageName);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int beverageCode = rs.getInt(1);
				String menuName = rs.getString(2);
				int hotPrice = rs.getInt(3);
				int incPrice = rs.getInt(4);
				
				beverage = new CoffeeDto(beverageCode, menuName, hotPrice, incPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("음료이름 검색에 예외가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return beverage;
	}

}
