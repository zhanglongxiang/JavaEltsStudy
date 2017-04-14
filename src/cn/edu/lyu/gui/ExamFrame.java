package cn.edu.lyu.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class ExamFrame extends JFrame{
	public ExamFrame(){
		init();
	}
	
	private void init(){
		setTitle("�ٴ����߿���");
		setSize(600, 300);
		setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(getClass().getResource("exam_title.png"));
		pane.add(BorderLayout.NORTH,new JLabel(icon));
		pane.add(BorderLayout.CENTER,createCenterPane());
		pane.add(BorderLayout.SOUTH,createToolsPane());
		return pane;
	}

	private JPanel createToolsPane() {
		JPanel pane = new JPanel();
		pane.setBorder(new EmptyBorder(0, 10, 0, 10));
		JLabel questionCount = new JLabel("��Ŀ����:20��1��");
		JLabel time = new JLabel("ʣ��ʱ��:222��");
		pane.add(BorderLayout.WEST,questionCount);
		pane.add(BorderLayout.EAST,time);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}

	private JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton prev = new JButton("��һ��");
		JButton next = new JButton("��һ��");
		JButton send = new JButton("����");
		pane.add(prev);
		pane.add(next);
		pane.add(send);
		return pane;
	}

	private JPanel createCenterPane() {
		JPanel pane = new JPanel(new BorderLayout());
		JLabel examInfo = new JLabel("����:XXX ����:XXX ����ʱ��:XXX");
		pane.add(BorderLayout.NORTH,examInfo);
		pane.add(BorderLayout.CENTER,createQuestionPane());
		pane.add(BorderLayout.SOUTH,createOptionsPane());
		return pane;
	}

	private JPanel createOptionsPane() {
		JPanel pane = new JPanel();
		JCheckBox a = new JCheckBox("A");
		JCheckBox b = new JCheckBox("B");
		JCheckBox c = new JCheckBox("C");
		JCheckBox d = new JCheckBox("D");
		pane.add(a);
		pane.add(b);
		pane.add(c);
		pane.add(d);
		return pane;
	}

	private JScrollPane createQuestionPane() {
		JScrollPane pane = new JScrollPane();
		pane.setBorder(new TitledBorder("��Ŀ"));
		JTextArea questionArea = new JTextArea();
		questionArea.setText("����\nA.\nB.");
		pane.getViewport().add(questionArea);
		return pane;
	}
	
	public void showView(){
		setVisible(true);
	}

}
