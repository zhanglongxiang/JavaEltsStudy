package cn.edu.lyu.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.WindowEvent;
import com.sun.security.ntlm.Client;

public class LoginFrame extends JFrame{
	
	private JTextField nameField;
	private JPasswordField passwordField;
	private ClientContext context;
	
	public LoginFrame(){
		init();
	}
	
	public LoginFrame(ClientContext context){
		init();
		this.context = context;
	}

	private void init() {
		setTitle("临沂大学在线测试系统-登录");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				context.exit(LoginFrame.this);
			}
		});
		setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel pane= new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(10, 10, 10, 10));
		pane.add(BorderLayout.NORTH,new JLabel("登录系统",JLabel.CENTER));
		pane.add(BorderLayout.CENTER,createNamePwdPane());
		pane.add(BorderLayout.SOUTH,createBtnPane());
		return pane;
	}
	
	
	private JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton login = new JButton("登录");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				context.login(LoginFrame.this);
			}
		});
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				context.exit(LoginFrame.this);
			}
		});
		pane.add(login);
		pane.add(cancel);
		return pane;
	}

	private JPanel createNamePwdPane() {
		
		JPanel pane = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new GridLayout(2, 1));
		pane.add(BorderLayout.NORTH,top);
		top.add(createNamePane());
		top.add(createPwdPane());;
		return pane;
	}

	private JPanel createPwdPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(BorderLayout.WEST,new JLabel("密码:"));
		passwordField = new JPasswordField();
		pane.add(BorderLayout.CENTER,passwordField);
		//pane.add(BorderLayout.CENTER,new JPasswordField());
		return pane;
	}

	private JPanel createNamePane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(BorderLayout.WEST,new JLabel("编号:"));
		nameField = new JTextField();
		pane.add(BorderLayout.CENTER,nameField);
		//pane.add(BorderLayout.CENTER,new JTextField());
		return pane;
	}

	public void showView(){
		setVisible(true);
	}
	
	public int getId(){
		String id = nameField.getText();
		return Integer.parseInt(id);
	}
	
	public String getPwd(){
		char[] pwd = passwordField.getPassword();
		return new String(pwd);
	}

}
