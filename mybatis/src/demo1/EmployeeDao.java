package demo1;


/**  
* @Description: �ӿڷ�ʽ  
* @author cofe  
* @date 2019��1��13��  
*    
*/
public interface EmployeeDao {
	public Employee getEmpById(int id);
	public void addEmp(Employee employee);
	public int deleteById(Employee employee);
	public boolean updateBYId(Employee employee);
}
