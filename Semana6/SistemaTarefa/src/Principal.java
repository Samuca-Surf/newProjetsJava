import controller.TarefaController;
import model.Tarefa;

public class Principal {
    public static void main(String[] args) {
        TarefaController tc = new TarefaController();
        tc.iniciar();
    }
}