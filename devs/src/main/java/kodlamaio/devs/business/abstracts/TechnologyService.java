package kodlamaio.devs.business.abstracts;

import java.util.List;

import kodlamaio.devs.business.requests.CreateTechnologyRequest;
import kodlamaio.devs.business.requests.UpdateTechnologyRequest;
import kodlamaio.devs.business.responses.GetAllTechnologiesResponse;


public interface TechnologyService {

	List<GetAllTechnologiesResponse> getAll();
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void remove(int id);
	void update(UpdateTechnologyRequest updateTechnologyRequest ) throws Exception;
}
