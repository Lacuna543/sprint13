package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Progress;
import com.softserve.sprint13.entity.Progress.TaskStatus;
import com.softserve.sprint13.entity.Task;
import com.softserve.sprint13.entity.User;
import com.softserve.sprint13.repository.ProgressRepository;
import com.softserve.sprint13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService{

    @Autowired
    private ProgressRepository progressRepository;
   /* @Autowired
    private UserRepository userRepository;*/

    @Override
    public Progress getProgressById(Long idProgress) {
        return progressRepository.findById(idProgress).orElse(null);
    }

    @Override
    public Progress addTaskForStudent(Task task, User user) {
        return null;
    }

    @Override
    public Progress addOrUpdateProgress(Progress progress) {
        return null;
    }

    @Override
    public boolean setStatus(TaskStatus taskStatus, Progress progress) {
        return false;
    }

    @Override
    public List<Progress> allProgressByUserIdAndMarathonId(Long idUser, Long idMarathon) {
        return null;
    }

    @Override
    public List<Progress> allProgressByUserIdAndSprintId(Long idUser, Long idSprint) {
        return null;
    }
}
