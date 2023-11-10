package com.tresEnRaya.tresEnRaya.tablero.infrastructure;

import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.domain.TableroRepository;
import com.tresEnRaya.tresEnRaya.tablero.infrastructure.db.DBConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableroRepositoryMySQL implements TableroRepository{

    @Override
    public List<Tablero> movimiento(Tablero tablero) {

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
        return this.getTablero();
    }

    @Override
    public List<Tablero> getTablero(){
        List<Tablero> tablero = new ArrayList<>();
        String query = "select * from tablero;";
        try(Statement st = DBConexion.getInstance().createStatement()){
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Integer idJugador = rs.getInt(1);
                Integer fila = rs.getInt(2);
                Integer columna = rs.getInt(3);
                tablero.add(new Tablero(idJugador, fila, columna));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return tablero;
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
