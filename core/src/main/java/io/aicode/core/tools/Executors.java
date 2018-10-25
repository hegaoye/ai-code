/*
 * Copyright (c) 2016. 郑州仁中和科技有限公司.保留所有权利.
 *                       http://www.aicode.io
 *      郑州仁中和科技有限公司保留所有代码著作权.如有任何疑问请访问官方网站与我们联系.
 *      代码只针对特定客户使用，不得在未经允许或授权的情况下对外传播扩散.恶意传播者，法律后果自行承担.
 *      本代码仅用于AI-Code.
 */

package io.aicode.core.tools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author lixin 12-10-31 上午8:46
 */
public class Executors {
    private static final int NUM = 5;
    private static ExecutorService singleExecutorService = null;
    private static ExecutorService cachePoolExecutorService = null;
    private static ExecutorService fixedPoolExecutorService = java.util.concurrent.Executors.newFixedThreadPool(NUM);

    /**
     * 单任务线程执行，智能替换异常的线程，直到执行完毕
     *
     * @param runnable
     */
    public static void singleThreadExecutor(Runnable runnable) {
        if (singleExecutorService == null) {
            singleExecutorService = java.util.concurrent.Executors.newSingleThreadExecutor();
        }
        singleExecutorService.execute(runnable);
    }

    /**
     * 智能扩展线程池，不够使用自动扩展大小进行执行
     *
     * @param runnable
     */
    public static void cacheThreadExecutor(Runnable runnable) {
        if (cachePoolExecutorService == null) {
            cachePoolExecutorService = java.util.concurrent.Executors.newCachedThreadPool();
        }
        cachePoolExecutorService.execute(runnable);
    }


    /**
     * 固定大小线程池可以控制对内存的消耗上，一个线程基本上是1M所以可以控制资源消耗，但是也控制了吞吐量，不建议使用于必要并发高的操作上
     *
     * @param runnable
     */
    public static void fixedThreadExecutor(Runnable runnable) {
        if (fixedPoolExecutorService == null) {
            fixedPoolExecutorService = java.util.concurrent.Executors.newFixedThreadPool(NUM);
        }
        fixedPoolExecutorService.execute(runnable);
    }


    public static void fixedThreadExecutor(Callable callable) {
        if (fixedPoolExecutorService == null) {
            fixedPoolExecutorService = java.util.concurrent.Executors.newFixedThreadPool(NUM);
        }
        fixedPoolExecutorService.submit(callable);
    }


}
