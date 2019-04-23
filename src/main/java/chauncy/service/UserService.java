package chauncy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chauncy.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void add(){
		userDao.addUser("zhangsan-"+System.currentTimeMillis(), 18);
		System.out.println("UserService的add方法----zhangsan插入成功----执行完毕");
		int i=1/0;
		userDao.addUser("lisi-"+System.currentTimeMillis(), 18);
		System.out.println("UserService的add方法----zhangsan李四成功----执行完毕");
	}
}
