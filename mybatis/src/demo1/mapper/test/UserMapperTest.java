package demo1.mapper.test;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import demo1.mapper.dao.UserMapper;

/**  
* @Description: 基于Mapper方式测试  
* @author cofe  
* @date 2019年3月27日  
*    
*/
public class UserMapperTest {

	/**
	 * Test method for {@link demo1.mapper.dao.UserMapper#insertUser(demo1.mapper.pojo.User)}.
	 */
	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link demo1.mapper.dao.UserMapper#deleteUser()}.
	 */
	@Test
	public void testDeleteUser() {
		try {
			SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.config.xml")).openSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			userMapper.deleteUser(1);
//			session.commit();
//			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link demo1.mapper.dao.UserMapper#updateUser()}.
	 */
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link demo1.mapper.dao.UserMapper#selectUser()}.
	 */
	@Test
	public void testSelectUser() {
		fail("Not yet implemented");
	}

}
