import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class University {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        Student std1 = new Student();
        std1.setStudentID(21);
        std1.setFirstName("jack");
        std1.setLastName("doe");
        std1.setDateOfBirth(getDate("04-09-2000"));
        std1.setGrades(45);
        std1.setGrades(80);
        std1.setGrades(90);

        Student std2 = new Student(22,"alex","doe",getDate("03-01-1998"),new ArrayList<>(Arrays.asList(75,90,87)));

        Student std3 = new Student();
        std3.setStudentID(22);
        std3.setFirstName("patric");
        std3.setLastName("doe");
        std3.setDateOfBirth(getDate("08-11-1999"));
        std3.setGrades(60);
        std3.setGrades(70);
        std3.setGrades(100);

        Student std4 = new Student(23,"alex","doe",getDate("11-08-1990"),new ArrayList<>(Arrays.asList(77,68,90)));


        Professor prof1 = new Professor(15,"mr john","doe","math");
        Professor prof2 = new Professor(15,"mr john","doe");
        prof2.setCourseName("computer science");

        System.out.print("Enter student " + std1.getFirstName() + "'s grade: " );
        prof1.assignGrade(std1,scanner.nextInt());
        System.out.print("Enter student " + std2.getFirstName() + "'s grade: " );
        prof1.assignGrade(std2,scanner.nextInt());
        System.out.print("Enter student " + std3.getFirstName() + "'s grade: " );
        prof2.assignGrade(std3,scanner.nextInt());
        System.out.print("Enter student " + std4.getFirstName() + "'s grade: " );
        prof2.assignGrade(std4,scanner.nextInt());

        Student[] students = {std1,std2,std3,std4};
        Professor[] professors = {prof1,prof2};

        System.out.println("\n============================================\n");

        for (Student student : students) {
            if (student.isExcellent())
                System.out.println("student name: " + student.getFirstName() + " " + student.getLastName()  + " - average grade: " + student.calculateGradeAverage() + " - grades: " + student.getGrades());
        }
        int minAverageGrade = students[0].calculateGradeAverage();
        Student heighestStudent = students[0];
        for (Student student : students) {
            if (student.calculateGradeAverage() >= minAverageGrade){
                minAverageGrade = student.calculateGradeAverage();
                heighestStudent = student;
            }
        }

        System.out.println("\n============================================\n");

        System.out.println("the heighest student with an average grade is, name: " + heighestStudent.getFirstName() + " " + heighestStudent.getLastName() + " - grade average: " + minAverageGrade);
        scanner.close();
    }
    private static Date getDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
class Student {
    private int studentID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private ArrayList<Integer> grades;
    public Student() {
        grades = new ArrayList<>();
    }
    public Student(int studentID, String firstName, String lastName, Date dateOfBirth, ArrayList<Integer> grades) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.grades = grades;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public ArrayList<Integer> getGrades() {
        return grades;
    }
    public void setGrades(int grades) {
        this.grades.add(grades);
    }
    public int calculateGradeAverage(){
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    public boolean isExcellent(){
        return calculateGradeAverage() >= 28;
    }
}
class Professor {
    private int ID;
    private String firstName;
    private String lastName;
    private String courseName;
    public Professor(int ID, String firstName, String lastName, String courseName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Professor(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void assignGrade(Student student, int grade) {
        if (grade >= 18)
            student.setGrades(grade);
        else
            System.out.println("you have failed");
    }

}
