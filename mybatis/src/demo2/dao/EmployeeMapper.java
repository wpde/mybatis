package demo2.dao;

import java.util.List;

import demo2.bean.Employee;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2019年2月24日  
*    
*/
public interface EmployeeMapper {
	public List<Employee> getEmp();
	public List<Employee> getEmpByDId();	
	public List<Employee> getEmpByDId2();	
}
