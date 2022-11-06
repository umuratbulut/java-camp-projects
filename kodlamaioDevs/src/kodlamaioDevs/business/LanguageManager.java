package kodlamaioDevs.business;

import java.util.List;

import kodlamaioDevs.dataAccess.LanguageDao;
import kodlamaioDevs.entities.Language;

public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}
	
	@Override
	public List<Language> getList() {
		
		return languageDao.getList();
	}

	@Override
	public Language getById(int id) {
		
		return languageDao.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {
		
		if (language.getName().equals(null) || language.getName()=="") {
			throw new Exception("Programlama dili boş geçilemez.");
		}
		
		for (Language languageItem : getList()) {
			if (languageItem.getName().toLowerCase().equals(language.getName().toLowerCase())) {
				throw new Exception(language.getName() + " dili zaten mevcut.");
			}
		}
		
		
		languageDao.add(language);
	}

	@Override
	public void remove(int id) {
		
		languageDao.remove(id);
	}

	@Override
	public void update(Language language){
		
		languageDao.update(language);
	}

}
