package com.tresEnRaya.tresEnRaya.tablero.infrastructure;

import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.domain.TableroRepository;
import com.tresEnRaya.tresEnRaya.context.DBConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableroRepositoryMySQL implements TableroRepository{

    @Override
    public List<Tablero> movimiento(Tablero tablero) {
        Connection connection = DBConexion.getInstance();
        List<Integer> jugadores = this.getJugadores();
        if(jugadores.size() < 2) {
            try (PreparedStatement pst = connection.prepareStatement("insert into jugadores(id) values(?);")) {
                pst.setInt(1, tablero.getIdJugador());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        try(PreparedStatement ps = connection.prepareStatement("insert into tablero(jugador, posicionFila, posicionColumna) values(?,?,?);")){
            ps.setInt(1, tablero.getIdJugador());
            ps.setInt(2, tablero.getFila());
            ps.setInt(3, tablero.getColumna());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.getTablero();
    }

    public List<Integer> getJugadores(){
        List<Integer> jugadores = new ArrayList<>();
        try(Statement st = DBConexion.getInstance().createStatement()){
            ResultSet rs = st.executeQuery("select * from jugadores;");
            while (rs.next()){
                Integer idJugador = rs.getInt("id");
                jugadores.add(idJugador);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return jugadores;
    }

    @Override
    public List<Tablero> getTablero(){

        List<Tablero> tabla = new ArrayList<>();
        try(Statement st = DBConexion.getInstance().createStatement()){
            ResultSet rs = st.executeQuery("select * from tablero;");
            while(rs.next()){
                Integer idJugador = rs.getInt(1);
                Integer fila = rs.getInt(2);
                Integer columna = rs.getInt(3);
                tabla.add(new Tablero(idJugador, fila, columna));
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
