package cn.edu.lyu.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.edu.lyu.entity.User;

public class MenuFrame extends JFrame{
	
	private ClientContext context;
	private JLabel info;
	public MenuFrame(ClientContext context){
		this();
		this.context = context;
	}
	
	
	public MenuFrame(){
		init();
	}

	private void init() {
		setTitle("临沂大学在线考试系统");
		setSize(600, 400);
		setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(BorderLayout.NORTH,new JLabel("标题"));
		pane.add(BorderLayout.SOUTH,new JLabel("临大科技.版权所有",JLabel.RIGHT));
		ImageIcon icon = new ImageIcon(getClass().getResource("title.png"));
		pane.add(BorderLayout.NORTH,new JLabel(icon));
		pane.add(BorderLayout.CENTER,ceateMenuPane());
		return pane;
	}

	private JPanel ceateMenuPane() {
		JPanel pane = new JPanel(new BorderLayout());
		info = new JLabel("XXX同学你好！",JLabel.CENTER);
		//JLabel info = new JLabel("XXX同学你好",JLabel.CENTER);
		pane.add(BorderLayout.NORTH,info);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}

	private JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton start = new JButton("开始");
		JButton result = new JButton("分数");
		JButton msg = new JButton("考试规则");
		JButton exit = new JButton("离开");
		pane.add(start);
		pane.add(result);
		pane.add(msg);
		pane.add(exit);
		return pane;
	}
	
	public void showView(){
		setVisible(true);
	}
	
	public void updateView(){
		User u = context.getLoginUser();
		String str = "你好，欢迎" + u.getName();
		info.setText(str);
	}

}
