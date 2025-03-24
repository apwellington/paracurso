package com.daos;

import com.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.conexion.ConexionDB.getConexion;

public class ProductDAO {

    private CatgoryDAO catgoryDAO;

    public ProductDAO() {
        catgoryDAO = new CatgoryDAO();
    }

    private String sqlSelectAll = "SELECT * FROM product";
    private String sqlSelectProductById = "SELECT * FROM product WHERE id = ?";
    private String sqlInsert = "INSERT INTO product(name,price,category_id) values(?,?,?)";
    private String sqlDelete = "DELETE FROM product WHERE id = ?";
    private String sqlUpdate = "UPDATE product SET name = ?,price = ?,category = ? WHERE id = ?";

    public List<Product> selectAll() throws SQLException {
        List<Product> list = new ArrayList<Product>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conn = getConexion();

        ps = conn.prepareStatement(sqlSelectAll);
        rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setCategory(catgoryDAO.getCategoryById(rs.getLong("category_id")));

            list.add(product);
        }

        return list;
    }

    public Product selectById(long id) throws SQLException {
        Product product = null;
        PreparedStatement ps;
        ResultSet rs;
        Connection conn = getConexion();

        ps = conn.prepareStatement(sqlSelectProductById);
        ps.setLong(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setCategory(catgoryDAO.getCategoryById(rs.getLong("category_id")));
        }

        return product;
    }

    public String insertProduct(Product product) throws SQLException {
        PreparedStatement ps;
        Connection conn = getConexion();
        ps = conn.prepareStatement(sqlInsert);

        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setLong(3, product.getCategory().getId());
        ps.executeUpdate();

        return "Product Inserted";
    }

    public String updateProduct(Product product) throws SQLException {
        PreparedStatement ps;
        Connection conn = getConexion();
        ps = conn.prepareStatement(sqlUpdate);

        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setLong(3, product.getCategory().getId());
        ps.setLong(4, product.getId());
        ps.executeUpdate();

        return "Product Updated";
    }

    public String deleteProduct(Long id) throws SQLException {
        PreparedStatement ps;
        Connection conn = getConexion();
        ps = conn.prepareStatement(sqlDelete);

        ps.setLong(1, id);
        ps.executeUpdate();

        return "Product Deleted";
    }
}
