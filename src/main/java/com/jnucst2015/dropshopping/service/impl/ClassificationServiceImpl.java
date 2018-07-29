package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.Classification;
import com.jnucst2015.dropshopping.repository.ClassificationRepository;
import com.jnucst2015.dropshopping_digiwlet.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    @Override
    public List<Classification> getAllClassification() {
        return classificationRepository.findAll();
    }

    @Override
    public Classification getClassificationByID(Integer id) {
        return classificationRepository.findById(id).get();
    }

    @Override
    public Classification updateClassification(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Override
    public void deleteByID(Integer id) {
        classificationRepository.deleteById(id);
    }

    @Override
    public Classification addClassification(Classification classification) {
        return classificationRepository.save(classification);
    }
}
