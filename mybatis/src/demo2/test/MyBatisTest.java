package demo2.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import demo2.bean.Department;
import demo2.bean.Employee;
import demo2.dao.DepartmentMapper;
import demo2.dao.EmployeeMapper;
import oracle.net.aso.d;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2019��2��24��  
*    
*/
public class MyBatisTest {
	
	@Test
	public void test1() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		List<Employee> list = employeeMapper.getEmp();
		for (Employee employee : list) {
			System.out.println(employee.getDept());
		}
	}
	
	/**
	 * ���Ϸ�װ
	 */
	@Test
	public void test2() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		 List<Department> ds = departmentMapper.getDepartmentByName("����");
		for (Department department : ds) {
			System.out.println(department);
			System.out.println(department.getEmps());
		}
	}
	
	/**
	 * ��ѯ�����������������װ��map
	 */
	@Test
	public void test3() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		 List<Department> ds = departmentMapper.getDepartmentByName("����");
		for (Department department : ds) {
			System.out.println(department);
			System.out.println(department.getEmps());
		}
	}
	
}
