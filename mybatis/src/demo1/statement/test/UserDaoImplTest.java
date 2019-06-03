package demo1.statement.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import demo1.statement.dao.UserDao;
import demo1.statement.dao.UserDaoImpl;
import demo1.statement.pojo.User;

/**  
* @Description: 基于statementid方式测试  
* @author cofe  
* @date 2019年3月26日  
*    
*/
public class UserDaoImplTest {

	/**
	 * 添加方法测试
	 */
	@Test
	public void testInsertUser() {
		UserDao dao=new UserDaoImpl();
		User user = new User();
		user.setUsername("StatementId");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("北京");
		dao.insertUser(user);
	}

	/**
	 * Test method for {@link demo1.statement.dao.UserDaoImpl#deleteUser()}.
	 */
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link demo1.statement.dao.UserDaoImpl#updateUser()}.
	 */
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link demo1.statement.dao.UserDaoImpl#selectUser()}.
	 */
	@Test
	public void testSelectUser() {
		fail("Not yet implemented");
	}

}
