


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class QuestionManager {
	ArrayList<QuizQuestion> questions;
	private int currentQuestion = 0;
	private int score = 0;
	
	public QuestionManager() {
		questions = new ArrayList<QuizQuestion>();
	}

	public boolean moreQuestions(){
		return (currentQuestion <= (questions.size()-1));
	}
	
	public QuizQuestion nextQuestion() {
		if (moreQuestions()){
			int thisQuestion = currentQuestion;
			currentQuestion+=1;
			return questions.get(thisQuestion);
		}
		else {
			return null;
		}
	}
	public void addQuestion(QuizQuestion q) {
		questions.add(q);
	}

	public void increaseScore () {
		score = score+1;
	}

	public void resetScore () {
		score = 0;
	}
	
	public void update() {
		for (int i = 0; i < questions.size(); i++) {
			QuizQuestion q = questions.get(i);
			q.update();
		}
	}

	public void removeQuestion(int i) {
		if (i<=questions.size()) {
			questions.remove(i);
		}
	}
	
	private void purgeQuestions() {
		for (int i = 0; i < questions.size(); i++) {
					questions.remove(i);
		}
	}

	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
}


