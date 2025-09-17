package controller;

import model.Tarefa;
import service.TarefaService;
import view.TarefaView;

import javax.swing.*;
import java.util.ArrayList;

public class TarefaController {

    public void iniciar() {
        int opcao = 0;
        do {
            TarefaView tarefaView = new TarefaView();
            opcao = tarefaView.telaInicial();
            switch (opcao) {
                case 0 -> this.listar(); //Fazer lista
                case 1 -> this.cadastrar(); // Fazer cadastro
                case 2 -> this.alterar(); // Fazer alteraçcao
                case 3 -> this.excluir(); // Fazer excluir
            }
        } while (opcao >= 0);

    }

    public void listar() {
        TarefaView tv = new TarefaView();
        tv.telaListagem();
    }

    public void cadastrar() {
        TarefaView tarefaView = new TarefaView();
        tarefaView.telaCadastro();
    }

    public void alterar() {
        TarefaView tarefaView = new TarefaView();
        tarefaView.telaAlteracao();


    }

    public void excluir() {
        TarefaView tarefaView = new TarefaView();
        tarefaView.telaExclusao();

    }

}