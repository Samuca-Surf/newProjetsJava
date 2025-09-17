package view;

import controller.TarefaController;
import model.Tarefa;
import service.TarefaService;

import javax.swing.*;

public class TarefaView {

    public int telaInicial(){
        String[] menu = {"Listar","Cadastrar","Alterar","Excluir"};
        return JOptionPane.showOptionDialog(
                null,
                "Menu de tarefas:",
                "GESTÃO DE TAREFAS",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                menu,
                menu[0]
        );
    }

    public void telaListagem(String lista){
        JOptionPane.showMessageDialog(null, "LISTAGEM DE TAREFAS\n\n" + lista);
    }


    public void telaCadastro(){
        String titulo = JOptionPane.showInputDialog(
                "CADASTRO DE TAREFA\n\nTítulo:"
        );

        TarefaService tarefaService = new TarefaService();
        tarefaService.cadastrar(titulo);
    }

    public Long telaExclusao(){
        return Long.parseLong(JOptionPane.showInputDialog("Digite o id: "));
    }

    public void telaAlteracao(){
        Long id = Long.parseLong(
                JOptionPane.showInputDialog("ALTERAÇÃO DE TAREFA\n\nDigite o id: ")
        );
        String titulo = JOptionPane.showInputDialog("ALTERAÇÃO DE TAREFA\n\nNovo título:");

        TarefaService tarefaService = new TarefaService();
        tarefaService.alterar(id, titulo);

    }



}