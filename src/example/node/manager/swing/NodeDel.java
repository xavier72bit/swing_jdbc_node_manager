package example.node.manager.swing;

import example.node.manager.bean.Node;
import example.node.manager.service.node.NodeServiceI;
import example.node.manager.service.node.impl.NodeServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NodeDel {
    private JPanel nodeDel;
    private JButton delConfirm;
    private JButton delCancel;
    private JPanel delTitleArea;
    private JLabel delTitle;
    private JPanel delButtonArea;
    private JPanel delInputArea;
    private JTextField delNodeIdInput;
    private JLabel delNodeId;

    private final NodeServiceI nodeService = new NodeServiceImpl();

    public NodeDel(JFrame frame) {
        delConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = delNodeIdInput.getText();
                if("".equals(id)){
                    JOptionPane.showMessageDialog(frame, "节点ID不可为空", "错误", JOptionPane.ERROR_MESSAGE);
                }
                Node node = new Node();
                node.setNodeId(id);
                if(nodeService.delete(node)){
                    JOptionPane.showMessageDialog(frame, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    delNodeIdInput.setText("");
                } else{
                    JOptionPane.showMessageDialog(frame, "删除失败", "错误", JOptionPane.ERROR_MESSAGE);
                }



            }
        });

        delCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String... a) {
        JFrame frame = new JFrame("服务器节点管理系统——删除");
        frame.setContentPane(new NodeDel(frame).nodeDel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
