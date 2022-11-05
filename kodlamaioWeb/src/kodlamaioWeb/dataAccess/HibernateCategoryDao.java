package kodlamaioWeb.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWeb.entities.Category;

public class HibernateCategoryDao implements CategoryDao{

	@Override
	public List<Category> getList() {
		
		ArrayList<Category> dummyCategories = new ArrayList<Category>();
		dummyCategories.add(new Category(1, "Yazılım"));
		dummyCategories.add(new Category(2, "3D Tasarım"));
		
		return dummyCategories;
	}
	
	@Override
	public void add(Category category) {
		System.out.print(category.getName() + " verisi Hibernate ile eklendi.");
		
	}

}
