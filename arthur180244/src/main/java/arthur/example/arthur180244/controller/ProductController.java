package arthur.example.arthur180244.controller;

import java.util.Collection;

import arthur.example.arthur180244.model.Product;
import arthur.example.arthur180244.service.prodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProductController
 */
@Controller
public class ProductController {

    @Autowired
    private prodService x;    

    @RequestMapping("/produto/{id}")

    //devolve o produto e se não existir devolve uma mensagem de erro que deve ser apresentado em uma view.
    public ModelAndView getProdID(
        @PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("prodById");
        Product prod = x.getProd(id);
        mv.addObject("prod", prod);
        return mv;
    }

    @RequestMapping("/produtosEmEstoque")

    //Devolve somente os produtos em estoque.
    public ModelAndView getAllProd(){
        ModelAndView mv = new ModelAndView("allProd");
        Collection<Product> prods = x.getProd();
        mv.addObject("prods", prods);
        return mv;
    }

    @RequestMapping("/produtosValorAcima/{value}")

    //Devolve todos os produtos acima do valor passado.
    public ModelAndView getProdAbove(
        @PathVariable("value") int value){
        ModelAndView mv = new ModelAndView("prodAbove");
        Collection<Product> prods = x.getProdAcima(value);
        mv.addObject("prods", prods);
        return mv;
    }

    @RequestMapping("/produtosValorAbaixo/{value}")

    //Devolve todos os produtos abaixo de um valor passado.
    public ModelAndView getProdBelow(
        @PathVariable("value") int value){
        ModelAndView mv = new ModelAndView("allBelow");
        Collection<Product> prods = x.getProdAbaixo(value);
        mv.addObject("prods", prods);
        return mv;
    }
}