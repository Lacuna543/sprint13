package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Sprint;
import com.softserve.sprint13.entity.Task;

import java.util.List;

interface TaskService {

    Task addTaskToSprint(Task task, Sprint sprint);
    Task getTaskById(Long idTask);

}
