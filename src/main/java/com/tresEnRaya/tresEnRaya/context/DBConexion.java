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
                conexion = DriverManager.getConnection("jdbc:mysql://servidorbd.cqclyzqv4awf.us-east-1.rds.amazonaws.com/tres_en_raya", "admin", "piramide");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return conexion;
    }

}
