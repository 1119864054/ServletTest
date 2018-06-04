package pers.shayz.test;

import pers.shayz.dao.UserDao;
import pers.shayz.dao.impl.UserDaoImpl;
import pers.shayz.entity.User;
import pers.shayz.service.CheckUserService;
import pers.shayz.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ZhouXiaoyu
 */
public class UserDaoTest {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();
        User zxy = new User();
        zxy.setName("zxy");
        zxy.setPassword("154312");
        zxy.setEmail("123456@qq.com");

        CheckUserService checkUserService = new CheckUserService();
        System.out.println(checkUserService.check(zxy));

    }
}
