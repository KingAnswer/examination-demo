package online.shixun.project.pojo;

public class Answer {

	private int id;
	private String content;
	private int subject_id;
	private int istrue;
	private Subject subject;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getIstrue() {
		return istrue;
	}
	public void setIstrue(int istrue) {
		this.istrue = istrue;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
