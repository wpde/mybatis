package demo3.mulit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**  
* @Description: 测试多线程并发访问数据库  
* @author cofe  
 * @throws Exception 
* @date 2019年6月27日  
*    
*/
public class TestMulit1 {
	/**
	 * 如果多线程共享session，那么会造成多线程之间事物相互干扰
	 * 即某线程的一事物发生异常，即使执行回顾操作，也无效
	 */
	public static void main(String[] args) throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis.config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		MyThread myThread=new MyThread(session,20000);
		for(int i=0;i<1000;i++) {
			Thread t=new Thread(myThread);
			t.start();
		}
	}
}
