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
* @Description: mybatis插件  
* @author cofe  
* @date 2019年6月3日  
*    
*/
@Intercepts({
	@Signature(type=StatementHandler.class,method="parameterize",args=Statement.class)
})
public class MyFirstPlugin implements Interceptor{
	
	/**
	 * 拦截目标对象的目标方法
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("MyFirstPlugin:invocation()  "+invocation);
		//执行目标方法
		Object proceed = invocation.proceed();
		return proceed;
	}
	
	/**
	 * 创建代理对象
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("MyFirstPlugin:plugin()  "+target);
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}
	
	/**
	 * 设置参数
	 */
	@Override
	public void setProperties(Properties properties) {
		System.out.println("MyFirstPlugin:setProperties");
		System.out.println(properties);
	}

}
