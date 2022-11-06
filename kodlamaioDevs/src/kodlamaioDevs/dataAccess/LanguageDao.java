package kodlamaioDevs.dataAccess;

import java.util.List;

import kodlamaioDevs.entities.Language;

public interface LanguageDao {

	List<Language> getList();
	Language getById(int id);
	void add(Language language) ;
	void remove(int id);
	void update(Language language) ;
}
