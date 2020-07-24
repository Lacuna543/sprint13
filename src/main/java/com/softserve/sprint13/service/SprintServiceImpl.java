package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Sprint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService{
    @Override
    public List<Sprint> getSprintsByMarathonId(Long idMarathon) {
        return null;
    }

    @Override
    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon) {
        return false;
    }

    @Override
    public boolean updateSprint(Sprint sprint) {
        return false;
    }

    @Override
    public Sprint getSprintById(Long idSprint) {
        return null;
    }
}
