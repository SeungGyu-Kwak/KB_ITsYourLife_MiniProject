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
						rs.getInt("beverageCode"),rs.getString("beverageName"),
						rs.getInt("hot_price"), rs.getInt("ice_price")
						);
				
				coffeeList.add(dto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("전체 메뉴 검색에 예외가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return coffeeList;
	}

	@Override
	public List<CoffeeDto> coffeeSelectByName(String keyWord) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
