package example.node.manager.jdbc;

import example.node.manager.tool.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private static final String JDBC_CONNECTION_USER = "swing_jdbc_node_manager";
    private static final String JDBC_CONNECTION_PASS = "swing_jdbc_node_manager";
    private static final String JDBC_CONNECTION_URL = "jdbc:mysql://127.0.0.1:3306/swing_jdbc_node_manager";
    private static final String JDBC_CONNECTION_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet rs = null;

    static {
        try {
            Class.forName(JDBC_CONNECTION_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (null == connection || connection.isClosed()) {
                connection = DriverManager.getConnection(JDBC_CONNECTION_URL, JDBC_CONNECTION_USER, JDBC_CONNECTION_PASS);
            }

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean delete(String sql, Object[] args) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);

            setPreparedStatementParameter(args);

            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            closeResource();
        }

        return false;
    }

    public boolean update(String sql, Object[] args) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);

            setPreparedStatementParameter(args);

            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }

        return false;
    }

    public boolean insert(String sql, Object[] args) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);

            setPreparedStatementParameter(args);

            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }

        return false;
    }

    public <T> T selectOne(String sql, Object[] args, RowMapper<T> rowMapper) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);

            setPreparedStatementParameter(args);

            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                T t = rowMapper.rowMap(rs);

                return t;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }

        return null;
    }

    public <T> List<T> selectList(String sql, Object[] args, RowMapper<T> rowMapper) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);

            setPreparedStatementParameter(args);

            rs = preparedStatement.executeQuery();

            List<T> list = new ArrayList<>();

            while (rs.next()) {
                T t = rowMapper.rowMap(rs);

                list.add(t);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }

        return new ArrayList<>();
    }

    public <T> List<T> selectAll(String sql, Object[] args, RowMapper<T> rowMapper) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);

            setPreparedStatementParameter(args);

            rs = preparedStatement.executeQuery();

            List<T> list = new ArrayList<>();

            while (rs.next()) {
                T t = rowMapper.rowMap(rs);

                list.add(t);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }

        return new ArrayList<>();
    }

    private void setPreparedStatementParameter(Object[] args) throws SQLException {
        ParameterMetaData metaData = preparedStatement.getParameterMetaData();
        int count = metaData.getParameterCount();

        for (int i = 1; i <= count; i++) {
            preparedStatement.setObject(i, args[i - 1]);
        }
    }

    private void closeResource() {
        try {
            if (null != preparedStatement || !preparedStatement.isClosed()) {
                preparedStatement.close();
                preparedStatement = null;
            }

            if (null != connection || !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
