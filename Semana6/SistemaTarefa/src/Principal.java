import controller.TarefaController;
import model.Tarefa;
import service.TarefaService;
import view.TarefaView;

public class Principal {
    public static void main(String[] args) {
        TarefaService tarefaService = new TarefaService();
        TarefaView tarefaView = new TarefaView(tarefaService);
        TarefaController tarefaController = new TarefaController(tarefaView);
        tarefaController.iniciar();
    }
}