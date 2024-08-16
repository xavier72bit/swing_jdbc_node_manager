package example.node.manager.service.user.impl;

import example.node.manager.bean.User;
import example.node.manager.dao.user.UserDaoI;
import example.node.manager.dao.user.impl.UserDaoImpl;
import example.node.manager.service.user.UserServiceI;

public class UserServiceImpl implements UserServiceI {

    @Override
    public boolean create(User user) {
        UserDaoI userDaoI = new UserDaoImpl();

        return userDaoI.insert(user);
    }

    @Override
    public User readOne(User user) {
        if (null == user || null == user.getUserName() || user.getUserName().isEmpty()) {
            return null;
        }

        UserDaoI userDaoI = new UserDaoImpl();

        return userDaoI.selectOne(user);
    }
}
