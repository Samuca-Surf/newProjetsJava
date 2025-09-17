package controller;

import model.Tarefa;
import service.TarefaService;
import view.TarefaView;

import javax.swing.*;
import java.util.ArrayList;

public class TarefaController {

    private TarefaView tarefaView;

    public TarefaController(TarefaView tarefaView){
        this.tarefaView = tarefaView;
    }

    public void iniciar() {
        int opcao = 0;
        do {
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
        tarefaView.telaListagem();
    }

    public void cadastrar() {
        tarefaView.telaCadastro();
    }

    public void alterar() {
        tarefaView.telaAlteracao();
    }

    public void excluir() {
        tarefaView.telaExclusao();
    }

}