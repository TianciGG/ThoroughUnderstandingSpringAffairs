package chauncy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @methodDesc: 功能描述(添加用户)  
	 * @author: ChauncyWang
	 * @param:    
	 * @createTime: 2019年4月23日 下午3:40:16   
	 * @returnType: void
	 */
	public void addUser(String name,Integer age){
		String sql="insert into users(name,age) VALUES(?,?);";
		jdbcTemplate.update(sql,name,age);
		System.out.println("添加数据成功。。。");
	}
}
