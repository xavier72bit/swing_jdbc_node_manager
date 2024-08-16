package example.node.manager.dao.user.impl;

import example.node.manager.tool.RowMapper;
import example.node.manager.bean.User;
import example.node.manager.dao.user.UserDaoI;
import example.node.manager.jdbc.JdbcTemplate;

import java.sql.ResultSet;

public class UserDaoImpl implements UserDaoI {
    @Override
    public boolean insert(User user) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO user (user_name, pass_word) VALUES (?, ?)";

        Object[] args = {
                user.getUserName(),
                user.getPassWord()
        };
        return jdbcTemplate.insert(sql, args);
    }

    @Override
    public User selectOne(User user) {
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate();

            String sql = "SELECT user_name, pass_word FROM user WHERE user_name = ? LIMIT 0,1";

            Object[] args = {
                    user.getUserName()
            };

            return jdbcTemplate.selectOne(sql, args, new RowMapper<User>(){
                @Override
                public User rowMap(ResultSet rs) {
                    try {
                        User result = new User();

                        result.setUserName(rs.getString("user_name"));
                        result.setPassWord(rs.getString("pass_word"));

                        return result;
                    } catch (Exception e){
                        e.printStackTrace();

                        return null;
                    }
                }
            });
        } catch (Exception e){
            e.printStackTrace();

            return null;
        }
    }
}
