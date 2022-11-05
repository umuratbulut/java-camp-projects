package kodlamaioWeb.dataAccess;

import kodlamaioWeb.entities.Instructor;

public class jdbcInstructorDao implements InstructorDao{

	@Override
	public void add(Instructor instructor) {
		
		System.out.println(instructor.getName() + " verisi Jdbc ile eklendi.");
	}

}
