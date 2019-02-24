package demo1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

/**  
* @Description: �ӿڷ�ʽ  
* @author cofe  
* @date 2019��1��13��  
*    
*/
public interface EmployeeDao {
	public Employee getEmpById(int id);
//	public Employee getEmpByIdAndGenter(int id,String gender);
	public Employee getEmpByIdAndGenter(@Param("id")int id,@Param("genter")String gender);
	public void addEmp(Employee employee);
	public int deleteById(Employee employee);
	public boolean updateBYId(Employee employee);
	@MapKey("lastName")
	public Map<String,Employee>  getEmployeeByNameForMap(@Param("lastName")String lastName);
	
	
}
