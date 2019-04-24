import org.springframework.context.support.ClassPathXmlApplicationContext;

import chauncy.service.UserService;

public class TestUserService {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.add3();
	}
}
