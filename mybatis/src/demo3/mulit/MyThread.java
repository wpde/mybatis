package demo3.mulit;

import org.apache.ibatis.session.SqlSession;

import demo1.mapper.dao.UserMapper;
import demo1.mapper.pojo.User;

/**  
* @Description: 线程并发插入  
* @author cofe  
* @date 2019年6月27日  
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
				Thread.sleep(3000);//模仿当前线程执行时间较长。。。。。
                System.out.println("发生异常。。。。。");
                System.out.println("记录"+user.getId()+"插入失败。。。。");
                session.rollback();  //出现异常事务回滚。。。
                throw new Exception();
			}else {
				session.commit();
				System.out.println("记录"+user.getId()+"成功插入");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
