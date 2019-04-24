# ThoroughUnderstandingSpringAffairs 深入理解Spring事务
1.C3P0+SpringJdbcTemplate事务控制环境搭建：src/main/java/chauncy/dao/UserDao.java+src/main/java/chauncy/service/UserService.java+src/main/resources/beans.xml+src/test/java/TestUserService.java
2.编程事务(自定义事务)的实现：src/main/java/chauncy/dao/UserDao.java+src/main/java/chauncy/service/UserService.java+src/main/java/chauncy/transaction/TransactionManager.java+src/main/resources/beans.xml+src/test/java/TestUserService.java
3.声明式事务的XML方式实现：src/main/resources/beans.xml+src/main/java/chauncy/service/UserService.java+src/test/java/TestUserService.java