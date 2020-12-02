import java.util.concurrent.*;

public class Test {
    ExecutorService threadPool=new ThreadPoolExecutor(2,5,
            1L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
}
