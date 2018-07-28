package com.jnucst2015.dropshopping_test.service;

import com.jnucst2015.dropshopping.entity.Classification;

import java.util.List;

public interface ClassificationService {
    List<Classification> getAllClassification();

    Classification getClassificationByID(Integer id);

    Classification updateClassification(Classification classification);

    void deleteByID(Integer id);

    Classification addClassification(Classification classification);
}
