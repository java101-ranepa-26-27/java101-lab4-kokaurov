package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Person> people = new ArrayList<>();
    private final List<GradeBook> gradeBooks = new ArrayList<>();
    private long nextId = 1;

    public Student enroll(String name) {
        long id = nextId++;
        GradeBook book = new GradeBook(id);
        Student student = new Student(id, name, book);
        people.add(student);
        gradeBooks.add(book);
        return student;
    }

    public Teacher hire(String name, String subject) {
        long id = nextId++;
        Teacher teacher = new Teacher(id, name, subject);
        people.add(teacher);
        return teacher;
    }

    public Person findById(long id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person doesn't find.");
    }

    public Person findByName(String name){
        for (Person person: people){
            if (person.getName().equals(name)){
                return person;
            }
        }
        throw new IllegalArgumentException("Person with name: "+name+" doesn't find.");
    }

    public List<Person> all() {
        return new ArrayList<>(people);
    }

    public void grade(long id, int grade) {
        for (GradeBook book : gradeBooks){
            if (book.getStudentId() == id){
                book.addGrade(grade);
                return;
            }
        }
        throw new IllegalArgumentException("Pass doesn't find.");
    }

    public double average(long id) {
        for (GradeBook book : gradeBooks) {
            if (book.getStudentId() == id) {
                return book.average();
            }
        }
        throw new IllegalArgumentException("Pass doesn't find.");
    }

    public void printAll() {
        for (Person person: people){
            System.out.println(person.report());
        }
}
}



