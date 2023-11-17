package com.tresEnRaya.tresEnRaya.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {


    private static Connection conexion;

    private DBConexion(){}

    public static Connection getInstance(){
        if (conexion == null){
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:40000/prueba", "root", "YOUR_ROOT_PASSWORD_HERE");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return conexion;
    }

}
