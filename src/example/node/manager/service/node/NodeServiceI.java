package example.node.manager.service.node;

import example.node.manager.bean.Node;

import java.util.List;

public interface NodeServiceI {
    //  CRUD
    boolean create(Node node);
    boolean update(Node node);
    boolean delete(Node node);
    Node readOne(Node node);
    List<Node> readList(Node node);
    List<Node> readAll(Node node);
}
