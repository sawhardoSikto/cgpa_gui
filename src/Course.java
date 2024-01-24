import java.text.DecimalFormat;

public class Course
{
    String courseName;
    String marks;
    String credit;
    static final DecimalFormat decfor = new DecimalFormat("0.00");


    public Course(){
        marks = "";
        credit = "";
        courseName = "";
    }

    public Course(String courseName, String marks, String credit) {
        this.courseName = courseName;
        this.marks = marks;
        this.credit = credit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getCredit() {
        return credit;
    }

    public static double convertToDouble(String str) {
        double result = 0.0;

        try {
            result = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println("Error: Unable to convert the string to a double.");
            // You may choose to handle the exception in a way that fits your application.
            // For now, we are just printing an error message.
        }

        return result;
    }
    public double mrksTocgpa(){ //double marks
       if(Double.parseDouble(marks) <= 100.0 && Double.parseDouble(marks) >= 90.0){
           return 4.0;
       }else if(Double.parseDouble(marks) <90.0 && Double.parseDouble(marks) >= 85.0){
           return 3.75;
       }else if(Double.parseDouble(marks) < 85.0 && Double.parseDouble(marks) >= 80.0){
           return 3.5;
       }else if(Double.parseDouble(marks) < 80.0 && Double.parseDouble(marks) >= 75.0){
           return 3.25;
       }else if(Double.parseDouble(marks) < 75.0 && Double.parseDouble(marks) >= 70.0){
           return 3.0;
       }else if(Double.parseDouble(marks) <= 70.0 && Double.parseDouble(marks) >= 0.0){
           return 3;
       }else{
           return 0;
       }
    }
}


