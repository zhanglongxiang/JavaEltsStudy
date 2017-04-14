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
		setTitle("临大在线考试");
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
		JLabel questionCount = new JLabel("题目数量:20的1题");
		JLabel time = new JLabel("剩余时间:222秒");
		pane.add(BorderLayout.WEST,questionCount);
		pane.add(BorderLayout.EAST,time);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}

	private JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton prev = new JButton("上一题");
		JButton next = new JButton("下一题");
		JButton send = new JButton("交卷");
		pane.add(prev);
		pane.add(next);
		pane.add(send);
		return pane;
	}

	private JPanel createCenterPane() {
		JPanel pane = new JPanel(new BorderLayout());
		JLabel examInfo = new JLabel("姓名:XXX 考试:XXX 考试时间:XXX");
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
		pane.setBorder(new TitledBorder("题目"));
		JTextArea questionArea = new JTextArea();
		questionArea.setText("问题\nA.\nB.");
		pane.getViewport().add(questionArea);
		return pane;
	}
	
	public void showView(){
		setVisible(true);
	}

}
