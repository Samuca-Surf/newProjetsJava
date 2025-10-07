import controller.TarefaController;
import dao.TarefaDAO;
import model.Tarefa;
import service.TarefaService;
import view.TarefaView;

public class Principal {
    public static void main(String[] args) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        TarefaService tarefaService = new TarefaService(tarefaDAO);
        TarefaView tarefaView = new TarefaView(tarefaService);
        TarefaController tarefaController = new TarefaController(tarefaView);
        tarefaController.iniciar();
    }
}