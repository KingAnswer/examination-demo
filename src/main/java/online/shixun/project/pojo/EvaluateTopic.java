package online.shixun.project.pojo;

public class EvaluateTopic {

	private int id;
	private String choose;
	private int evaluate_id;
	private int fraction;
	private Evaluate evaluate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChoose() {
		return choose;
	}
	public void setChoose(String choose) {
		this.choose = choose;
	}
	public int getEvaluate_id() {
		return evaluate_id;
	}
	public void setEvaluate_id(int evaluate_id) {
		this.evaluate_id = evaluate_id;
	}
	public int getFraction() {
		return fraction;
	}
	public void setFraction(int fraction) {
		this.fraction = fraction;
	}
	public Evaluate getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}
	
}
