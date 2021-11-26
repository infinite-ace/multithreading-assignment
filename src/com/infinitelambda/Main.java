package com.infinitelambda;

import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MainframeProductProvider mainframeProductProvider = new MainframeProductProvider();
        CachedProductProvider cachedProductProvider = new CachedProductProvider(mainframeProductProvider);

        Product p1 = cachedProductProvider.get("product1");

        ExecutorService es = Executors.newFixedThreadPool(10);

        new Thread(() -> cachedProductProvider.get("product1")).start();
        new Thread(() -> cachedProductProvider.get("product2")).start();

        Set<Callable<Product>> tasks = Set.of(
                () -> cachedProductProvider.get("product1"),
                () -> cachedProductProvider.get("product2"),
                () -> cachedProductProvider.get("product3"),
                () -> cachedProductProvider.get("product4"),
                () -> cachedProductProvider.get("product5"),
                () -> cachedProductProvider.get("product6"),
                () -> cachedProductProvider.get("product7"),
                () -> cachedProductProvider.get("product8"),
                () -> cachedProductProvider.get("product9"),
                () -> cachedProductProvider.get("product10"),
                () -> cachedProductProvider.get("product11")
        );

        es.invokeAll(tasks).forEach( x -> {
            try {
                x.get();
                System.out.println("future.get = " + x.get().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });


    }


}
