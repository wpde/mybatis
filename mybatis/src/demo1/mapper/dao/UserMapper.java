package demo1.mapper.dao;

import java.util.List;

import demo1.mapper.pojo.User;


/**  
* @Description: 调用方式二：基于Mapper方式  
* 1、namespace必须为接口全路径
* 2、接口的方法名必需与映射文件的sql id一致
* 3、接口的输入参数必需与映射文件的parameterType类型一致
* 4、接口的返回类型必须与映射文件的resultType类型一致
* @author cofe  
* @date 2019年3月27日  
*    
*/
public interface UserMapper {
	public void insertUser(User user);
	public void deleteUser(Integer id);
	public void updateUser(User user);
	public List<User> selectUser();
	public User getUserById(int id);
//	public User getUserById(User id);
	
//	if test 中条件参数可以当做string类型，调用string的方法
	public List<User> selectUserByLike(User user);
}
