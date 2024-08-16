package example.node.manager.swing;

import example.node.manager.bean.Node;
import example.node.manager.service.node.impl.NodeServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private JPanel menu;
    private JButton menuNodeSearch;
    private JButton menuNodeAdd;
    private JButton menuNodeDel;
    private JButton menuNodeEdit;
    private JTable resultTable;
    private JPanel menuPlaceHold1;
    private JPanel menuPlaceHold2;
    private static final Object[] tableHead = new Object[]{"节点ID", "节点名称", "节点地区", "操作系统", "内存空间", "磁盘容量", "网络带宽"};

    public Menu(JFrame frame) {
        menuNodeSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = JOptionPane.showInputDialog(frame, "请输入要查询的条件:id或name或all", "查询",JOptionPane.INFORMATION_MESSAGE);
                if ("id".equals(option)) {
                    String id = JOptionPane.showInputDialog(frame,"请输入节点ID", "节点ID查询", JOptionPane.INFORMATION_MESSAGE);
                    if (null == id){
                        JOptionPane.showMessageDialog(frame,"请输入内容！", "错误提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    else {
                        Node nodeSimple = new Node();
                        nodeSimple.setNodeId(id);
                        NodeServiceImpl nodeServiceSimple = new NodeServiceImpl();
                        Node nodeResult = nodeServiceSimple.readOne(nodeSimple);

                        if (null == nodeResult){
                            JOptionPane.showMessageDialog(frame,"节点不存在！", "错误提示", JOptionPane.WARNING_MESSAGE);
                        }
                        List<Node> resultList = new ArrayList<>();
                        resultList.add(nodeResult);
                        setData(resultList);
                    }
                } else if ("name".equals(option)) {
                    String name = JOptionPane.showInputDialog(frame,"请输入节点名称（支持模糊搜索）","节点名称查询",JOptionPane.INFORMATION_MESSAGE);
                    Node nodeMulti = new Node();
                    nodeMulti.setNodeName(name);
                    List<Node> multiResultList = new ArrayList<>();
                    NodeServiceImpl nodeServiceMulti = new NodeServiceImpl();
                    multiResultList = nodeServiceMulti.readList(nodeMulti);
                    setData(multiResultList);
                } else if("all".equals(option)){
                    Node nodeAll = new Node();
                    nodeAll.setNodeName("111");
                    List<Node> allResultList = new ArrayList<>();
                    NodeServiceImpl nodeServiceAll = new NodeServiceImpl();
                    allResultList = nodeServiceAll.readAll(nodeAll);
                    setData(allResultList);
                } else {
                    JOptionPane.showMessageDialog(frame, "请输入正确的选项", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        menuNodeAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NodeAdd.main();
            }
        });
        menuNodeDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NodeDel.main();
            }
        });
        menuNodeEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NodeEdit.main();
            }
        });
    }

    public static void main(String... a) {
        JFrame frame = new JFrame("服务器节点管理系统——主菜单");
        frame.setContentPane(new Menu(frame).menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        resultTable = new JTable(new DefaultTableModel(new Object[][]{}, tableHead) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    public void setData(List<Node> nodeList) {
        Object[][] data = new Object[nodeList.size()][7];

        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            data[i][0] = node.getNodeId();
            data[i][1] = node.getNodeName();
            data[i][2] = node.getNodeRegion();
            data[i][3] = node.getNodeOs();
            data[i][4] = node.getNodeMemTotal();
            data[i][5] = node.getNodeDiskTotal();
            data[i][6] = node.getNodeBandwidth();
        }

        ((DefaultTableModel) resultTable.getModel()).setDataVector(data, tableHead);
    }
}
