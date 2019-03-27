package demo1.mapper.dao;

import java.util.List;

import demo1.mapper.pojo.User;


/**  
* @Description: 调用方式二：基于Mapper方式  
* @author cofe  
* @date 2019年3月27日  
*    
*/
public interface UserMapper {
	public void insertUser(User user);
	public void deleteUser(Integer id);
	public void updateUser();
	public List<User> selectUser();
}
