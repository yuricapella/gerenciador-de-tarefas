package br.com.ada.t1322.tecnicasprogramacao.projeto.controller;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.TaskService;

public class TaskControllerImpl extends AbstractTaskController{
    public TaskControllerImpl(TaskService taskService) {
        super(taskService);
    }


    public void validateTitle(String title) {

    }
    public void validateDescription(String description) {

    }
    public void validateDeadline(String deadline) {

    }

    @Override
    protected void validateStatus(Task.Status status) {

    }

    public void validateStatus(String status) {

    }
}
