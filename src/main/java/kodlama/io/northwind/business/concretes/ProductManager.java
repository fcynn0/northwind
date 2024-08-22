package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.DataResult;
import kodlama.io.northwind.core.utilities.Result;
import kodlama.io.northwind.core.utilities.SuccessDataResult;
import kodlama.io.northwind.core.utilities.SuccessResult;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult< List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"data listelendi");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.DESC,"productName");

        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1, pageSize);

        return new SuccessDataResult<List<Product>>( this.productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName),"Data listelendi" );
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi");

    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Listelendi");
    }


}
