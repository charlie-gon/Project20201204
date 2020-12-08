package Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

//201208
//시험문제 5

public class Exam05 {
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

		// 전체사원의 평균급여
		System.out.println("전체사원 평균급여");
		double avg = list.stream().mapToInt(new ToIntFunction<Employee>() {

			@Override
			public int applyAsInt(Employee value) {
				return value.getSalary();
			}
		}).average().getAsDouble();

		DecimalFormat dcm = new DecimalFormat("00.#");
		System.out.println("급여평균: " + dcm.format(avg));

	}

}
