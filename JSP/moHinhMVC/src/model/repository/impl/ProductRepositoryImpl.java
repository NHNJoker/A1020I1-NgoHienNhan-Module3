package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> productMap =new TreeMap<>();

    static {
        productMap.put(11,new Product(12,"Kem danh rang",
                15000,"kem danh rang","ps"));
        productMap.put(23,new Product(23,"Kem danh rang",
                15000,"kem danh rang","ps"));
        productMap.put(43,new Product(43,"Kem danh rang",
                15000,"kem danh rang","ps"));
        productMap.put(56,new Product(56,"Kem danh rang",
                15000,"kem danh rang","ps"));
    }

    @Override
    public List<Product> showAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public boolean addNewProduct(Product product){
        productMap.put(product.getId(),product);
        return true;
    }

    @Override
    public void delete(int key) {
        productMap.remove(key);
    }
}
