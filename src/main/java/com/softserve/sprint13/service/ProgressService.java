package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Progress;
import com.softserve.sprint13.entity.Task;
import com.softserve.sprint13.entity.Progress.TaskStatus;
import com.softserve.sprint13.entity.User;


import java.util.List;

interface ProgressService {

    Progress getProgressById(Long idProgress);

    Progress addTaskForStudent(Task task, User user);

    Progress addOrUpdateProgress(Progress progress);

    boolean setStatus(TaskStatus taskStatus, Progress progress);

    List<Progress> allProgressByUserIdAndMarathonId(Long idUser, Long idMarathon);

    List<Progress> allProgressByUserIdAndSprintId(Long idUser, Long idSprint);

}
