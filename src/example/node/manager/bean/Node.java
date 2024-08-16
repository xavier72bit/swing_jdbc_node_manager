package example.node.manager.bean;

public class Node {
    private String nodeId;
    private String nodeName;
    private String nodeRegion;
    private String nodeOs;
    private String nodeMemTotal;
    private String nodeDiskTotal;
    private String nodeBandwidth;


    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeRegion() {
        return nodeRegion;
    }

    public void setNodeRegion(String nodeRegion) {
        this.nodeRegion = nodeRegion;
    }

    public String getNodeOs() { return nodeOs; }

    public void setNodeOs(String nodeOs) { this.nodeOs = nodeOs; }

    public String getNodeMemTotal() { return nodeMemTotal; }

    public void setNodeMemTotal(String nodeMemTotal) { this.nodeMemTotal = nodeMemTotal; }

    public String getNodeDiskTotal() { return nodeDiskTotal; }

    public void setNodeDiskTotal(String nodeDiskTotal) { this.nodeDiskTotal = nodeDiskTotal; }

    public String getNodeBandwidth() { return nodeBandwidth; }

    public void setNodeBandwidth(String node_bandwidth) { this.nodeBandwidth = node_bandwidth; }
}
