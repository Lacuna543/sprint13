package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Sprint;
import com.softserve.sprint13.entity.Task;
import com.softserve.sprint13.repository.SprintRepository;
import com.softserve.sprint13.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private SprintRepository sprintRepository;

    @Override
    public Task addTaskToSprint(Task task, Sprint sprint) {
        return null;
    }

    @Override
    public Task getTaskById(Long idTask) {
        return taskRepository.findById(idTask).orElse(null);
    }
}
