package example.node.manager.dao.user;

import example.node.manager.bean.User;

public interface UserDaoI {
    boolean insert(User user);
    User selectOne(User user);
}
