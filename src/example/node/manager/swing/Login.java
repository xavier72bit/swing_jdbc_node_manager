package example.node.manager.swing;

import example.node.manager.bean.User;
import example.node.manager.dao.user.impl.UserDaoImpl;
import example.node.manager.service.user.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {
    private JButton loginButton;
    private JTextField userNameInput;
    private JLabel loginTopic;
    private JLabel loginUser;
    private JLabel loginPassword;
    private JPanel login;
    private JPanel loginInputArea;
    private JPanel loginPlaceHold1;
    private JPanel loginPlaceHold2;
    private JPanel loginPlaceHold3;
    private JPanel loginPlaceHold4;
    private JPanel loginPlaceHold5;
    private JPanel loginPlaceHold6;
    private JPanel loginPlaceHold7;
    private JPanel loginPlaceHold8;
    private JPanel loginPlaceHold9;
    private JPanel loginPlaceHold10;
    private JPanel loginPlaceHold11;
    private JPanel loginPlaceHold12;
    private JPanel loginPlaceHold13;
    private JPanel loginPlaceHold14;
    private JPanel loginPlaceHold15;
    private JPasswordField passwordInput;
    private JButton userRegister;


    public Login(JFrame frame) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                UserServiceImpl userServiceImpl = new UserServiceImpl();
                String name = userNameInput.getText();
                String password = new String(passwordInput.getPassword());
                user.setUserName(name);
                User userResult = userServiceImpl.readOne(user);

                if (null == userResult) {
                    JOptionPane.showMessageDialog(frame,"用户不存在！", "错误提示", JOptionPane.WARNING_MESSAGE);
                }

                if(userResult.getPassWord().equals(password)){
                    Menu.main();
                    frame.dispose();
                } else {
                    userNameInput.setText("");
                    passwordInput.setText("");
                    JOptionPane.showMessageDialog(frame,"用户名或密码错误，请重新输入", "错误提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        userNameInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if('\n' == e.getKeyChar())
                    passwordInput.requestFocus();
            }
        });
        passwordInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if('\n' == e.getKeyChar())
                    loginButton.doClick();
            }
        });
        userRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                UserDaoImpl userDaoImpl = new UserDaoImpl();
                String usernameReg = JOptionPane.showInputDialog(frame,"请输入用户名","用户注册",JOptionPane.INFORMATION_MESSAGE);
                String passwordReg = JOptionPane.showInputDialog(frame,"请输入密码","用户注册",JOptionPane.INFORMATION_MESSAGE);

                user.setUserName(usernameReg);
                user.setPassWord(passwordReg);

                if (userDaoImpl.insert(user)){
                    JOptionPane.showMessageDialog(frame,"注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,"注册失败", "提示", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("服务器节点管理系统——登录");
        frame.setContentPane(new Login(frame).login);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

