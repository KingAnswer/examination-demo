package online.shixun.project.pojo;

import java.util.List;

public class javapractise {
	private int id;
	private String name;
	private List<javaOptions> javaOption;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<javaOptions> getJavaOption() {
		return javaOption;
	}
	public void setJavaOption(List<javaOptions> javaOption) {
		this.javaOption = javaOption;
	}
	@Override
	public String toString() {
		return "javapractise [id=" + id + ", name=" + name + ", javaOption=" + javaOption + "]";
	}
}
