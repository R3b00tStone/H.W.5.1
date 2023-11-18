import java.util.Scanner;

public class StudentsAdd {
    public Student getInf() {
        Scanner console = new Scanner(System.in);
        Student student = new Student();

        System.out.println("Введите имя студента: ");
        String name = console.nextLine();

        System.out.println("Введите фамилию студента: ");
        String lastName = console.nextLine();

        System.out.println("Введите пол студента (MALE или FEMALE): ");
        String genderIn = console.nextLine().toUpperCase();
        Gender gender = null;

        try {
            gender = Gender.valueOf(genderIn);
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильно задан пол!");
        }
        System.out.println("Введите название группы: ");
        String groupName = console.nextLine();
        student.setGroupName(groupName);

        System.out.println("Введите ID студента: ");
        int id = console.nextInt();
        student.setId(id);

        console.close();

        return new Student(name, lastName, gender, id, groupName);

    }
    public void addStudents(Group group){
        try {
            group.addStudent(getInf());
            System.out.println("Студент добавлен в группу");
        } catch (GroupOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
