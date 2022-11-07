package kodlamaio.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.devs.business.abstracts.LanguageService;
import kodlamaio.devs.business.requests.CreateLanguageRequest;
import kodlamaio.devs.business.requests.UpdateLanguageRequest;
import kodlamaio.devs.business.responses.GetAllLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	private void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		languageService.add(createLanguageRequest);
	}
	
	@PostMapping("/update")
	private void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	private void update(int id) {
		languageService.remove(id);
	}
}
