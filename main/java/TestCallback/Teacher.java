package TestCallback;

public class Teacher implements CallBack {

    public Student student;
    public Teacher(Student student){
        this.student = student;
    }

    public void assigneHomeWork(boolean asyn){
        System.out.println("老师布置了作业。");
        if(asyn){
            student.doHomeWork(this);
        }else {
            student.asynDoHomeWork(this);
        }
        System.out.println("老师回家了。");
    }
    @Override
    public void checkHomeWork() {
        System.out.println("老师接到通知并检查了作业。");
    }
}
