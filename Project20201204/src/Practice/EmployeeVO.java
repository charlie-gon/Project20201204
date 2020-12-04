
//201204

package Practice;

public class EmployeeVO {
	
	private int empNo;
	private String empName;
	private String empMail;
	private int empSal;
	
	
	public EmployeeVO(int empNo, String empName, String empMail, int empSal) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empMail = empMail;
		this.empSal = empSal;
	}
	
	public EmployeeVO() {
		
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpMail() {
		return empMail;
	}


	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}


	public int getEmpSal() {
		return empSal;
	}


	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	
	public void showEmpInfo() {
		System.out.println(this.empNo + " " + this.empName + " " + this.empMail + " " + this.empSal);
	}
	
	
	
	
	
	

}
