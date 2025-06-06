public class Student {

	private String firstName;
	private String lastName;
	private int studentId;
	private String major;
	private int grade1;
	private int grade2;
	private int grade3;

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// no arg constructor
	public Student() {
		firstName = "Not Entered";
		lastName = "Not Entered";
		studentId = 0;
		major = "Not Selected";
		grade1 = 0;
		grade2 = 0;
		grade3 = 0;
	}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// constructor
	public Student(String firstName, String lastName, int studentId, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.major = major;
	}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// accessors
	public String firstName() {
		return firstName;
	}

	public String lastName() {
		return lastName;
	}

	public int studentId() {
		return studentId;
	}

	public String major() {
		return major;
	}

	public int grade1() {
		return grade1;
	}

	public int grade2() {
		return grade2;
	}

	public int grade3() {
		return grade3;
	}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// mutators
	public void major(String major) {
		this.major = major;
	}

	public void firstName(String firstName) {
		this.firstName = firstName;
	}

	public void lastName(String lastName) {
		this.lastName = lastName;
	}

	public void studentId(int studentId) {
		this.studentId = studentId;
	}

	public void grade1(int gradeIn) {
		this.grade1 = gradeIn;
	}

	public void grade2(int gradeIn) {
		this.grade2 = gradeIn;
	}

	public void grade3(int gradeIn) {
		this.grade3 = gradeIn;
	}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// misc methods
	public double average() {
		return (grade1 + grade2 + grade3) / 3.0;
	}

	public char letterGrade() {
		double avg = average();
		char retValue = 'F';

		if (avg >= 90)
			retValue = 'A';
		else if (avg >= 80)
			retValue = 'B';
		else if (avg >= 70)
			retValue = 'C';
		else if (avg >= 60)
			retValue = 'D';

		return retValue;
	}

	public String lastNameFirst() {
		return String.format("%s,%s", lastName, firstName);
	}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}