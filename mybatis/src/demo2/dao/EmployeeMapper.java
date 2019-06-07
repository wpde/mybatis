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
	/**
	 * 
	 * 查询员工信息及员工所在部门（一对一级联查询）  
	 * @param: @return      
	 * @return: List<Employee>
	 */
	public List<Employee> getEmp();
	public void addEmp(Employee employee);
	/**
	 * 
	 * @Description: 根据部门id查询员工信息  
	 * @param: @param dId
	 * @param: @return      
	 * @return: List<Employee>
	 */
	public List<Employee> getEmpByDId(Integer dId);
}
