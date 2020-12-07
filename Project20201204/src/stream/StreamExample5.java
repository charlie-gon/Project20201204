package stream;

//120207

//PreparedStatment, ResultSet ??

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StreamExample5 {
	public static void main(String[] args) {

		Connection conn = DAO.getConnection(); // Connection 객체 생성
		List<EmployeeVO> list = new ArrayList<>(); // 201123의 EmployeeVO 클래스 활용
		try {
			String sql = "select * from emp3"; // 쿼리문 String 타입 sql 변수에 담기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id")); // 쿼리문으로 불러온 값을 가져오겠다
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getNString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDeptId(rs.getInt("department_id"));
				list.add(emp); // 리스트 컬렉션에 값을 add

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stream<EmployeeVO> stream = list.stream();
		stream.forEach(s -> s.showEmpinfo());

		System.out.println(); // 구분선

		// 부서번호가 없다면 에러 대신 공백 출력하도록 만들기
		System.out.println("특정부서 사원");
		OptionalDouble avg = list.stream().filter(t -> t.getDeptId() == 40).mapToInt(new ToIntFunction<EmployeeVO>() {

			@Override
			public int applyAsInt(EmployeeVO value) {
				return value.getSalary();
			}
		}).average();
		
		System.out.println("평균: " + avg.orElse(0.0)); //값이 없다면 0.0 리턴. 값이 있다면 평균값 리턴
		
//		avg.ifPresent(new DoubleConsumer() {//ifPresent: 실제 값이 있다면
//			
//			@Override
//			public void accept(double value) {
//				System.out.println("급여평균: " + avg.getAsDouble());
//				
//			}
//		}); 

	}

}
