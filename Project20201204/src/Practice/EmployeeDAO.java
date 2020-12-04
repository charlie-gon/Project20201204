package Practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import stream.DAO;

public class EmployeeDAO {

Connection conn = null;
PreparedStatement pstmt;
ResultSet rs;
String sql;
	
//	public List getEmpList() {
//		conn = DAO.getConnection();
//		sql = "select * from emp2 order by 1";
//		List list = new ArrayList();
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				EmployeeVO vo = new EmployeeVO();
//				vo.setEmpNo(rs.getInt("employee_id"));
//				vo.setEmpName(rs.getString("first_name"));
//				vo.setEmpName(rs.getString("email"));
//				vo.setEmpSal(rs.getInt("salary"));
//				list.add(vo);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return list;
//	}

	public List getEmpList() {
		conn = DAO.getConnection();
		sql = "select * from emp2 order by 1";
		List list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<list> empList = Arrays.asList(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
