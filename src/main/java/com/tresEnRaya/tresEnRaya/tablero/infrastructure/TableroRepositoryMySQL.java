package com.tresEnRaya.tresEnRaya.tablero.infrastructure;

import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.domain.TableroRepository;
import com.tresEnRaya.tresEnRaya.tablero.infrastructure.db.DBConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableroRepositoryMySQL implements TableroRepository{

    @Override
    public void movimiento(Tablero tablero) {

        Connection connection = DBConexion.getInstance();

        try(PreparedStatement pst = connection.prepareStatement("insert into jugadores(id) values(?);")){
            pst.setInt(1, tablero.getIdJugador());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }

        try(PreparedStatement ps = connection.prepareStatement("insert into tablero(jugador, posicionFila, posicionColumna) values(?,?,?);")){
            ps.setInt(1, tablero.getIdJugador());
            ps.setInt(2, tablero.getPosicionFila());
            ps.setInt(3, tablero.getPosicionColumna());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String [][] getTablero(){

        String [][] tabla = new String[3][3];
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla.length; j++) {
                tabla[i][j] = " ";
            }
        }

        String query = "select * from tablero;";
        try(Statement st = DBConexion.getInstance().createStatement()){
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Integer idJugador = rs.getInt(1);
                Integer fila = rs.getInt(2);
                Integer columna = rs.getInt(3);
                Tablero t = new Tablero(idJugador, fila, columna);

                    if (idJugador == 1){
                        tabla[fila-1][columna-1] = "X";
                    }else {
                        tabla[fila-1][columna-1] = "O";
                    }

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return tabla;
    }

    @Override
    public void limpair() {

        try(PreparedStatement ps = DBConexion.getInstance().prepareStatement("delete from tablero;")){
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
