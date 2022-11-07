package kodlamaio.devs.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllLanguagesResponse {
	
	private String name;
	private List<GetAllTechnologiesResponse> technologies;
}
