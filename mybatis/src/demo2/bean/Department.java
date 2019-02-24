package demo2.bean;

import java.util.List;

/**
 * 
* @Description: 部门实体类  
* @author cofe  
* @date 2019年2月24日  
*
 */
public class Department {
	
	private Integer id;
	private String departmentName;
	private List<Employee> emps;
	
	
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName
				+ "]";
	}
	
	

}
