package com.softserve.sprint13.service;


import com.softserve.sprint13.entity.Marathon;

import java.util.List;

interface UserService {

    List<Marathon> getAll();
    Marathon getMarathonById (Long idMarathon);
    Marathon createOrUpdate (Marathon marathon);
    void deleteMarathonById (Long idMarathon);
}
