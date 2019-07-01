package demo3.mulit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import demo1.mapper.dao.UserMapper;
import demo1.mapper.pojo.User;

/**  
* @Description: 多线程并发修改同一条数据  
* @author cofe  
* @date 2019年6月27日  
*    
*/
public class TestMulit2 {
	public static void main(String[] args) throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		for (int i=1;i<10;i++) {
			SqlSession session = sessionFactory.openSession();
			Mythread2 mythread2=new Mythread2(session, 1, "name"+i);
			Thread t=new Thread(mythread2);
			t.start();
		}
	}
}
