package d.d.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Resp<T> {

	private int status = 1;
	private String message;
	private T data;

	public Resp(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Resp(String message) {
		this.message = message;
	}
}
