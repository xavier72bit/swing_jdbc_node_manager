package example.node.manager.dao.node;

import example.node.manager.bean.Node;

import java.util.List;

public interface NodeDaoI {
    boolean insert(Node node);
    boolean delete(Node node);
    boolean update(Node node);
    Node selectOne(Node node);
    List<Node> selectList(Node node);
    List<Node> selectAll(Node node);
}
