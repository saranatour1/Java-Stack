// You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according 
// to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according 
// to their first name in alphabetical order. If those two students also have the same first name,
//  then order them according to their ID. No two students have the same ID.

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        // List<Student> descendingOrder = new ArrayList<Student>();

        int n = studentList.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (studentList.get(j).getCgpa() < studentList.get(j + 1).getCgpa()) {
                    // save the new minimum to a temp value
                    Student min = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, min);
                } else if (studentList.get(j).getCgpa() == studentList.get(j + 1).getCgpa()) {
                    // if its more than 0, j is smaller than j+1
                    if (studentList.get(j).getFname().compareTo(studentList.get(j + 1).getFname()) > 0) {
                        Student min = studentList.get(j);
                        studentList.set(j, studentList.get(j + 1));
                        studentList.set(j + 1, min);
                    }

                    // // Student min =studentList.get(j);
                    // String[] ar ={studentList.get(j).getFname() ,studentList.get(j+1).getFname()
                    // };
                    // Student min =studentList.get(j);
                    // Arrays.sort(ar);
                    // studentList.set(j, studentList.get(j+1));
                    // studentList.set(j+1, min);
                } else if (studentList.get(j).getFname() == studentList.get(j + 1).getFname()) {
                    if (studentList.get(j).getId() < studentList.get(j + 1).getId()) {
                        Student min = studentList.get(j);
                        studentList.set(j, studentList.get(j + 1));
                        studentList.set(j + 1, min);
                    }
                }
            }
        }
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}

