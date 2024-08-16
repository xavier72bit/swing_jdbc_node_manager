package example.node.manager.swing;

import example.node.manager.bean.Node;
import example.node.manager.service.node.NodeServiceI;
import example.node.manager.service.node.impl.NodeServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NodeEdit {
    private JPanel nodeEdit;
    private JPanel editTitleArea;
    private JPanel editButtonArea;
    private JPanel editLabelsArea;
    private JPanel editTextInputArea;
    private JTextField editNodeIdInput;
    private JTextField editNodeRegionInput;
    private JTextField editNodeOsInput;
    private JTextField editNodeMemTotalInput;
    private JTextField editNodeDiskTotalInput;
    private JTextField editNodeBandwidthInput;
    private JTextField editNodeNameInput;
    private JLabel editNodeId;
    private JLabel editNodeRegion;
    private JLabel editNodeOs;
    private JLabel editNodeMemTotal;
    private JLabel editNodeDiskTotal;
    private JLabel editNodeBandwidth;
    private JLabel editNodeName;
    private JLabel editTitle;
    private JButton editSearch;
    private JButton editCommit;
    private JButton editCancel;
    private JPanel editPlaceHold1;
    private JPanel editPlaceHold2;
    private JPanel editPlaceHold3;
    private JPanel editPlaceHold4;

    private final NodeServiceI nodeService = new NodeServiceImpl();

    public NodeEdit(JFrame frame) {
        editSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = JOptionPane.showInputDialog(frame, "请输入节点ID", "提示",JOptionPane.INFORMATION_MESSAGE);
                if(null == id)
                    return;
                else{
                    Node node = new Node();
                    node.setNodeId(id);
                    node = nodeService.readOne(node);
                    if(null == node || null == node.getNodeId() || "".equals(node.getNodeId())){
                        JOptionPane.showMessageDialog(frame,"节点不存在！","警告",JOptionPane.WARNING_MESSAGE);
                    } else {
                        editNodeIdInput.setText(node.getNodeId());
                        editNodeNameInput.setText(node.getNodeName());
                        editNodeRegionInput.setText(node.getNodeRegion());
                        editNodeOsInput.setText(node.getNodeOs());
                        editNodeMemTotalInput.setText(node.getNodeMemTotal());
                        editNodeDiskTotalInput.setText(node.getNodeDiskTotal());
                        editNodeBandwidthInput.setText(node.getNodeBandwidth());
                    }
                }

            }
        });

        editCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node node = new Node();
                node.setNodeId(editNodeIdInput.getText());
                node.setNodeName(editNodeNameInput.getText());
                node.setNodeRegion(editNodeRegionInput.getText());
                node.setNodeOs(editNodeOsInput.getText());
                node.setNodeMemTotal(editNodeMemTotalInput.getText());
                node.setNodeDiskTotal(editNodeDiskTotalInput.getText());
                node.setNodeBandwidth(editNodeBandwidthInput.getText());

                if (nodeService.update(node)) {
                    JOptionPane.showMessageDialog(frame, "节点信息修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "节点信息修改失败！", "错误", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        editCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String... a) {
        JFrame frame = new JFrame("服务器节点管理系统——编辑节点信息");
        frame.setContentPane(new NodeEdit(frame).nodeEdit);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        editNodeIdInput = new JTextField();
        editNodeIdInput.setEditable(false);
    }
}
