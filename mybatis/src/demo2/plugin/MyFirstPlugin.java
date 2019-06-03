package demo2.plugin;

import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**  
* @Description: mybatis���  
* @author cofe  
* @date 2019��6��3��  
*    
*/
@Intercepts({
	@Signature(type=StatementHandler.class,method="parameterize",args=Statement.class)
})
public class MyFirstPlugin implements Interceptor{
	
	/**
	 * ����Ŀ������Ŀ�귽��
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("MyFirstPlugin:invocation()  "+invocation);
		//ִ��Ŀ�귽��
		Object proceed = invocation.proceed();
		return proceed;
	}
	
	/**
	 * �����������
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("MyFirstPlugin:plugin()  "+target);
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}
	
	/**
	 * ���ò���
	 */
	@Override
	public void setProperties(Properties properties) {
		System.out.println("MyFirstPlugin:setProperties");
		System.out.println(properties);
	}

}
