package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Sprint;
import com.softserve.sprint13.entity.Task;

import java.util.List;

interface SprintService {

    List<Sprint> getSprintsByMarathonId(Long idMarathon);
    boolean addSprintToMarathon(Sprint sprint, Marathon marathon);
    boolean updateSprint(Sprint sprint);
    Sprint getSprintById(Long idSprint);

}
