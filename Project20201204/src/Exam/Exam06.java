package Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

//201208
//시험문제 5

public class Exam06 {

	public static void main(String[] args) {

		Connection conn = DAO.getConnection();
		List<Employee> list = new ArrayList<>();

		try {
			String sql = "select * from emp3";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("employee_id"));
				emp.setName(rs.getString("first_name"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setDept(rs.getInt("department_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJob(rs.getString("job_id"));
				list.add(emp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//데이터 값을 제대로 가져오지 못함
		System.out.println("개발자 직무 평균급여");
		OptionalDouble avg = list.stream()
				.filter(t -> t.getJob().equals("IT_PROG")) //String 타입이므로 equals로 비교
				.mapToInt(new ToIntFunction<Employee>() {

			@Override
			public int applyAsInt(Employee value) {
				return value.getSalary();
			}
		}).average();

		System.out.println("평균급여: " + avg.getAsDouble());

//		avg.ifPresent(new DoubleConsumer() {
//
//			@Override
//			public void accept(double value) {
//				System.out.println("평균급여: " + avg.getAsDouble());
//			}
//		});
		
	}

}
