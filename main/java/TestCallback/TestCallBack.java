package TestCallback;

public class TestCallBack {
    public static void main(String[] args){
        Student student = new Student();
        Teacher teacher = new Teacher(student);
        System.out.println("================同步================");
        teacher.assigneHomeWork(true);
        System.out.println("================异步================");
        teacher.assigneHomeWork(false);
    }
}
