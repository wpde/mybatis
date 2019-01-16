package demo1;


/**  
* @Description: 接口方式  
* @author cofe  
* @date 2019年1月13日  
*    
*/
public interface EmployeeDao {
	public Employee getEmpById(int id);
	public void addEmp(Employee employee);
	public int deleteById(Employee employee);
	public boolean updateBYId(Employee employee);
}
