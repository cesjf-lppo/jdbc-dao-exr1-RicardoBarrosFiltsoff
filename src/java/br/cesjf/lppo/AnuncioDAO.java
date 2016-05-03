package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnuncioDAO {

    List<Anuncio> listaTodos() {
        List<Anuncio> todos = new ArrayList<>();
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2016-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM usuario.anuncio");
            while (resultado.next()) {
                Anuncio novo = new Anuncio();
                novo.setId(resultado.getLong("id"));
                novo.setNome(resultado.getString("nome"));
                novo.setDescricao(resultado.getString("descricao"));
                novo.setPreco(resultado.getFloat("preco"));
                todos.add(novo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todos;
    }

    void criar(Anuncio novo) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2016-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(String.format(Locale.US,"INSERT INTO USUARIO.ANUNCIO(nome, descricao, preco) VALUES('%s','%s', %f)", novo.getNome(), novo.getDescricao(),novo.getPreco()));

        } catch (SQLException ex) {
            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
