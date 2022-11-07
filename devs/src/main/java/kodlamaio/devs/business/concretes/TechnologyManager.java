package kodlamaio.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.devs.business.abstracts.TechnologyService;
import kodlamaio.devs.business.requests.CreateTechnologyRequest;
import kodlamaio.devs.business.requests.UpdateTechnologyRequest;
import kodlamaio.devs.business.responses.GetAllTechnologiesResponse;
import kodlamaio.devs.dataAccess.abstracts.LanguageRepository;
import kodlamaio.devs.dataAccess.abstracts.TechnologyRepository;
import kodlamaio.devs.entities.concretes.Language;
import kodlamaio.devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;
	
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		this.technologyRepository = technologyRepository;
		this.languageRepository=languageRepository;
	}
	
	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		
		var technologies= technologyRepository.findAll();
		List<GetAllTechnologiesResponse> getAllTechnologiesResponses = new ArrayList<>();
		for (Technology technology : technologies) {
			getAllTechnologiesResponses.add(new GetAllTechnologiesResponse(technology.getName()));
		}
		
		return getAllTechnologiesResponses;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		
		if (checkName(createTechnologyRequest.getName())) {
			throw new Exception("Teknoloji adı boş geçilemez.");
		}
		
		if (nameIsExist(createTechnologyRequest.getName())) {
			throw new Exception(createTechnologyRequest.getName() + " teknolojisi zaten mevcut.");
		}
		
		Language language= languageRepository.findById(createTechnologyRequest.getLanguage_id()).get();
		Technology technology= new Technology();
		technology.setName(createTechnologyRequest.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
	}

	@Override
	public void remove(int id) {
		
		technologyRepository.deleteById(id);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception{
		
		if (checkName(updateTechnologyRequest.getName())) {
			throw new Exception("Teknoloji adı boş geçilemez.");
		}
		
		if (nameIsExist(updateTechnologyRequest.getName())) {
			throw new Exception(updateTechnologyRequest.getName() + " teknolojisi zaten mevcut.");
		}
		
		Language language= languageRepository.findById(updateTechnologyRequest.getLanguage_id()).get();
		Technology technology= new Technology();
		technology.setId(updateTechnologyRequest.getId());
		technology.setName(updateTechnologyRequest.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
	}
	
	private boolean checkName(String name) {
		return name.isEmpty() || name.isBlank();
	}
	
	private boolean nameIsExist(String name) {
		
		var technologyList= technologyRepository.findAll();
		for (Technology technology : technologyList) {
			if (technology.getName().toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		
		return false;
	}

}
