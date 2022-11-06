package kodlamaioDevs.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioDevs.entities.Language;

public class InMemoryLanguageDao implements LanguageDao{

	private ArrayList<Language> languages;
	
	public InMemoryLanguageDao() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,"Python"));
	}
	
	
	
	@Override
	public List<Language> getList() {
		
		return languages;
	}

	@Override
	public Language getById(int id) {
		
		Language language = null;
		for (Language languageItem : languages) {
			if (languageItem.getId() == id) {
				language = languageItem;
				break;
			}
		}
		return language;
	}

	@Override
	public void add(Language language) {
		
		languages.add(language);
	}

	@Override
	public void remove(int id) {
		
		int index=0;
		for (Language language : languages) {
			if (language.getId() == id) {
				index = languages.indexOf(language);
				break;
			}
		}
		
		languages.remove(index);
	}

	@Override
	public void update(Language language) {
		
		for (Language languageItem : languages) {
			if (languageItem.getId() == language.getId()) {
				languages.remove(languageItem);
			}
		}
		
		languages.add(language);
	}

}
