package com.ch3.pt2.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ch3.pt2.languages.models.LanguageModel;
import com.ch3.pt2.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<LanguageModel> allLanguages(){
		return languageRepo.findAll();
	}
	
	public LanguageModel createLanguage(LanguageModel lang) {
		return languageRepo.save(lang);
	}
	
	public LanguageModel findLanguage(Long id) {
		Optional<LanguageModel> optionalLanguage = languageRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public LanguageModel updateLanguage(LanguageModel lang) {
		return languageRepo.save(lang);
	}
	
	public void deleteLanguage(Long id) {
		languageRepo.deleteById(id);
	}
	
}
