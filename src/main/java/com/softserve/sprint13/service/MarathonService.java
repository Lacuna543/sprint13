package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Task;
import com.softserve.sprint13.entity.User;

import java.util.List;

interface MarathonService {

    List<User> getAll();
    User getUserById(Long idUser);
    List<User> getAllByRole(String string);
    boolean addUserToMarathon(User user, Marathon marathon);
    boolean addUserToTask(User user, Task task);
}
