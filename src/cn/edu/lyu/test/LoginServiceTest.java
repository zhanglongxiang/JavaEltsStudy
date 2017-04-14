package cn.edu.lyu.test;

import java.util.List;

import cn.edu.lyu.entity.ExamInfo;
import cn.edu.lyu.entity.QuestionInfo;
import cn.edu.lyu.entity.User;
import cn.edu.lyu.gui.ClientContext;
import cn.edu.lyu.gui.LoginFrame;
import cn.edu.lyu.gui.MenuFrame;
import cn.edu.lyu.service.ExamService;

public class LoginServiceTest {
	public static void main(String[] args) {
		DemoService service = new DemoService();
		ClientContext context = new ClientContext(service);
		LoginFrame loginFrame = new LoginFrame(context);
		MenuFrame menuFrame = new MenuFrame(context);
		context.setLoginFrame(loginFrame);
		context.setMenuFrame(menuFrame);
		context.show();
	}

}

class DemoService implements ExamService{

	@Override
	public User login(int id, String pwd) throws Exception {
		if(id == 1001 && pwd.equals("1234")){
			return new User("张龙翔",1001,"1234");
		}
		throw new Exception("无此用户！");
	}

	@Override
	public ExamInfo start() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionInfo getQuestion(int index) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendUserAnswers(int questionIndex, List<Integer> answers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int commit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int result() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
