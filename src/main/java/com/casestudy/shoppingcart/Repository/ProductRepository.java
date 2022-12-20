package com.casestudy.shoppingcart.Repository;

import com.casestudy.shoppingcart.Entitites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value="select * from product p where p.name = :n and p.price =:p and p.category =:c and p.subCategory =:sc and p.details =:d and p.url=:url", nativeQuery = true)
    Product getProductByName(@Param("n") String name ,@Param("p") int price ,@Param("c") String cat,@Param("sc") String subcat,@Param("d") String det, @Param("url") String url);

    @Modifying
    @Transactional
    @Query(value="update product pro SET pro.name =:n , pro.price =:p , pro.category =:c , pro.subCategory =:sc, pro.details =:d, pro.url=:url where pro.product_id = :pid",nativeQuery = true)
    int updateProductById(@Param("n") String name ,@Param("p") int price ,@Param("c") String cat,@Param("sc") String subcat,@Param("d") String det, @Param("url") String url, @Param("pid") int productId);

    @Query(value="select * from product p where p.product_id =:id ",nativeQuery = true)
    Product getProductById(@Param("id") Integer productId);

    @Query(value="select * from product p where p.category=:cat",nativeQuery = true)
     List<Product> byCategory(@Param("cat") String category);

    @Query(value="select * from product p where p.name=:n or p.category=:n or p.subCategory=:n",nativeQuery = true)
     List<Product> bySearchString(@Param("n") String name);

    @Query(value="select distinct category from product",nativeQuery = true)
    List<String> getCategories();

    @Query(value="select * from product",nativeQuery = true)
    List<Product> getAllProducts();
}
