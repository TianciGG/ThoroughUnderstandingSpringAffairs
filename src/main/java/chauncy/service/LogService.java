package chauncy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chauncy.dao.LogDao;

@Service
public class LogService {
	
	@Autowired
	private LogDao logDao;
	
	@Transactional(propagation=Propagation.NEVER)
	public void addLog(){
		logDao.addLog();
		System.out.println("插入日志成功。。。");
	}
}
