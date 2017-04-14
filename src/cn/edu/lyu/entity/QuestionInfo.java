package cn.edu.lyu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ������û��𰸵�ֵ����, ��ʾ�����ϵ�һ����Ͷ�Ӧ���û��� ��ֵ����
 * 
 * @author Robin
 * 
 */
public class QuestionInfo{

	private Question question;
	/** ���Ծ�(paper)�е���� 0,1,2 */
	private int questionIndex;
	/** �û��� */
	private List<Integer> userAnswers = new ArrayList<Integer>();

	public QuestionInfo() {
	}

	public QuestionInfo(int questionIndex, Question question) {
		this.question = question;
		this.questionIndex = questionIndex;
	}

	public QuestionInfo(int questionIndex, Question question,
			List<Integer> userAnswers) {
		super();
		this.question = question;
		this.userAnswers = userAnswers;
		this.questionIndex = questionIndex;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Integer> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(List<Integer> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public int getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}

	@Override
	public String toString() {
		return question.toString();
	}
}
