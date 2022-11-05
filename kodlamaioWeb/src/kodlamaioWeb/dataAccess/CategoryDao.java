package kodlamaioWeb.dataAccess;

import java.util.List;

import kodlamaioWeb.entities.Category;

public interface CategoryDao {

	List<Category> getList();
	void add(Category category);
}
