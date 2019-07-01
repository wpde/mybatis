package demo3.mulit;

import org.apache.ibatis.session.SqlSession;

import demo1.mapper.dao.UserMapper;
import demo1.mapper.pojo.User;

/**  
* @Description: �̲߳�������  
* @author cofe  
* @date 2019��6��27��  
*    
*/
public class MyThread implements Runnable{
	private SqlSession session;
	private int id;
	public MyThread() {
		super();
	}
	public MyThread(SqlSession session,int id) {
		super();
		this.session = session;
		this.id=id;
	}
	@Override
	public void run() {
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User user =new User();
			user.setUsername("name"+Math.random());
			user.setAddress(user.getUsername());
			userMapper.insertUser(user );
			if(user.getId().equals(id)) {
				Thread.sleep(3000);//ģ�µ�ǰ�߳�ִ��ʱ��ϳ�����������
                System.out.println("�����쳣����������");
                System.out.println("��¼"+user.getId()+"����ʧ�ܡ�������");
                session.rollback();  //�����쳣����ع�������
                throw new Exception();
			}else {
				session.commit();
				System.out.println("��¼"+user.getId()+"�ɹ�����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
