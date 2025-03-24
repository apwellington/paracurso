package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/inventario";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    private static Connection conexion = null;

    public static Connection getConexion() throws SQLException {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: No se encontró el driver JDBC.");
            throw new SQLException("Error al establecer la conexión con la base de datos.", e);
        } catch (SQLException e) {
            System.out.println("ERROR: No se pudo conectar a la base de datos.");
            throw e;
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("⚠ERROR al cerrar la conexión: " + e.getMessage());
        }
    }

}
