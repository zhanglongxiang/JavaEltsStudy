package cn.edu.lyu.gui;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import cn.edu.lyu.entity.User;
import cn.edu.lyu.service.ExamService;

public class ClientContext {
	ExamService service;
	
	public ClientContext(ExamService service){
		this.service = service;
	}
	
	private LoginFrame loginFrame;
	private MenuFrame menuFrame;
	private ExamFrame examFrame;
	
	private User loginUser;
	
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}
	
	public User getLoginUser(){
		return loginUser;
	}

	public void login(JFrame source){
		try{
			int id = loginFrame.getId();//ȥʵ��
			String pwd = loginFrame.getPwd();//ȥʵ��
			loginUser = service.login(id,pwd);
			source.setVisible(false);
			menuFrame.updateView();//���½���
			menuFrame.showView();
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(source, e.getMessage());
		}
	}
	
	public void show(){
		loginFrame.setVisible(true);
	}
	public void exit(LoginFrame source) {
		int val = JOptionPane.showConfirmDialog(source, "��ѽ?","�뿪ϵͳ",JOptionPane.YES_NO_OPTION);
		if(val == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}
