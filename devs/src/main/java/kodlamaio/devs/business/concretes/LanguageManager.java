package kodlamaio.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.devs.business.abstracts.LanguageService;
import kodlamaio.devs.business.requests.CreateLanguageRequest;
import kodlamaio.devs.business.requests.UpdateLanguageRequest;
import kodlamaio.devs.business.responses.GetAllLanguagesResponse;
import kodlamaio.devs.business.responses.GetAllTechnologiesResponse;
import kodlamaio.devs.dataAccess.abstracts.LanguageRepository;
import kodlamaio.devs.dataAccess.abstracts.TechnologyRepository;
import kodlamaio.devs.entities.concretes.Language;
import kodlamaio.devs.entities.concretes.Technology;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository, TechnologyRepository technologyRepository) {
		this.languageRepository = languageRepository;
		this.technologyRepository=technologyRepository;
	}
	
	@Override
	public List<GetAllLanguagesResponse> getAll() {
		var languages= languageRepository.findAll();
		var technologies= technologyRepository.findAll();
		List<GetAllLanguagesResponse> getAllLanguagesResponses = new ArrayList<GetAllLanguagesResponse>();
		for (Language language : languages) {
			List<GetAllTechnologiesResponse> getAllTechnologiesResponses = new ArrayList<GetAllTechnologiesResponse>();
			for (Technology technology : technologies) {
				
				if(technology.getId()==language.getId()) {
					getAllTechnologiesResponses.add(new GetAllTechnologiesResponse(technology.getName()));
				}
				
			}
			getAllLanguagesResponses.add(new GetAllLanguagesResponse(language.getName(),getAllTechnologiesResponses));
		}
		
		return getAllLanguagesResponses;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception{
		
		if (checkName(createLanguageRequest.getName())) {
			throw new Exception("Programlama dilinin adı boş geçilemez.");
		}
		
		if (nameIsExist(createLanguageRequest.getName())) {
			throw new Exception(createLanguageRequest.getName() + " dili zaten mevcut.");
		}
		
		Language language=new Language();
		language.setName(createLanguageRequest.getName());
		
		languageRepository.save(language);
		
	}

	@Override
	public void remove(int id) {
		languageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception{
		
		if (checkName(updateLanguageRequest.getName())) {
			throw new Exception("Programlama dilinin adı boş geçilemez.");
		}
		
		if (nameIsExist(updateLanguageRequest.getName())) {
			throw new Exception(updateLanguageRequest.getName() + " dili zaten mevcut.");
		}
		
		Language language=new Language();
		language.setId(updateLanguageRequest.getId());
		language.setName(updateLanguageRequest.getName());
		
		languageRepository.save(language);
		
	}
	
	private boolean checkName(String name) {
		return name.isEmpty() || name.isBlank();
	}
	
	private boolean nameIsExist(String name) {
		
		var languageList= languageRepository.findAll();
		for (Language language : languageList) {
			if (language.getName().toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		
		return false;
	}
	

}
