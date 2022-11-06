package kodlamaioDevs;

import kodlamaioDevs.business.LanguageManager;
import kodlamaioDevs.business.LanguageService;
import kodlamaioDevs.dataAccess.InMemoryLanguageDao;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		LanguageService languageService = new LanguageManager(new InMemoryLanguageDao());
		
		// languageService.remove(2);
		
		/*
		 * Language newLanguage = new Language(5,"C#");
		 * languageService.add(newLanguage);
		 */
		
		
		var result= languageService.getList();
		
		for (var language : result) {
			System.out.println(language.getId() + " " + language.getName());
		}
		
		System.out.println("-----------------");
		
		var resultItem = languageService.getById(3);
		System.out.println(resultItem.getId() + " " + resultItem.getName());
		
		
		
	}

}
