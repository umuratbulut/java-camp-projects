package kodlamaio.devs.business.abstracts;

import java.util.List;

import kodlamaio.devs.business.requests.CreateLanguageRequest;
import kodlamaio.devs.business.requests.UpdateLanguageRequest;
import kodlamaio.devs.business.responses.GetAllLanguagesResponse;


public interface LanguageService {
	
	List<GetAllLanguagesResponse> getAll();
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void remove(int id);
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
}
