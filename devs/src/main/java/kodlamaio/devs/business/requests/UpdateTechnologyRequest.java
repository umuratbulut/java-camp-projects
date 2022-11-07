package kodlamaio.devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateTechnologyRequest {
	private int id;
	private int language_id;
	private String name;
}
