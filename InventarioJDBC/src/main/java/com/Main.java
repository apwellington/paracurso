package com;

import com.daos.CatgoryDAO;
import com.daos.ProductDAO;
import com.daos.StockDAO;
import com.entities.Category;
import com.entities.Product;
import com.entities.Stock;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

//        STOCK

    StockDAO stockDAO = new StockDAO();
    Stock stock = new Stock();

//               *** Update Stock ***
//      stock.setId(2L);
//      stock.setQuantity(34);
//      stock.setDate(new Date(System.currentTimeMillis()));
//      stock.setProduct(new Product(1L));
//      stockDAO.updateStock(stock);

//               *** Insert Stock ***
//        stock.setQuantity(89);
//        stock.setDate(new Date(System.currentTimeMillis()));
//        stock.setProduct(new Product(1L));
//        System.out.println(stockDAO.insertStock(stock));

//               *** Select Stock By ID ***
//      stock = stockDAO.getSqlSelectById(1L);
//      System.out.println(stock);

//               *** Select All Stock ***
//      List<Stock> stocks = stockDAO.getSqlSelectAll();
//      for(Stock s: stocks){
//        System.out.println(s);
//      }


//              *** Delect Stock By ID ***
//        System.out.println(stockDAO.deleteStock(3L));



//        CATEGORY

        CatgoryDAO categoryDAO = new CatgoryDAO();
        Category category = new Category();

        // *** Update Category ***
        // category.setId(2L);
        // category.setName("Electronics");
        // category.setDescription("Electronic gadgets and devices");
        // categoryDAO.updateCategory(category);

        // *** Insert Category ***
//         category.setName("Books");
//         category.setDescription("Various genres of books");
//         System.out.println(categoryDAO.insertCategory(category));

        // *** Select Category By ID ***
        // category = categoryDAO.getCategoryById(1L);
        // System.out.println(category);

//         *** Select All Categories ***
//         List<Category> categories = categoryDAO.getCategories();
//         for(Category c: categories){
//             System.out.println(c);
//         }

        // *** Delete Category By ID ***
        // System.out.println(categoryDAO.deleteCategory(3L));


//        PRODUCT


        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();

        // *** Update Product ***
        // product.setId(2L);
        // product.setName("Laptop");
        // product.setPrice(1200.00);
        // product.setCategory(new Category(1L));
        // productDAO.updateProduct(product);

        // *** Insert Product ***
        // product.setName("Smartphone");
        // product.setPrice(800.00);
        // product.setCategory(new Category(1L));
        // System.out.println(productDAO.insertProduct(product));

        // *** Select Product By ID ***
        // product = productDAO.selectById(1L);
        // System.out.println(product);

        // *** Select All Products ***
//         List<Product> products = productDAO.selectAll();
//         for(Product p: products){
//             System.out.println(p);
//         }

        // *** Delete Product By ID ***
        // System.out.println(productDAO.deleteProduct(3L));
    }
}