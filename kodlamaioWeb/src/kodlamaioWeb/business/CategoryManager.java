package kodlamaioWeb.business;

import java.util.List;

import kodlamaioWeb.core.Logger;
import kodlamaioWeb.dataAccess.CategoryDao;
import kodlamaioWeb.entities.Category;

public class CategoryManager {

	private CategoryDao categoryDao;
	private List<Logger> loggers;
	
	public CategoryManager(CategoryDao categoryDao, List<Logger> loggers) {
		
		this.categoryDao = categoryDao;
		this.loggers = loggers;
	}
	
	public void add(Category category) throws Exception {
		
		List<Category> categories = categoryDao.getList();
		for (Category categoryItem : categories) {
			if (categoryItem.getName().toLowerCase().equals(category.getName().toLowerCase())) {
				throw new Exception(category.getName() + " kategorisi zaten mevcut.");
			}
		}
		
		categoryDao.add(category);
		
		for (Logger logger : loggers) {
			logger.log();
		}
		
	}
}
