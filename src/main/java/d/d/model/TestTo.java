package d.d.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class TestTo {
	@Valid
	@NotNull
	private StudentPo studentPo;
	private Test1 test1;
}
