package kodlamaioDevs.business;

import java.util.List;

import kodlamaioDevs.entities.Language;

public interface LanguageService {

	List<Language> getList();
	Language getById(int id);
	void add(Language language) throws Exception;
	void remove(int id);
	void update(Language language);
}
