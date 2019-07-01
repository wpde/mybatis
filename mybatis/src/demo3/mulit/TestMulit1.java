package demo3.mulit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**  
* @Description: ���Զ��̲߳����������ݿ�  
* @author cofe  
 * @throws Exception 
* @date 2019��6��27��  
*    
*/
public class TestMulit1 {
	/**
	 * ������̹߳���session����ô����ɶ��߳�֮�������໥����
	 * ��ĳ�̵߳�һ���﷢���쳣����ʹִ�лع˲�����Ҳ��Ч
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
