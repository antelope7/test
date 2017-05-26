package linxiang.com.ThreadUtil;

import linxiang.com.logger.Logger;

/**
 * Created by liulinxiang on 2017/5/26.
 */
public class ThreadUser {
    private static doSomeThingTask1 mTask = new doSomeThingTask1();

    public static void main(String[] args){
        ThreadManager manager = ThreadManager.getInstance();
        manager.start(test1);
        manager.start(test2);

        manager.start(mTask);
        mTask.startDo();
        try {
            Thread.sleep(10 * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(mTask.isDoing())
            mTask.stopDo();


    }

    static Runnable test1 = new Runnable() {
        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            Logger.d("Thread id is : "+id);
        }
    };

    static Runnable test2 = new Runnable() {
        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            Logger.d("Thread id is : "+id);
        }
    };

    static class doSomeThingTask1 implements Runnable{
        public static final String TAG = "dst->";

        private volatile boolean isDoing = false;
        private final Object lock = new Object();

        public boolean isDoing(){
            synchronized (lock){
                return isDoing;
            }
        }

        public void startDo(){
            synchronized (lock){
                Logger.d("start");
                this.isDoing = true;
            }
        }

        public void stopDo(){
            synchronized (lock){
                Logger.d("stop");
                this.isDoing = false;
            }
        }

        @Override
        public void run(){
            while (isDoing) {
                long id = Thread.currentThread().getId();
                Logger.d(TAG, "id : " + id);
                Logger.d(TAG, "doing");
            }
        }
    }

}
