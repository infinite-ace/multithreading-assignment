package com.infinitelambda;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedProductProvider implements ProductProvider {

    private final MainframeProductProvider mainframeProductProvider;

    Map<String, Product> productCache = new ConcurrentHashMap<>();
//    Queue<Product> productCache = new BlockingDeque<Product>();

    public CachedProductProvider(MainframeProductProvider mainframeProductProvider) {
        this.mainframeProductProvider = mainframeProductProvider;
        productCache.put("product1", new Product("product1", "Bicycle"));
        productCache.put("product2", new Product("product2", "TV"));
        productCache.put("product3", new Product("product3", "Bottle of water"));
        productCache.put("product4", new Product("product4", "T-Shirt"));
        productCache.put("product5", new Product("product5", "Jeans"));
        productCache.put("product6", new Product("product6", "Notebook"));
        productCache.put("product7", new Product("product7", "Lighter"));
        productCache.put("product8", new Product("product8", "Keyboard"));
        productCache.put("product9", new Product("product9", "Glass"));
        productCache.put("product10", new Product("product10", "Cable"));
        productCache.put("product11", new Product("product11", "Pen"));
    }




    @Override
    public Product get(String productId) {
        return productCache.get(productId);
    }
}
