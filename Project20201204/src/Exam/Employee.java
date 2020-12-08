package Exam;

//201208
//시험문제 5

public class Employee {

	private int empId;
	private String name;
	private String hireDate;
	private int dept;
	private int salary;
	private String job;

	public Employee(int empId, String name, String hireDate, int dept, int salary, String job) {
		super();
		this.empId = empId;
		this.name = name;
		this.hireDate = hireDate;
		this.dept = dept;
		this.salary = salary;
		this.job = job;
	}

	public Employee() {

	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getHireDate() {
		return hireDate;
	}

	public int getDept() {
		return dept;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public String getJob() {
		return job;
	}

}
