package br.com.ada.t1322.tecnicasprogramacao.projeto.service;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.repository.TaskRepository;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.notification.Notifier;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.TaskValidator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TaskServiceImpl_Que_Eu_Fiz extends AbstractTaskService{
    public TaskServiceImpl_Que_Eu_Fiz(TaskRepository taskRepository, TaskValidator taskValidator, Notifier notifier) {
        super(taskRepository, taskValidator, notifier);
    }

    /*
    orElseGet() só aceita funções sem parâmetros, por causa do Supplier<T>.
    Se o método não tem parâmetros, podemos passar Classe::metodo.
    Se o método tem parâmetros, usamos () -> Classe.metodo(parametro) para transformá-lo em uma função sem parâmetros.
     */
    @Override
    public List<Task> findAll(Optional<Comparator<Task>> orderBy) {
        return orderBy.map(
        taskComparator -> taskRepository.findAll().stream().sorted(taskComparator).toList())
        .orElseGet(taskRepository::findAll);
    }

    @Override
    public List<Task> findByStatus(Task.Status status, Optional<Comparator<Task>> orderBy) {
        return orderBy.map(
        taskComparator -> taskRepository.findByStatus(status).stream().sorted(taskComparator).toList())
        .orElseGet(() -> taskRepository.findByStatus(status));
    }

    @Override
    public List<Task> findBy(Predicate<Task> predicate, Optional<Comparator<Task>> orderBy) {
        return orderBy.map(
        taskComparator -> taskRepository.findBy(predicate).stream().sorted(taskComparator).toList())
        .orElseGet(() -> taskRepository.findBy(predicate));
    }
}
