package br.com.ada.t1322.tecnicasprogramacao.projeto.view.command;

import br.com.ada.t1322.tecnicasprogramacao.projeto.controller.TaskController;
import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.view.View;
import br.com.ada.t1322.tecnicasprogramacao.projeto.view.command.helper.SortingCommandHelper;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FilterTasksByStatusCommand implements Command {

    private final View view;
    private final TaskController taskController;

    public FilterTasksByStatusCommand(View view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        String statusInput = view.getInput("🔎 Digite o status para filtrar (Pendente, Em andamento, Bloqueado, Concluído)");
        Task.Status status;
        try {
            status = Task.Status.fromString(statusInput);
        } catch (IllegalArgumentException e) {
            view.showMessage("❌ Status inválido. Tente novamente.");
            return;
        }

        Optional<Comparator<Task>> orderBy = SortingCommandHelper.getSortingMethod(view);;
        List<Task> tasks = taskController.getTasksByStatus(status, orderBy);

        if (tasks.isEmpty()) {
            view.showMessage("📭 Nenhuma tarefa encontrada com esse status.");
        } else {
            tasks.forEach(task -> view.showMessage(task.toString()));
        }
    }

}
