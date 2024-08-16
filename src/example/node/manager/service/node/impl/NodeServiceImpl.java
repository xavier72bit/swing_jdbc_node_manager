package example.node.manager.service.node.impl;

import example.node.manager.bean.Node;
import example.node.manager.dao.node.NodeDaoI;
import example.node.manager.dao.node.impl.NodeDaoImpl;
import example.node.manager.service.node.NodeServiceI;

import java.util.List;

public class NodeServiceImpl implements NodeServiceI {

    @Override
    public boolean create(Node node) {
        NodeDaoI nodeDaoI = new NodeDaoImpl();

        return nodeDaoI.insert(node);
    }

    @Override
    public boolean update(Node node) {
        NodeDaoI nodeDaoI = new NodeDaoImpl();

        return nodeDaoI.update(node);
    }

    @Override
    public boolean delete(Node node) {
        if (null == node || null == node.getNodeId() || node.getNodeId().isEmpty()) {
            return false;
        }

        NodeDaoI nodeDaoI = new NodeDaoImpl();

        return nodeDaoI.delete(node);
    }

    @Override
    public Node readOne(Node node) {
        if (null == node || null == node.getNodeId() || node.getNodeId().isEmpty()) {
            return null;
        }

        NodeDaoI nodeDaoI = new NodeDaoImpl();

        return nodeDaoI.selectOne(node);
    }

    @Override
    public List<Node> readList(Node node) {
        NodeDaoI nodeDaoI = new NodeDaoImpl();

        return nodeDaoI.selectList(node);
    }

    @Override
    public List<Node> readAll(Node node) {
        NodeDaoI nodeDaoI = new NodeDaoImpl();

        return nodeDaoI.selectAll(node);
    }
}
