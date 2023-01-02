import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        ArrayList<Student> students = new ArrayList<>();
        int countMathS = 0, countScienceS = 0;
        do {
            Scanner usersInput = new Scanner(System.in);
            System.out.println(UserQuestions.askToJoin);
            String join = usersInput.nextLine();

            if (join.equalsIgnoreCase("y")) {
                System.out.println(UserQuestions.askFirstName);
                String firstName = usersInput.nextLine();

                System.out.println(UserQuestions.askLastName);
                String lastName = usersInput.nextLine();

                System.out.println(UserQuestions.askAge);
                int age = usersInput.nextInt();
                usersInput.nextLine();

                try {
                    Permission.checkAge(age);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

                System.out.println(UserQuestions.askGender);
                String gender = usersInput.nextLine();

                System.out.println(UserQuestions.askClassName);
                String className = usersInput.nextLine();
                try {
                    Permission.checkClassName(className);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                if (className.equalsIgnoreCase("Math")) {
                    countMathS++;
                    System.out.println("Congratulations! You are registered for " + className + " class.\n");
                    students.add(new MathStudent(firstName, lastName, age, gender, className));
                } else if (className.equalsIgnoreCase("Science")) {
                    countScienceS++;
                    System.out.println("Congratulations! You are registered for " + className + " class.\n");
                    students.add(new ScienceStudent(firstName, lastName, age, gender, className));
                }
            }
        }
        while (students.size() < 3) ;

        for (Student student : students) {
            System.out.println(student);
        }
        if(students.size() == 3) {
            System.out.println("Math students = " + countMathS);
            System.out.println("Science students = " + countScienceS);
        }
    }
}
