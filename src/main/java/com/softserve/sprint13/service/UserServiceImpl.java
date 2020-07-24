package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public List<Marathon> getAll() {
        return null;
    }

    @Override
    public Marathon getMarathonById(Long idMarathon) {
        return null;
    }

    @Override
    public Marathon createOrUpdate(Marathon marathon) {
        return null;
    }

    @Override
    public void deleteMarathonById(Long idMarathon) {

    }
}
