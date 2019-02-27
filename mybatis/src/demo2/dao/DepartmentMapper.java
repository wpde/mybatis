package demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo2.bean.Department;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2019年2月24日  
*    
*/
public interface DepartmentMapper {
	
	public Department getDepartmentById(Integer id);
	
	public List<Department> getDepartmentByName(@Param("departmentName")String departmentName);
}
