package d.d.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "score")
public class ScorePo extends BaseEntity{

	@Column(name = "student_id")
	private Long studentId;

	@Column
	private Integer score;


}
