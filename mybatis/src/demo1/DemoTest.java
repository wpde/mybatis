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
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2019年1月10日  
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
	//传统方式
	@Test
	public void test() throws IOException {
		//1.更据配置文件，利用SqlSessionFactoryBuilder创建SqlSessionFactory
		String resource ="mybatis.config.xml";
		InputStream is = Resources.getResourceAsStream(resource );
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is); 
		//2.创建SqlSession对象，代表与数据库的一次回话
		SqlSession session = factory.openSession();
		//3.利用session对象操作数据库
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
