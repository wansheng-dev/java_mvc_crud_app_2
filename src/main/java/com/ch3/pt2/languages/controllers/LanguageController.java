package com.ch3.pt2.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ch3.pt2.languages.models.LanguageModel;
import com.ch3.pt2.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("lang") LanguageModel lang) {
		List<LanguageModel> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		System.out.println(model.getAttribute("languages"));
		return "languages/index.jsp";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("lang") LanguageModel lang, BindingResult result, Model model) {
		List<LanguageModel> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		if (result.hasErrors()) {
			return "languages/index.jsp";
		} else {
			languageService.createLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		LanguageModel lang = languageService.findLanguage(id);
		model.addAttribute("language", lang);
		return "languages/view.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		LanguageModel lang = languageService.findLanguage(id);
		model.addAttribute("language", lang);
		return "languages/edit.jsp";
	}
	
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
    	if (result.hasErrors()) {
    		return "languages/edit.jsp";
    	} else {
    		languageService.updateLanguage(language);
    		return "redirect:/languages";
    	}
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
    	return "redirect:/languages";
    }
	
}
