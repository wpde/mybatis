package demo1.statement.dao;

import java.util.List;

import demo1.statement.pojo.User;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2019年3月26日  
*    
*/
public interface UserDao {
	
	public void insertUser(User user);
	public void deleteUser();
	public void updateUser();
	public List<User> selectUser();
}
