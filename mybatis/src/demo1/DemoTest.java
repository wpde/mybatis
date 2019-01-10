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
}
