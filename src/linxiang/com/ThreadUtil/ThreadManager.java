package linxiang.com.ThreadUtil;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 */
public class ThreadManager {
    static final int MAX_RUNNING_THREAD = 10;

    private static ThreadManager _instance;

    private ExecutorService executor;

    private ThreadManager(){
        try {
            executor = Executors.newFixedThreadPool(MAX_RUNNING_THREAD,	new NormalThreadFactory());
        } catch (Throwable t) {
            executor = Executors.newCachedThreadPool();
        }
    }

    public synchronized static ThreadManager getInstance(){
        if(_instance == null){
            _instance = new ThreadManager();
        }
        return _instance;
    }

    public void start(Runnable runnable){
        executor.submit(runnable);
    }

    public <T> Future<T> start(Callable<T> callable){
        return executor.submit(callable);
    }

    /**
     * 正常优先级的线程工厂
     */
    private static class NormalThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        NormalThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-temporary-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            return t;
        }
    };
}
