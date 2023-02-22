package com.food.service;

import com.food.model.State;
import com.food.repository.StateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Transactional
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
}
