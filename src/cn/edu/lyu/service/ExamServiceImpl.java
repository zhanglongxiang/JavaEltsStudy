package cn.edu.lyu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.edu.lyu.entity.EntityContext;
import cn.edu.lyu.entity.ExamInfo;
import cn.edu.lyu.entity.Question;
import cn.edu.lyu.entity.QuestionInfo;
import cn.edu.lyu.entity.User;
import cn.edu.lyu.util.Config;
import cn.edu.lyu.util.Md5Utils;

public class ExamServiceImpl implements ExamService{
	
	private EntityContext context;
	private List<QuestionInfo> paper = new ArrayList<QuestionInfo>();
	private Config config;
	private User loginUser;
	private int score;
	
	public ExamServiceImpl(EntityContext entityContext){
		this.context = entityContext;
	}
	
	public ExamServiceImpl(EntityContext entityContext,Config config){
		this.context = entityContext;
		this.config = config;
	}
	
	public User login(int id,String pwd)throws Exception{
		User u = context.getUser(id);
		if(u == null)
			throw new Exception("无此用户");
		if(u.getPasswd().equals(Md5Utils.md5(pwd))){
			loginUser = u;
			return u;
		}
		throw new Exception("密码错误");
	}

	@Override
	public ExamInfo start() throws Exception {
		buildPaper();
		ExamInfo info = new ExamInfo();
		info.setQuestionCount(paper.size());
		info.setTimeLimit(config.getInt("TimeLimit"));
		info.setTitle(config.getString("PaperTitle"));
		info.setUser(loginUser);
		return info;
	}

	private void buildPaper() {
		int i = 0;
		Random random = new Random();
		for(int level = Question.LEVEL1;
				level <= Question.LEVEL10;level++){
			List<Question> list = 
					context.getQuestions(level);
			Question q1 = list.remove(random.nextInt(list.size()));
			Question q2 = list.remove(random.nextInt(list.size()));
			paper.add(new QuestionInfo(i++,q1));
			paper.add(new QuestionInfo(i++,q2));
		}
	}

	@Override
	public QuestionInfo getQuestion(int index) throws Exception {
		return paper.get(index);
	}

	@Override
	public void sendUserAnswers(int questionIndex, List<Integer> answers) {
		QuestionInfo q = paper.get(questionIndex);
		q.setUserAnswers(new ArrayList<Integer>(answers));
	}

	@Override
	public int commit() {
		for(QuestionInfo q : paper){
			List<Integer> userAnswer = q.getUserAnswers();
			if(userAnswer.equals(q.getQuestion().getAnswers())){
				score += q.getQuestion().getScore();
			}
		}
		return score;
	}

	@Override
	public int result() throws Exception {
		return score;
	}
	
	public static void main(String[] args) {
		try{
			Config config = 
					new Config("client.properties");
			EntityContext entityContext = 
					new EntityContext(config);
			ExamServiceImpl service = 
					new ExamServiceImpl(entityContext,config);
			
			ExamInfo examInfo = service.start();
			
			System.out.println(service.paper);
					
		}catch(Exception e){
			
		}
	}

}
