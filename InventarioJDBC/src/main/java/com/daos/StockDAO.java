package com.daos;

import com.entities.Product;
import com.entities.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.conexion.ConexionDB.getConexion;

public class StockDAO {

    private ProductDAO productDAO;

    public StockDAO() {
        productDAO = new ProductDAO();
    }

    private String sqlSelectAll = "SELECT * FROM stock";
    private String sqlSelectById = "SELECT * FROM stock WHERE id = ?";
    private String sqlInsertStock = "INSERT INTO stock (quantity, date, product_id) VALUES(?,?,?)";
    private String sqlUpdateStock = "UPDATE stock SET quantity = ?, date = ?, product_id = ? WHERE id = ? ";
    private String sqlDeleteStock = "DELETE FROM stock WHERE id = ?";

    public List<Stock> getSqlSelectAll() throws SQLException {
        List<Stock> stocks = new ArrayList<Stock>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConexion();

        ps = conn.prepareStatement(sqlSelectAll);
        rs = ps.executeQuery();

        while (rs.next()) {
            Stock stock = new Stock();
            stock.setId(rs.getLong("id"));
            stock.setQuantity(rs.getInt("quantity"));
            stock.setDate(rs.getDate("date"));
            stock.setProduct(productDAO.selectById(rs.getLong("product_id")));

            stocks.add(stock);
        }

        return stocks;
    }

    public Stock getSqlSelectById(long id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Stock stock = null;
        Connection conn = getConexion();

        ps = conn.prepareStatement(sqlSelectById);
        ps.setLong(1, id);
        rs = ps.executeQuery();

        if(rs.next()){
            stock = new Stock();

            stock.setId(rs.getLong("id"));
            stock.setQuantity(rs.getInt("quantity"));
            stock.setDate(rs.getDate("date"));
            stock.setProduct(productDAO.selectById(rs.getLong("product_id")));
        }

        return stock;
    }

    public String updateStock(Stock stock) throws SQLException {
        PreparedStatement ps = null;
        Connection conn = getConexion();
        ps = conn.prepareStatement(sqlUpdateStock);

        ps.setInt(1, stock.getQuantity());
        ps.setDate(2, stock.getDate());
        ps.setLong(3, stock.getProduct().getId());
        ps.setLong(4, stock.getId());

        ps.executeUpdate();

        return "Stock updated";
    }

    public String insertStock(Stock stock) throws SQLException {
        PreparedStatement ps = null;
        Connection conn = getConexion();
        ps = conn.prepareStatement(sqlInsertStock);

        ps.setLong(1, stock.getQuantity());
        ps.setDate(2, stock.getDate());
        ps.setLong(3, stock.getProduct().getId());

        ps.executeUpdate();

        return "Stock inserted";
    }

    public String deleteStock(long id) throws SQLException {
        PreparedStatement ps = null;
        Connection conn = getConexion();

        ps = conn.prepareStatement(sqlDeleteStock);
        ps.setLong(1, id);
        ps.executeUpdate();

        return "Stock deleted";
    }
}
