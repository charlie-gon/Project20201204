package Practice;

import java.util.List;

import stream.EmpService;

public class EmployeeImpl implements EmpService {

	EmployeeDAO dao = new EmployeeDAO();
	
	@Override
	public List getEmpList() {
		return dao.getEmpList();
	}
	
	

}
