package demo2.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import demo2.bean.Department;
import demo2.bean.Employee;
import demo2.dao.DepartmentMapper;
import demo2.dao.EmployeeMapper;
import oracle.net.aso.d;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2019年2月24日  
*    
*/
public class MyBatisTest {
	
	/**
	 * 级联查询：一对一
	 */
	@Test
	public void testGetEmp() throws IOException {
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
	 * 级联查询：一对多
	 */
	@Test
	public void testGetDepartmentByName() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		 List<Department> ds = departmentMapper.getDepartmentByName("测试");
		for (Department department : ds) {
			System.out.println(department);
			System.out.println(department.getEmps());
		}
	}
	
	/**
	 * 查询条件包含多个参数封装成map
	 */
	@Test
	public void test3() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		 List<Department> ds = departmentMapper.getDepartmentByName("测试");
		for (Department department : ds) {
			System.out.println(department);
			System.out.println(department.getEmps());
		}
	}
	
	/**
	 * 
	 * pagehelper分页插件使用
	 */
	@Test
	public void testPageHelper() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		PageHelper.startPage(1, 3);
		List<Employee> list = employeeMapper.getEmp();
		System.out.println(list.size());
		PageInfo page=new PageInfo(list);
		System.out.println(page);
	}
	
	@Test
	public void testRowBounds() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		RowBounds rowBounds =new RowBounds(0, 2);
		List<Department> list = mapper.getDepartmentByRowBounds(rowBounds);
		System.out.println(list.size());
	}
	
	
	/**
	 * 批量操作：ExecutorType.BATCH
	 */
	@Test
	public void testBatch() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		//获取特定的session
		SqlSession session = sessionFactory.openSession(ExecutorType.BATCH);
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		
		for(int i=1;i<100;i++) {
			mapper.addEmp(new Employee("1", "a", "b"));
		}
		List l=new ArrayList<>();
		for (Object object : l) {
			
		}
		
		session.commit();
		session.close();
	}
}
