package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.User;
import com.softserve.sprint13.exception.EntityNotFoundException;
import com.softserve.sprint13.repository.MarathonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonServiceImpl implements MarathonService {
    @Autowired
    private MarathonRepository marathonRepository;

    @Override
    public List<Marathon> getAll() {
        List<Marathon> users = marathonRepository.findAll();
        return users;
    }

    @Override
    public Marathon getMarathonById(Long id) {

        Optional<Marathon> marathon = marathonRepository.findById(id);

        if (marathon.isPresent()) {
            return marathon.get();
        } else throw new EntityNotFoundException("No marathon exist for given id");

    }

    @Override
    public Marathon createOrUpdate(Marathon marathon) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Marathon>> violations = validator.validate(marathon);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }

        if (marathon != null) {
            Optional<Marathon> marathons = marathonRepository.findById(marathon.getId());
            if (marathons.isPresent()) {
                Marathon newMarathon = marathons.get();
                newMarathon.setTitle(marathon.getTitle());
                newMarathon = marathonRepository.save(newMarathon);
                return newMarathon;
            }
        }
        marathon = marathonRepository.save(marathon);
        return marathon;

    }

    @Override
    public void deleteMarathonById(Long id) {

    }
}
