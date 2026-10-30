package ru.ranepa;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        Student student1 = university.enroll("Anna");
        Teacher teacher1 = university.hire("Victor", "history");
        Student student2 = university.enroll("Boris");
        university.grade(student1.getId(), 4);
        university.grade(student1.getId(), 3);
        university.grade(student1.getId(), 5);
        university.printAll();
        try {
            university.grade(teacher1.getId(), 4);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        university.findByName("Victor");
        try{
            university.findByName("Ivan");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Average Anna's grade: " + university.average(student1.getId()));


        // TODO: сценарий

        // 1. принять преподавателя
        // 2. поставить Анне оценки
        // 3. напечатать всех одним циклом
        // 4. попробовать оценить преподавателя — отказ
        // 5. найти человека по имени
        // 6. напечатать средний балл
    }
}
