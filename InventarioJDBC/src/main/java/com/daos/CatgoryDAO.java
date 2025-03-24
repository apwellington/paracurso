package com.daos;

import com.entities.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.conexion.ConexionDB.getConexion;

public class CatgoryDAO {

    private String insertSQL = "INSERT INTO category (name, description) VALUES (?, ?)";
    private String selctSQL = "SELECT * FROM category ORDER BY id";
    private String selectSQLByID = "SELECT * FROM category WHERE id = ?";
    private String updateSQL = "UPDATE category SET name = ?, description = ? WHERE id = ?";
    private String deleteSQL = "DELETE FROM category WHERE id = ?";


    public List<Category> getCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conn = getConexion();

        try {

            ps = conn.prepareStatement(selctSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                        category.setId(rs.getLong("id"));
                        category.setName(rs.getString("name"));
                        category.setDescription(rs.getString("description"));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category getCategoryById(Long id) throws SQLException {
        Category category = null;
        PreparedStatement ps;
        ResultSet rs;
        Connection conn = getConexion();
        try{
        ps = conn.prepareStatement(selectSQLByID);
        ps.setLong(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }

    public String insertCategory(Category category) throws SQLException {
        PreparedStatement ps;
        Connection conn = getConexion();
        try {
            ps = conn.prepareStatement(insertSQL);
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Category Inserted";
    }

    public String updateCategory(Category category) throws SQLException {
        PreparedStatement ps;
        Connection conn = getConexion();

        try {
            ps = conn.prepareStatement(updateSQL);
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setLong(3, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Category Updated";
    }

    public String deleteCategory(long id) throws SQLException {
        PreparedStatement ps;
        Connection conn = getConexion();

        try {
            ps = conn.prepareStatement(deleteSQL);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Category Deleted";
    }

}
