package stream;

public class Student implements Comparable<Student> {

	private String name;
	private int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	
	//CollectorExample와 연결
	
	@Override
	public int compareTo(Student o) {
		//오름차순: 음수, 내림차순: 양수
		//	return this.score - o.score; //오름차순
	return o.score - this.score; //내림차순
	}

	
	

}
