package arthur.example.arthur180244.service;

import java.util.Collection;
import java.util.HashMap;

import arthur.example.arthur180244.model.Product;
import arthur.example.arthur180244.repository.ProductRpository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * prodService
 */
@Service
public class prodService {

    @Autowired
    private ProductRpository x;

    public Product getProd(Integer id)
    {
        return x.getProductById(id);
    }
    
    public Collection<Product> getProd()
    {
        
        HashMap<Integer, Product> aux = new HashMap<Integer, Product>();
        HashMap<Integer, Product> Stock = new HashMap<Integer, Product>();

        aux = x.getProduct();
        for(Product p:aux.values()){
            if(p.getStock() > 0)
            Stock.put(p.getCode(),p);
        }
        return (Stock.values());
    } 

    public Collection<Product> getProdAcima(double value)
    {
        HashMap<Integer,Product> aux = new HashMap<Integer,Product>();
        HashMap<Integer,Product> Price = new HashMap<Integer,Product>();

        aux = x.getProduct();
        for(Product p:aux.values())
            if(p.getPrice() >= value)
                Price.put(p.getCode(), p);
        return Price.values();
    }

    public Collection<Product> getProdAbaixo(double value)
    {
        HashMap<Integer,Product> aux = new HashMap<Integer,Product>();
        HashMap<Integer,Product> Price = new HashMap<Integer,Product>();

        aux = x.getProduct();
        for(Product p:aux.values())
            if(p.getPrice()<value)
                Price.put(p.getCode(), p);
        return Price.values();
    }
}