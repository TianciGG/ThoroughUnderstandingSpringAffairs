package chauncy.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Component
public class TransactionManager {
	
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	/**
	 * 开启事务
	 */
	public TransactionStatus begin(){
		//获取到事务状态
		return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
	}
	
	/**
	 * 提交事务
	 */
	public void commit(TransactionStatus transactionStatus){
		dataSourceTransactionManager.commit(transactionStatus);//数据会提交到数据库中。。。
	}
	
	/**
	 * 发生异常，回滚事务
	 */
	public void rollback(TransactionStatus transactionStatus){
		dataSourceTransactionManager.rollback(transactionStatus);
	}
}
