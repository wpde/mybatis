package demo3.mulit;

import org.apache.ibatis.session.SqlSession;

import demo1.mapper.dao.UserMapper;
import demo1.mapper.pojo.User;

/**  
* @Description: �̲߳����޸�ͬһ��¼  
* @author cofe  
* @date 2019��6��27��  
*    
*/
public class Mythread2 implements Runnable {
	
	private SqlSession session;
	private int id;
	private String username;
	
	public Mythread2(SqlSession session, int id, String username) {
		super();
		this.session = session;
		this.id = id;
		this.username = username;
	}

	@Override
	public void run() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserById(id);
		user.setUsername(username);
		mapper.updateUser(user);
		session.commit();
		session.close();
	}
	
}
