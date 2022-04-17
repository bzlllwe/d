package d.d.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentPo extends BaseEntity  {

//	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "name不可为空")
	private String name;

	/**
	 * 映射关系：单向 双向  一对一 一对多 多对多
	 * 单向一对一
	 * 双向一对一
	 * 双向一对多
	 * 单向一对多
	 * 单向多对一
	 * 双向多对多
	 */

	//级联脱管/游离操作，分离所有相关联的实体。
//	@OneToMany(cascade = {CascadeType.DETACH})
//	@JoinColumn(name = "student_id", referencedColumnName = "id")
//	private List<ScorePo> scores;

	//不会进行映射
	@Transient
	private String hobby;

}
