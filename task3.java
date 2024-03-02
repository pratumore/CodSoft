import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


class Student{
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name , int rollNumber , String grade){
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName(){
        return name;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public String getGrade(){
        return grade;
    }

    public String toString(){
        return "Name :" + name + " , Roll Number: " + rollNumber + " , Grade: "  +  grade ;
     }

 
}

class StudentManagementSystem{
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(int rollNumber){
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student findStudent(int rollNumber){
        for(Student student : students){
            if(student.getRollNumber() == rollNumber){
                return student;
            }
        }

        return null;
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public void saveToFile(String filename){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        }catch (IOException e){
            e.printStackTrace();
        }
     }

     @SuppressWarnings("unchecked")
    public void loadFromFile(String filename){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List <Student>) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
     }
 }

 class task3{
    public static void main(String[]args){
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");
            System.out.println("Select an option: ");

            int choice  = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                  System.out.println("Enter name: ");
                  String name  = sc.nextLine();
                  System.out.println("Enter roll number: ");
                  int rollNumber = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Enter grade: ");
                  String grade = sc.nextLine();

                  Student student = new Student(name , rollNumber , grade);
                  sms.addStudent(student);
                  break;

                case 2: 
                  System.out.println("Enter roll number to remove: ");
                  int rollToRemove = sc.nextInt();
                  sc.nextLine();
                  sms.removeStudent(rollToRemove);
                  break;

                case 3:
                  System.out.println("Enter roll number to search: ");
                  int rollToSearch = sc.nextInt();
                  sc.nextLine();
                  Student foundStudent = sms.findStudent(rollToSearch);
                  if(foundStudent != null){
                    System.out.println("Student found: "  +  foundStudent);
                  }else{
                    System.out.println("Student not found.");
                  }
                  break;

                case 4:
                  List<Student> allStudents = sms.getAllStudents();
                  if(allStudents.isEmpty()){
                    System.out.println("No students in the system.");
                  }else{
                    for(Student s : allStudents){
                        System.out.println(s);
                    }
                  }
                  break;

                case 5:
                  sms.saveToFile("students.dat");
                  System.out.println("Data saved to file.");
                  break;

                case 6:
                  sms.loadFromFile("students.dat");
                  System.out.println("Data loaded from file");
                  break;
                  
                case 7:
                   System.out.println("Exiting application.");
                   sc.close();
                   System.exit(0);
                   break;

                default:
                   System.out.println("Invalid option. Please try again.");

            }
          }
     }
 }

