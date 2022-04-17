package d.d.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@CreatedDate
	@Column(name = "create_date", updatable = false)
	protected LocalDateTime createDate;

	@LastModifiedDate
	@Column(name = "update_date")
	protected LocalDateTime updateDate;
}
