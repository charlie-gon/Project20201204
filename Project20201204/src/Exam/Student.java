package Exam;

//201208
//시험문제 4

public class Student {
	
	private String name;
	private int mathScore;
	private int engScore;
	
	public Student(String name, int mathScore, int engScore) {
		super();
		this.name = name;
		this.mathScore = mathScore;
		this.engScore = engScore;
	}

	public String getName() {
		return name;
	}

	public int getMathScore() {
		return mathScore;
	}

	public int getEngScore() {
		return engScore;
	}
	
	
	
	

}
