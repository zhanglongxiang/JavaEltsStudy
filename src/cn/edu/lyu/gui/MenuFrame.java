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
		setTitle("���ʴ�ѧ���߿���ϵͳ");
		setSize(600, 400);
		setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(BorderLayout.NORTH,new JLabel("����"));
		pane.add(BorderLayout.SOUTH,new JLabel("�ٴ�Ƽ�.��Ȩ����",JLabel.RIGHT));
		ImageIcon icon = new ImageIcon(getClass().getResource("title.png"));
		pane.add(BorderLayout.NORTH,new JLabel(icon));
		pane.add(BorderLayout.CENTER,ceateMenuPane());
		return pane;
	}

	private JPanel ceateMenuPane() {
		JPanel pane = new JPanel(new BorderLayout());
		info = new JLabel("XXXͬѧ��ã�",JLabel.CENTER);
		//JLabel info = new JLabel("XXXͬѧ���",JLabel.CENTER);
		pane.add(BorderLayout.NORTH,info);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}

	private JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton start = new JButton("��ʼ");
		JButton result = new JButton("����");
		JButton msg = new JButton("���Թ���");
		JButton exit = new JButton("�뿪");
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
		String str = "��ã���ӭ" + u.getName();
		info.setText(str);
	}

}
