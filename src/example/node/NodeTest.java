package example.node;

import example.node.manager.bean.Node;
import example.node.manager.service.node.NodeServiceI;
import example.node.manager.service.node.impl.NodeServiceImpl;

import java.util.List;

public class NodeTest {
    public static void main(String[] args) {
        NodeServiceI nodeServiceI = new NodeServiceImpl();

        // 添加节点
        Node addNode = new Node();

        addNode.setNodeId("222222");
        addNode.setNodeName("mysql_04");
        addNode.setNodeRegion("大连");
        addNode.setNodeOs("CentOS7");
        addNode.setNodeMemTotal("4000");
        addNode.setNodeDiskTotal("8000");
        addNode.setNodeBandwidth("400");

        nodeServiceI.create(addNode);

        // 更新节点
        Node updateNode = new Node();

        updateNode.setNodeId("123456");
        updateNode.setNodeName("java_new");
        updateNode.setNodeRegion("石家庄");
        updateNode.setNodeOs("Windows");
        updateNode.setNodeMemTotal("64323");
        updateNode.setNodeDiskTotal("6547897");
        updateNode.setNodeBandwidth("7666");

        nodeServiceI.update(updateNode);
        // 删除节点
        Node deleteNode = new Node();

        deleteNode.setNodeId("123456");

        nodeServiceI.delete(deleteNode);

        // 查询节点
        Node readOneNode = new Node();

        readOneNode.setNodeId("12345");

        Node resultNode = nodeServiceI.readOne(readOneNode);

        System.out.println("11111111111111111111111111111111111111111111111111111111111");
        System.out.println(resultNode.getNodeId() + " : " + resultNode.getNodeName() + " : " + resultNode.getNodeRegion() + " : " + resultNode.getNodeOs() + " : " + resultNode.getNodeMemTotal() + " : " + resultNode.getNodeDiskTotal() + " : " + resultNode.getNodeBandwidth());


        // 查询节点List
        Node listNode = new Node();

        listNode.setNodeName("java");

        List<Node> nodeList = nodeServiceI.readList(listNode);

        for (Node node : nodeList) {
            System.out.println("=============================================================");
            System.out.println(node.getNodeId() + " : " + node.getNodeName() + " : " + node.getNodeRegion() + " : " + node.getNodeOs() + " : " + node.getNodeMemTotal() + " : " + node.getNodeDiskTotal() + " : " + node.getNodeBandwidth());
        }
    }
}
