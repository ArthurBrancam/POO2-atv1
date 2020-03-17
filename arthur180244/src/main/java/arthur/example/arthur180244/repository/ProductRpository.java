package arthur.example.arthur180244.repository;

import java.util.HashMap;

import arthur.example.arthur180244.model.Product;

import org.springframework.stereotype.Repository;

/**
 * ProductRpository
 */
@Repository
public class ProductRpository {

    public HashMap<Integer, Product> hm = new HashMap<Integer, Product>();

    public ProductRpository(){
        hm.put(1, new Product(1,"copo",10,100));
        hm.put(2, new Product(2,"taça",50,100));
        hm.put(3, new Product(3,"taça cristal",80,100));
        hm.put(4, new Product(4,"prato",40,90));
        hm.put(5, new Product(5,"prato louça",80,60));
        hm.put(6, new Product(6,"talher",35,100));
        hm.put(7, new Product(7,"talher reflexo",65,80));
        hm.put(8, new Product(8,"xicara plastico",10,95));
        hm.put(9, new Product(9,"xicara vidro",30,50));
        hm.put(10, new Product(10,"xicara louça",50,30));
    }

    public Product getProductById(int id){
        return hm.get(id);
    }
    
    public HashMap <Integer,Product> getProduct(){
        return hm;
    }
}