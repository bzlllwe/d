package d.d.repository;

import d.d.model.StudentPo;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends BaseRepository<StudentPo, Long> {


	@Query(nativeQuery = true,value = "select * from t_user where id = 1")
	StudentPo findIdEq1();

	StudentPo findTop1By();
}
