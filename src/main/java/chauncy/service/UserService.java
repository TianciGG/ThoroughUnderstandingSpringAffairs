package chauncy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import chauncy.dao.UserDao;
import chauncy.transaction.TransactionManager;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private TransactionManager transactionManager;
	@Autowired
	private LogService logService;
	
	/**
	 * 
	 * @methodDesc: 功能描述(编程事务)  
	 * @author: ChauncyWang
	 * @param:    
	 * @createTime: 2019年4月24日 下午3:24:39   
	 * @returnType: void
	 */
	public void add1(){
		TransactionStatus begin = null;
		try {
			begin = transactionManager.begin();
			userDao.addUser("zhangsan-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan插入成功");
			//int i=1/0; //会发生运行时异常
			userDao.addUser("lisi-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan李四成功");
			System.out.println("UserService的add方法----执行完毕");
			transactionManager.commit(begin);
		} catch (Exception e) {
			e.printStackTrace();
			//当发生遗产时，进行事务回滚操作
			transactionManager.rollback(begin);
		}
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(声明事务XML方式实现)  
	 * @author: ChauncyWang
	 * @param:    
	 * @createTime: 2019年4月24日 下午3:25:13   
	 * @returnType: void
	 */
	public void add2(){
		try{
			userDao.addUser("zhangsan-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan插入成功");
			int i=1/0; //会发生运行时异常
			userDao.addUser("lisi-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan李四成功");
			System.out.println("UserService的add方法----执行完毕");
		}catch(Exception e){
			//固定写法，手动回滚事务
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(声明事务注解方式实现)  
	 * @author: ChauncyWang
	 * @param:    
	 * @createTime: 2019年4月24日 下午4:03:12   
	 * @returnType: void
	 */
	@Transactional
	public void add3(){
		try{
			userDao.addUser("zhangsan-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan插入成功");
			int i=1/0; //会发生运行时异常
			userDao.addUser("lisi-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan李四成功");
			System.out.println("UserService的add方法----执行完毕");
		}catch(Exception e){
			//固定写法，手动回滚事务
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}
	
	/**
	 * Spring事务的传播行为应用,改变注解属性propagation的值来验证不同方式的传播行为
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void add4(){
		logService.addLog();
		userDao.addUser("chauncy---"+System.currentTimeMillis(), 18);
		int i=1/0;
		System.out.println("UserService的add方法----执行完毕");
	}
}
