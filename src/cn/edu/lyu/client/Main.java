package cn.edu.lyu.client;

import cn.edu.lyu.entity.EntityContext;
import cn.edu.lyu.gui.ClientContext;
import cn.edu.lyu.gui.LoginFrame;
import cn.edu.lyu.gui.MenuFrame;
import cn.edu.lyu.service.ExamServiceImpl;
import cn.edu.lyu.util.Config;

public class Main {
	public static void main(String[] args) {
		try{
			Config config = new Config("client.properties");
			EntityContext entityContext = new EntityContext(config);
			ExamServiceImpl service = new ExamServiceImpl(entityContext);
			ClientContext context = new ClientContext(service);
			LoginFrame loginFrame = new LoginFrame(context);
			MenuFrame menuFrame = new MenuFrame(context);
			context.setLoginFrame(loginFrame);
			context.setMenuFrame(menuFrame);
			context.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
