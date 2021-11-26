package com.infinitelambda;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedProductProvider implements ProductProvider {

    private final MainframeProductProvider mainframeProductProvider;

     Map<String, Product> productCache = new ConcurrentHashMap<>();

    public CachedProductProvider(MainframeProductProvider mainframeProductProvider) {
        this.mainframeProductProvider = mainframeProductProvider;
        productCache.put("product1", new Product("product1", "bicycle"));
        productCache.put("product2", new Product("product2", "TV"));
        productCache.put("product3", new Product("product3", "Bottle of water"));
    }




    @Override
    public Product get(String productId) {
        //TODO: Implement method
        return productCache.get(productId);
    }
}
