package kodlama.io.northwind.api.controllers;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.DataResult;
import kodlama.io.northwind.core.utilities.Result;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory_CategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }


    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult< List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllSortedDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }


}
