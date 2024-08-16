package example.node.manager.swing;

import example.node.manager.bean.Node;
import example.node.manager.service.node.NodeServiceI;
import example.node.manager.service.node.impl.NodeServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NodeAdd {
    private JPanel nodeAdd;
    private JPanel addLabelsArea;
    private JPanel addTextInputArea;
    private JTextField addNodeIdInput;
    private JTextField addNodeRegionInput;
    private JTextField addNodeOsInput;
    private JTextField addNodeMemTotalInput;
    private JTextField addNodeDiskTotalInput;
    private JTextField addNodeBandwidthInput;
    private JTextField addNodeNameInput;
    private JLabel addNodeId;
    private JLabel addNodeRegion;
    private JLabel addNodeOs;
    private JLabel addNodeMemTotal;
    private JLabel addNodeDiskTotal;
    private JLabel addNodeBandwidth;
    private JLabel addNodeName;
    private JPanel addTitleArea;
    private JPanel addButtonArea;
    private JPanel addPlaceHold1;
    private JPanel addPalceHold2;
    private JLabel addTitle;
    private JButton addCommit;
    private JButton addCancel;
    private JPanel addPlaceHold3;
    private JPanel addPlaceHold4;

    private final NodeServiceI nodeService = new NodeServiceImpl();

    public NodeAdd(JFrame frame) {
        addCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node node = new Node();
                node.setNodeId(addNodeIdInput.getText());
                node.setNodeName(addNodeNameInput.getText());
                node.setNodeRegion(addNodeRegionInput.getText());
                node.setNodeOs(addNodeOsInput.getText());
                node.setNodeMemTotal(addNodeMemTotalInput.getText());
                node.setNodeDiskTotal(addNodeDiskTotalInput.getText());
                node.setNodeBandwidth(addNodeBandwidthInput.getText());

                if (nodeService.create(node)) {
                    addNodeIdInput.setText("");
                    addNodeNameInput.setText("");
                    addNodeRegionInput.setText("");
                    addNodeOsInput.setText("");
                    addNodeMemTotalInput.setText("");
                    addNodeDiskTotalInput.setText("");
                    addNodeBandwidthInput.setText("");
                    JOptionPane.showMessageDialog(frame, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(frame, "添加失败", "错误", JOptionPane.ERROR_MESSAGE);

            }
        });
        addCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String... a) {
        JFrame frame = new JFrame("服务器节点管理系统——添加节点");
        frame.setContentPane(new NodeAdd(frame).nodeAdd);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
