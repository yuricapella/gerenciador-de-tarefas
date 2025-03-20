package br.com.ada.t1322.tecnicasprogramacao.projeto.service;

import br.com.ada.t1322.tecnicasprogramacao.projeto.config.ConfigConstants;
import br.com.ada.t1322.tecnicasprogramacao.projeto.repository.TaskRepository;
import br.com.ada.t1322.tecnicasprogramacao.projeto.repository.TaskRepositoryImpl_Que_Eu_Fiz;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.notification.TaskNotifier;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.DeadlineValidation;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.StatusValidation;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.TaskValidator;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.TitleValidation;

import java.util.List;

public class TaskServiceFactory {

    public static TaskService createTaskService() {
        TaskRepository repository = TaskRepositoryImpl_Que_Eu_Fiz.getInstance();

        TaskValidator validator = new TaskValidator(List.of(
                new TitleValidation(),
                new DeadlineValidation(),
                new StatusValidation()
        ));

        return TaskServiceImpl_Que_Eu_Fiz.create(repository, validator, new TaskNotifier(repository, ConfigConstants.DEFAULT_THRESHOLD_DAYS, ConfigConstants.NOTIFICATION_COOLDOWN_MINUTES));
    }
}
