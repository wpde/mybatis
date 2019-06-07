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
	/**
	 * 
	 * ��ѯԱ����Ϣ��Ա�����ڲ��ţ�һ��һ������ѯ��  
	 * @param: @return      
	 * @return: List<Employee>
	 */
	public List<Employee> getEmp();
	public void addEmp(Employee employee);
	/**
	 * 
	 * @Description: ���ݲ���id��ѯԱ����Ϣ  
	 * @param: @param dId
	 * @param: @return      
	 * @return: List<Employee>
	 */
	public List<Employee> getEmpByDId(Integer dId);
}
