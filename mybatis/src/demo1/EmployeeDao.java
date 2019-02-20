package demo1;

import org.apache.ibatis.annotations.Param;

/**  
* @Description: 接口方式  
* @author cofe  
* @date 2019年1月13日  
*    
*/
public interface EmployeeDao {
	public Employee getEmpById(int id);
//	public Employee getEmpByIdAndGenter(int id,String gender);
	public Employee getEmpByIdAndGenter(@Param("id")int id,@Param("genter")String gender);
	public void addEmp(Employee employee);
	public int deleteById(Employee employee);
	public boolean updateBYId(Employee employee);
}
