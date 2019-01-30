package TestCallback;

import java.util.concurrent.TimeUnit;

public class Student {
    public void doHomeWork(CallBack callBack){
        System.out.println("学生开始做作业。。。。");
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("学生做完作业了。");
            callBack.checkHomeWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void asynDoHomeWork(final CallBack callBack){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("学生开始做作业。。。。");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("学生做完作业了。");
                callBack.checkHomeWork();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
