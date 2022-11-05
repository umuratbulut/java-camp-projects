package kodlamaioWeb.dataAccess;

import kodlamaioWeb.entities.Instructor;

public class HibernateInstructorDao implements InstructorDao{

	@Override
	public void add(Instructor instructor) {
		
		System.out.println(instructor.getName() + " verisi Hibernate ile eklendi.");
	}
}
