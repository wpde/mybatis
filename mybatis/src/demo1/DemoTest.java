package demo1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2019��1��10��  
*    
*/
public class DemoTest {
	
	public SqlSession getSession(){
		String resource ="mybatis.config.xml";
		InputStream is =null;
		SqlSessionFactory factory =null;
		try {
			is = Resources.getResourceAsStream(resource );
			factory = new SqlSessionFactoryBuilder().build(is); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  factory.openSession();
	}
	//��ͳ��ʽ
	@Test
	public void test() throws IOException {
		//1.���������ļ�������SqlSessionFactoryBuilder����SqlSessionFactory
		String resource ="mybatis.config.xml";
		InputStream is = Resources.getResourceAsStream(resource );
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is); 
		//2.����SqlSession���󣬴��������ݿ��һ�λػ�
		SqlSession session = factory.openSession();
		//3.����session����������ݿ�
		Object obj = session.selectOne("getEmpById", 1);
		System.out.println(obj);
	}
	
	@Test
	public void test2() {
		SqlSession session = this.getSession();
		EmployeeDao mapper = session.getMapper(EmployeeDao.class);
		Employee emp = mapper.getEmpById(1);
		System.out.println(emp.getLastName());
	}
}
