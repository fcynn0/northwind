package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.core.utilities.DataResult;
import kodlama.io.northwind.core.utilities.Result;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult< List<Product>> getAll();
    DataResult<List<Product>> getAllSorted();
    DataResult< List<Product>> getAll(int pageNo, int pageSize);
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer>categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName,int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();


}
