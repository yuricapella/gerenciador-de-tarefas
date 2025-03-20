package br.com.ada.t1322.tecnicasprogramacao.projeto.repository;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TaskRepositoryImpl_Que_Eu_Fiz implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private static long count = 1;

    public Task save(Task task){
        if(task.getId() == null){
            task.setId(count++);
        }else{
            int indice = IntStream.range(0, tasks.size())
                    .filter(tarefa -> tasks.get(tarefa).equals(task))
                    .findFirst()
                    .orElse(-1);
            tasks.set(indice, task);
        }

        tasks.add(task);
        return task;
    }

    public List<Task> findAll(){
        return tasks;
    }

    public List<Task> findByStatus(String status){
        return tasks.stream().filter(task -> task.getStatus().getDescricao().equals(status)).toList();
    }

    @Override
    public List<Task> findByStatus(Task.Status status) {
        return tasks.stream().filter(task -> task.getStatus().equals(status)).toList();
    }

    @Override
    public List<Task> findBy(Predicate<Task> predicate) {
        return tasks.stream().filter(predicate).toList();
    }

    public Optional<Task> findById(Long id){
        return tasks.stream().filter(task->task.getId().equals(id)).findFirst();
    }

    public boolean deleteById(Long id){
        return tasks.stream().anyMatch(task->task.getId().equals(id));
    }

    public void deleteAll(){
        this.tasks.clear();
    }
}
