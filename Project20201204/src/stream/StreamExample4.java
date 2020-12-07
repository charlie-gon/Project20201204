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
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StreamExample4 {
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

		// 샐러리가 10000 이상인 사람
		System.out.println("샐러리 10000 이상 사원");
//		list.stream().filter(new Predicate<EmployeeVO>() {
//
//			@Override
//			public boolean test(EmployeeVO t) {
//				return t.getSalary() > 10000;
//			}
//			
//		}).forEach(s -> s.showEmpinfo());

		// 람다식 사용
		list.stream().filter((t) -> t.getSalary() > 10000).forEach(s -> s.showEmpinfo());

		System.out.println(); // 구분선

		// 50번 부서 급여 평균

		//급여합계
//		int sum = list.stream().filter(t -> t.getDeptId() == 50).mapToInt(new ToIntFunction<EmployeeVO>() {
//
//			@Override
//			public int applyAsInt(EmployeeVO value) {
//				return value.getSalary();
//			}
//		}).sum();
//		System.out.println("급여합계: " + sum);
		
		//급여평균
		System.out.println("특정부서 사원");
		double avg = list.stream().filter(t -> t.getDeptId() == 40).mapToInt(new ToIntFunction<EmployeeVO>() {

			@Override
			public int applyAsInt(EmployeeVO value) {
				return value.getSalary();
			}
		}).average().getAsDouble();
		
		DecimalFormat dcm = new DecimalFormat("0000.#");
		System.out.println("급여합계: " + dcm.format(avg));
		
		//람다식 사용
		// mapToInt는 Int 타입의 스트림으로 변환
//		double avg = list.stream().filter((t) -> t.getDeptId() == 50).mapToInt(s -> s.getSalary())
//				.average().getAsDouble();
//		System.out.println(avg);
		
		//급여 5000~10000 사원
		list.stream().filter(t -> t.getSalary() > 5000 && t.getSalary() < 10000).forEach(s -> s.showEmpinfo());

	}

}
