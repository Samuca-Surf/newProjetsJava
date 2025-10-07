package service;

import dao.TarefaDAO;
import model.Tarefa;
import view.TarefaView;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TarefaService {

    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    private TarefaDAO tarefaDAO;

    public TarefaService(TarefaDAO tarefaDAO) {
        this.tarefaDAO = tarefaDAO;
    }

    public String listar() {
        ArrayList<Tarefa> tarefas = tarefaDAO.listar();
        String listaTarefas = "";
        if (tarefas.size() > 0) {
            for (Tarefa tarefa : tarefas) {
                listaTarefas += tarefa + "\n";
            }
        } else {
            listaTarefas = "Nenhuma tarefa encontrada";
        }
        return listaTarefas;
    }

    public void cadastrar(String titulo, String local, Double duracao, LocalDate data) {
        Tarefa tarefa = new Tarefa(titulo, local, duracao, data);
        tarefaDAO.cadastrar(tarefa);
    }

    public Boolean alterar(Long id, String titulo, String local, Double duracao, LocalDate data) {
        Tarefa tarefa = new Tarefa(id, titulo, local, duracao, data);
        return tarefaDAO.alterar(tarefa);
    }

    public Boolean excluir(Long id) {
        return tarefaDAO.excluir(id);
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaDAO.buscarPorId(id);
    }

}
