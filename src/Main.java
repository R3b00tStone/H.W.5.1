import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Anna", "Malas", Gender.FEMALE, 1, "Math");
        Student student2 = new Student("John", "Doe", Gender.MALE, 2, "History");
        Student student3 = new Student("Emily", "Smith", Gender.FEMALE, 3, "Science");
        Student student4 = new Student("Michael", "Johnson", Gender.MALE, 4, "English");
        Student student5 = new Student("Olivia", "Williams", Gender.FEMALE, 5, "Physics");
        Student student6 = new Student("William", "Brown", Gender.MALE, 6, "Chemistry");
        Student student7 = new Student("Sophia", "Davis", Gender.FEMALE, 7, "Biology");
        Student student8 = new Student("James", "Jones", Gender.MALE, 8, "Computer Science");
        Student student9 = new Student("Ava", "Taylor", Gender.FEMALE, 9, "Geology");
        Student student10 = new Student("Alexander", "White", Gender.MALE, 10, "Engineering");
        Student student11 = new Student("Vasiliy", "Star", Gender.MALE, 11, "Engineering");

        Group groupName = new Group ("BX-1");

        System.out.println(groupName);

        try {
            groupName.addStudent(student1);
            groupName.addStudent(student2);
            groupName.addStudent(student3);
            groupName.addStudent(student4);
            groupName.addStudent(student5);
            groupName.addStudent(student6);
            groupName.addStudent(student7);
            groupName.addStudent(student8);
            groupName.addStudent(student9);

            System.out.println(groupName);

        } catch (GroupOverflowException e) {
            System.out.println("Group Overflow");
            e.printStackTrace();
        }

//        StudentsAdd stud19 = new StudentsAdd();
//        stud19.addStudents(groupName);
//
//        groupName.sortStudentsByLastName();
//
//        System.out.println(groupName);
        GroupFileStorage groupFileStorage = new GroupFileStorage();

        String fileName = groupName.getGroupName() + ".csv";
        groupFileStorage.saveGroupToCSV(groupName, fileName);
        File workFolder = new File ("C:\\Users\\Artur\\IdeaProjects\\H.W.5.1");
        File foundFile = groupFileStorage.findFileByGroupName(fileName, workFolder);

        if (foundFile != null) {
            System.out.println("Найдено файл: " + foundFile.getPath());
            try {
                Group loadedGroup = groupFileStorage.loadGroupFromCSV(foundFile);
                System.out.println("Информация про студентов в группе:");
                System.out.println(loadedGroup.toString());
            } catch (IOException e) {
                System.out.println("Ошибка чтения: " + e.getMessage());
            }
        } else {
            System.out.println("Файл группы " + groupName.getGroupName() + " не найдено в папке");
        }
    }
}