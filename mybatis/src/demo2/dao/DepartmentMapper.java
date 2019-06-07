package demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import demo2.bean.Department;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2019��2��24��  
*    
*/
public interface DepartmentMapper {
	
	public Department getDepartmentById(Integer id);
	
	/**
	 * 
	 * @Description: ��ѯ���ż����Ű�����Ա����Ϣ��һ�Զ༶����ѯ��
	 */
	public List<Department> getDepartmentByName(@Param("departmentName")String departmentName);
	
	public  List<Department> getDepartmentByRowBounds(RowBounds rowBounds);
	
}
