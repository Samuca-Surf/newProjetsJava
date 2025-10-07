package dao;

import connection.ConexaoMySQL;
import model.Tarefa;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TarefaDAO {

    public ArrayList<Tarefa> listar() {
        try {
            String sql = "SELECT id, titulo, local, duracao, data FROM tarefa";
            Statement declaracao = ConexaoMySQL.get().createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            ArrayList<Tarefa> lista = new ArrayList<>();
            while (resultado.next()) {
                Tarefa tarefa = new Tarefa(
                        resultado.getLong("id"),
                        resultado.getString("titulo"),
                        resultado.getString("local"),
                        resultado.getDouble("duracao"),
                        resultado.getDate("data").toLocalDate()
                );
                lista.add(tarefa);
            }

            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Boolean cadastrar(Tarefa tarefa) {
        try {
            String sql = "INSERT INTO tarefa (titulo, local, duracao, data) VALUES (?, ?, ?, ?)";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, tarefa.getTitulo());
            preparacao.setString(2, tarefa.getLocal());
            preparacao.setDouble(3, tarefa.getDuracao());
            preparacao.setDate(4, Date.valueOf(tarefa.getData()));
            int linhasAfetadas = preparacao.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean excluir(Long id) {
        try {
            String sql = "DELETE FROM tarefa WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, id);
            int linhasAfetadas = preparacao.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Tarefa buscarPorId(Long id) {
        try {
            String sql = "SELECT id, titulo, local, duracao, data FROM tarefa WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, id);
            ResultSet resultado = preparacao.executeQuery(); // Usar para ver algo do banco

            Tarefa tarefa = null;
            if (resultado.next()) {
                tarefa = new Tarefa(
                        resultado.getLong("id"),
                        resultado.getString("titulo"),
                        resultado.getString("local"),
                        resultado.getDouble("duracao"),
                        resultado.getDate("data").toLocalDate()
                );

            }
            return tarefa;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean alterar(Tarefa tarefa) {
        try {
            String sql = "UPDATE tarefa SET titulo = ?, local = ?, duracao = ?, data = ? WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, tarefa.getTitulo());
            preparacao.setString(2, tarefa.getLocal());
            preparacao.setDouble(3, tarefa.getDuracao());
            preparacao.setDate(4 , Date.valueOf(tarefa.getData()));
            preparacao.setLong(5, tarefa.getId());
            int linhasAfetadas = preparacao.executeUpdate(); // Usar qnd executar algo no banco
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
