package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Task;
import com.softserve.sprint13.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarathonServiceImpl implements MarathonService{
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUserById(Long idUser) {
        return null;
    }

    @Override
    public List<User> getAllByRole(String string) {
        return null;
    }

    @Override
    public boolean addUserToMarathon(User user, Marathon marathon) {
        return false;
    }

    @Override
    public boolean addUserToTask(User user, Task task) {
        return false;
    }
}
