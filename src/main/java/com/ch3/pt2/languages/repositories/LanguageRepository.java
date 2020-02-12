package com.ch3.pt2.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ch3.pt2.languages.models.LanguageModel;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageModel, Long> {
    List<LanguageModel> findAll();

}
