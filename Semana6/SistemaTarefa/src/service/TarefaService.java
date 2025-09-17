package service;

import model.Tarefa;
import view.TarefaView;

import java.util.ArrayList;

public class TarefaService {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();

    public String listar() {
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

    public void cadastrar(String titulo) {
        Tarefa tarefa = new Tarefa(titulo);
        tarefas.add(tarefa);

    }

    public void alterar(Long id, String titulo) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId().equals(id)) {
                Tarefa tarefa = new Tarefa(id, titulo);
                tarefas.set(i, tarefa);
            }
        }
    }

    public void excluir(Long id) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId().equals(id)) {
                tarefas.remove(tarefas.get(i));
            }
        }
    }

    public Tarefa buscarPorId(Long id) {
        Tarefa tarefaEncontrada = null;
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId().equals(id)) {
                tarefaEncontrada = tarefas.get(i);
            }
        }
        return tarefaEncontrada;
    }

}
