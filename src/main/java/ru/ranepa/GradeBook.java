package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class GradeBook implements GradeView {
    private final long studentId;
    private final List<Integer> grades = new ArrayList<>();

    GradeBook(long studentId) {
        this.studentId = studentId;
    }

    long getStudentId() {
        return studentId;
    }

    void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Grade must be from 2 to 5.");
        }
        grades.add(grade);
    }

    public double average() {
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public String describe() {
        return "grade: " + grades + "; average grade: " + average();
    }
}
