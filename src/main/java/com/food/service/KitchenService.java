package com.food.service;

import com.food.model.Kitchen;
import com.food.repository.KitchenRepository;
import com.food.service.exception.DatabaseException;
import com.food.service.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KitchenService {

    private final KitchenRepository kitchenRepository;

    public KitchenService(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    @Transactional(readOnly = true)
    public List<Kitchen> getAllKitchens() {
        return kitchenRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Kitchen getKitchenById(Long id) {
        return kitchenRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kitchen not found"));
    }

    @Transactional
    public Kitchen save(Kitchen kitchen) {
        kitchen.setId(null);
        return kitchenRepository.save(kitchen);
    }

    @Transactional
    public Kitchen update(Long id, Kitchen kitchen) {
        try {
            Kitchen kitchenToUpdate = kitchenRepository.getReferenceById(id);
            BeanUtils.copyProperties(kitchen, kitchenToUpdate, "id");
            return kitchenRepository.save(kitchenToUpdate);
        } catch (FatalBeanException e) {
            throw new NotFoundException("Id not found: " + id);
        }

    }

    public void delete(Long id) {
        try {
            kitchenRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
