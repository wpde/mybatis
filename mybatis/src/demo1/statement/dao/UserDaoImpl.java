package demo1.statement.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import demo1.statement.pojo.User;

/**  
* @Description: 调用方式一：基于statementId方式  
* @author cofe  
* @date 2019年3月26日  
*    
*/
public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(User user) {
		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession session = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis.config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			session.insert("insertStatement", user);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null!=session) {
				session.close();
			}
		}
	}

	@Override
	public void deleteUser() {
	}

	@Override
	public void updateUser() {
	}

	@Override
	public List<User> selectUser() {
		return null;
	}

}
