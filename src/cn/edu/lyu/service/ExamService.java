package cn.edu.lyu.service;

import java.util.List;

import cn.edu.lyu.entity.ExamInfo;
import cn.edu.lyu.entity.QuestionInfo;
import cn.edu.lyu.entity.User;


public interface ExamService {
	public User login(int id,String pwd) throws Exception;
	
	ExamInfo start() throws Exception;
	
	QuestionInfo getQuestion(int index) throws Exception;
	
	void sendUserAnswers(int questionIndex,List<Integer> answers);
	
	int commit();
	int result() throws Exception;

}
