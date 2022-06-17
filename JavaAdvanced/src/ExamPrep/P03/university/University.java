package ExamPrep.P03.university;

import java.util.ArrayList;
import java.util.List;


public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }


    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (students.size() == capacity) {
            return "No seats in the ExamPrep.P03.university";
        } else {
            boolean isHaveThisStudent = false;
            for (Student currentStudent : students) {
                if (currentStudent.getFirstName().equals(student.getFirstName()) &&
                        currentStudent.getLastName().equals(student.getLastName())) {
                    isHaveThisStudent = true;
                    return "Student is already in the ExamPrep.P03.university";
                }
            }
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public String dismissStudent(Student student) {
        for (Student studentIter : students) {
            if (studentIter.getFirstName().equals(student.getFirstName()) &&
                    studentIter.getLastName().equals(student.getLastName())) {
                students.remove(studentIter);
                return String.format("Removed student %s %s", studentIter.getFirstName(), studentIter.getLastName());
            }
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        Student findStudent = null;
        for (Student studentFind : students) {
            if (studentFind.getFirstName().equals(firstName) &&
                    studentFind.getLastName().equals(lastName)) {
                findStudent = studentFind;
            }
        }
        return findStudent;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s"
                            , student.getFirstName(), student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
