package demo2.dao;

import java.util.List;

import demo2.bean.Employee;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2019��2��24��  
*    
*/
public interface EmployeeMapper {
	public List<Employee> getEmp();
	public List<Employee> getEmpByDId();	
	public List<Employee> getEmpByDId2();	
}
