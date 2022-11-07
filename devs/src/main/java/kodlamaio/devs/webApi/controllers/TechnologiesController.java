package kodlamaio.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.devs.business.abstracts.TechnologyService;
import kodlamaio.devs.business.requests.CreateTechnologyRequest;
import kodlamaio.devs.business.requests.UpdateTechnologyRequest;
import kodlamaio.devs.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService=technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		
		return technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		
		technologyService.add(createTechnologyRequest);
	}
	
	@PostMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		
		technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void update(int id) {
		
		technologyService.remove(id);
	}
}
