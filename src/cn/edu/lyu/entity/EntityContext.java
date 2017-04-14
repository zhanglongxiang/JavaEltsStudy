package cn.edu.lyu.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.lyu.util.Config;

public class EntityContext {
	
	private Config config;
	private Map<Integer, User> users = 
			new HashMap<Integer,User>();
	//所有题目
	private List<Question> questions = 
			new ArrayList<Question>();
	//Integer是试题level，List<Question>是每个分类下所有的题
	private Map<Integer, List<Question>> levels = 
			new HashMap<Integer,List<Question>>();
	
	private int id;//我给加上了试题id计数器
	public EntityContext(Config config)throws Exception{
		this.config = config;
		loadUsers();
		loadQuestions();
	}

	private void loadQuestions() throws Exception{
		String file = config.getString("QuestionFile");
		BufferedReader in = 
				new BufferedReader(new FileReader(file));
		String str;
		while((str=in.readLine())!=null){
			if(str.trim().equals("")){
				continue;
			}
			Question q = parseField(str);
			readTitle(q,in);
			readOptions(q,in);
			questions.add(q);
			addByLevel(q);
		}
		in.close();
	}

	private Question parseField(String str) throws Exception{
		String reg = "^@option=4," + 
				"answer=[0-3](/[0-3]){0,3},"+
				"score=\\d{1,2},level=([1-9]|10)$";
		if(!str.matches(reg)){
			throw new IOException("文件格式不正确!");
		}
		String[] data = str.split("[@,]");
		Question q = new Question();
		q.setOptionNums(Integer.parseInt(data[1].split("=")[1]));
		q.setAnswers(parseAnswer(data[2].split("=")[1]));
		q.setScore(Integer.parseInt(data[3].split("=")[1]));
		q.setLevel(Integer.parseInt(data[4].split("=")[1]));
		q.setId(id++);//我给加上了试题id set方法
		return q;
	}

	private List<Integer> parseAnswer(String str) {
		List<Integer> answer = new ArrayList<Integer>();
		String[] data = str.split("/");
		for(String s : data){
			answer.add(new Integer(s));
		}
		return answer;
	}

	private void addByLevel(Question q) {
		List<Question> list = 
				levels.get(q.getLevel());
		if(list == null){
			list = new ArrayList<Question>();
			levels.put(q.getLevel(), list);
		}
		list.add(q);
	}

	private void readOptions(Question q, BufferedReader in) throws Exception {
		List<String> opts = new ArrayList<String>();
		for(int i=0; i<4; i++){
			opts.add(in.readLine());
		}
		q.setOptions(opts);
	}

	private void readTitle(Question q, BufferedReader in) throws Exception {
		q.setTitle(in.readLine());
	}

	private void loadUsers() throws Exception{
		String filename = 
				config.getString("UserFile");
		BufferedReader in = 
				new BufferedReader(
						new FileReader(filename));
		String str;
		while((str = in.readLine()) != null){
			if(str.trim().equals("")){
				continue;
			}
			User u = parseUser(str);
			users.put(u.getId(), u);
		}
	}

	private User parseUser(String str) {
		User u = new User();
		String[] data = str.split(":");
		u.setId(Integer.parseInt(data[0]));
		u.setName(data[1]);
		u.setPasswd(data[2]);
		u.setPhone(data[3]);
		u.setEmail(data[4]);
		return u;
	}
	
	public User getUser(int id){
		return users.get(id);
	}
	
	public Question getQuestion(int id){
		for(Question q : questions){
			if(q.getId() == id)
				return q;
		}
		return null;
	}
	
	public List<Question> getQuestions(int level){
		return new ArrayList<Question>(
				levels.get(level));
	}
	public static void main(String[] args) {
		try{
			Config config = new Config("client.properties");
			EntityContext context = 
					new EntityContext(config);
			System.out.println(context.getUser(1000).getName());
			//System.out.println(context.questions);
			//System.out.println(context.questions.get(1).getId());
			//System.out.println(context.levels);
			//System.out.println(context.getQuestions(4));
			//System.out.println(context.getQuestion(1));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
