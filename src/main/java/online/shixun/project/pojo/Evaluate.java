package online.shixun.project.pojo;

import java.util.List;

public class Evaluate {

	private int id;
	private String subject;
	private List<EvaluateTopic> evaluateTopic;
	
	public List<EvaluateTopic> getEvaluateTopic() {
		return evaluateTopic;
	}
	public void setEvaluateTopic(List<EvaluateTopic> evaluateTopic) {
		this.evaluateTopic = evaluateTopic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
