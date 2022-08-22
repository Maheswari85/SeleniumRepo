package week3.Day1Assignment;

public class Students {
public void getStudentInfo(int id) {
	System.out.println("The student id is " + id);
	}
public void getStudentInfo(int id, String name) {
	System.out.println("The Student name and Id of the topper  is  "+ name+ "  " + "," + id);
}
public void getStudentInfo (String email, int PhNum) {
	System.out.println("The student email id and phone Number is "+ email+ " " + "," + PhNum);
}
public static void main(String[] args) {
	Students stInfo = new Students ();
	stInfo.getStudentInfo(144388);
	stInfo.getStudentInfo(143714, "Vijaylatha");
	stInfo.getStudentInfo("Skumaran.VJ@test.com", 26279015);
	
	
} 
}
