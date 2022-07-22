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
public class StudentPo extends BaseEntity {

	/**
	 *     JdkSerializationRedisSerializer: 使用JDK提供的序列化功能。
	 *     优点是反序列化时不需要提供类型信息(class)，但缺点是需要实现Serializable接口，
	 *     还有序列化后的结果非常庞大，是JSON格式的5倍左右，这样就会消耗redis服务器的大量内存。
	 *
	 *     Jackson2JsonRedisSerializer： 使用Jackson库将对象序列化为JSON字符串。
	 *     优点是速度快，序列化后的字符串短小精悍，不需要实现Serializable接口。
	 *     但缺点也非常致命，那就是此类的构造函数中有一个类型参数，必须提供要序列化对象的类型信息(.class对象)。
	 *     通过查看源代码，发现其只在反序列化过程中用到了类型信息。
	 */
	// 不实现序列化的话，redisCacheManager序列化报错
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
