package ru.gb.spring.app.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.gb.spring.app.product.entity.Product;
import ru.gb.spring.app.product.service.ProductService;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    //форма создания сообщений
    @GetMapping("/create")
    public String showSimpleForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "product/create-product";
    }



    // обработчик формы создания и редактирования, /Product/edit/{id}
    @PostMapping("/create")
    public String processForm(Product product){
        Long id =  product.getId();
        if (id == null){
            productService.save(product);
        } else {
            Product byId = productService.findById(id);
            byId.setTitle(product.getTitle());
            byId.setCost(product.getCost());
            productService.edit(byId);
        }
        return "redirect:/product/all"; // ключевое слово перенаправления
    }


    // показать 1 элемент,
    @GetMapping("/{id}") // localhost:8080/Product/{id}?random=true
    public String getProductById(Model model,
                                 @PathVariable Long id,
                                 @RequestParam(name = "random", defaultValue = "false",
                                 required = false) Boolean isRandom){
        Product product;
        if (isRandom){
            product = productService.getRandomProduct();
        } else {
            product = productService.findById(id);
        }
        model.addAttribute("product",product);
        return "product/product";
    }
    // показать все элементов,
    @GetMapping("/all")
    public String getAllProducts(Model model){
        model.addAttribute("products",productService.findActiveAll());
        return "product/product-list";
    }


    // удаление /Product/delete/{id}
    @GetMapping("/delete")
    public String deleteByID(@RequestParam Long id){
        productService.disableById(id);
        return "redirect:/product/all";
    }

    @GetMapping("/edit")
    public String editById(Model model,@RequestParam Long id){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/create-product";
    }
//    @ModelAttribute("info")
//    public String addAttribute(){
//        return "тра-ла-ла";
//    }
}
