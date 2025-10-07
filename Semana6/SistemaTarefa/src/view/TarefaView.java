package view;

import controller.TarefaController;
import model.Tarefa;
import service.TarefaService;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TarefaView {

    private TarefaService tarefaService;

    public TarefaView(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    public int telaInicial() {
        String[] menu = {"Listar", "Cadastrar", "Alterar", "Excluir"};
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

    public void telaListagem() {
        String listaTarefas = tarefaService.listar();

        JOptionPane.showMessageDialog(
                null,
                "LISTAGEM DE TAREFAS\n\n" + listaTarefas
        );

    }


    public void telaCadastro() {
        String titulo = JOptionPane.showInputDialog(
                "CADASTRO DE TAREFA\n\nTítulo:"
        );

        String local = JOptionPane.showInputDialog(
                "CADASTRO DE TAREFA\n\nLocal:"
         );

        Double duracao = Double.parseDouble(JOptionPane.showInputDialog(
                "CADASTRO DE TAREFA\n\nDuração da tarefa:"
        ));

        String databr = JOptionPane.showInputDialog(
                "CADASTRO DE TAREFA\n-Exemplo: dd/MM/yyyy\n\nData da tarefa:"
        );

        DateTimeFormatter formatobr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(databr, formatobr);

        tarefaService.cadastrar(titulo, local, duracao, data);
        JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso");
    }

    public void telaExclusao() {
        String listaTarefas = tarefaService.listar();

        Long id = Long.parseLong(
                JOptionPane.showInputDialog(
                        "EXCLUSÃO DE TAREFA\n\n"
                                + listaTarefas
                                + "\nDigite o id: "
                )
        );

        Tarefa tarefaEncontrada = tarefaService.buscarPorId(id);

        if (tarefaEncontrada != null){
            tarefaService.excluir(id);
            JOptionPane.showMessageDialog(null, "Tarefa excluida com sucesso");
        }else {
            JOptionPane.showMessageDialog(null, "Tarefa não existente");
        }

    }

    public void telaAlteracao() {
        String listaTarefas = tarefaService.listar();

        Long id = Long.parseLong(
                JOptionPane.showInputDialog(
                        "ALTERAÇÃO DE TAREFA\n\n"
                                + listaTarefas
                                + "\nDigite o id: "
                )
        );

        Tarefa tarefaEncontrada = tarefaService.buscarPorId(id);

        if (tarefaEncontrada != null) {
            String titulo = JOptionPane.showInputDialog(
                    "ALTERAÇÃO DE TAREFA\n\nNovo título:",
                    tarefaEncontrada.getTitulo()
            );
            String local = JOptionPane.showInputDialog(
                    "ALTERAÇÃO DE TAREFA\n\nNovo local:",
                    tarefaEncontrada.getLocal()
            );

            Double duracao = Double.parseDouble(JOptionPane.showInputDialog(
                    "ALTERAÇÃO DE TAREFA\n\nNova duração:",
                    tarefaEncontrada.getDuracao()
            ));

            String databr = JOptionPane.showInputDialog(
                    "CADASTRO DE TAREFA\n-Exemplo: dd/MM/yyyy\n\nData da tarefa:",
                    tarefaEncontrada.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );

            DateTimeFormatter formatobr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(databr, formatobr);

            tarefaService.alterar(id, titulo, local, duracao, data);
            JOptionPane.showMessageDialog(null, "Tarefa alterada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa não existente");
        }

    }


}