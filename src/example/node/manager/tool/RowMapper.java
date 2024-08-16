package example.node.manager.tool;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T rowMap(ResultSet rs);
}
