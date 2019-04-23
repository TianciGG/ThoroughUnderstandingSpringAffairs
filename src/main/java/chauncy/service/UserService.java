package chauncy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import chauncy.dao.UserDao;
import chauncy.transaction.TransactionManager;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private TransactionManager transactionManager;
	
	
	public void add(){
		TransactionStatus begin = null;
		try {
			begin = transactionManager.begin();
			userDao.addUser("zhangsan-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan插入成功----执行完毕");
			//int i=1/0; //会发生运行时异常
			userDao.addUser("lisi-"+System.currentTimeMillis(), 18);
			System.out.println("UserService的add方法----zhangsan李四成功----执行完毕");
			transactionManager.commit(begin);
		} catch (Exception e) {
			e.printStackTrace();
			//当发生遗产时，进行事务回滚操作
			transactionManager.rollback(begin);
		}
	}
}
