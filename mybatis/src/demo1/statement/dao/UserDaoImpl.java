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
	
	/**
	 * 运行流程简析：
	 * SqlSessionFactoryBuilder().build()方法
	 * 	1、将is流转换成XMLConfigBuilder对象：parser
	 * 	2、再对parser对象进行解析成Configuration对象：configuration
	 * Configuration对象包含了所有配置信息
	 * 	3、调用build(configuration)方法返回DefaultSqlSessionFactory对象
	 */
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
