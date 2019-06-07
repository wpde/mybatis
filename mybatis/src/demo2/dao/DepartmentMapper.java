package demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import demo2.bean.Department;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2019年2月24日  
*    
*/
public interface DepartmentMapper {
	
	public Department getDepartmentById(Integer id);
	
	/**
	 * 
	 * @Description: 查询部门及部门包含的员工信息（一对多级联查询）
	 */
	public List<Department> getDepartmentByName(@Param("departmentName")String departmentName);
	
	public  List<Department> getDepartmentByRowBounds(RowBounds rowBounds);
	
}
