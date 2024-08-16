package example.node.manager.service.user;

import example.node.manager.bean.User;

public interface UserServiceI {
    //CR
    boolean create(User user);

    User readOne(User user);
}
