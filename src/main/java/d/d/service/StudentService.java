package d.d.service;

import d.d.model.StudentPo;
import d.d.repository.StudentRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.RollbackException;
import java.util.Optional;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Cacheable(value = "studentPo" ,key = "targetClass + methodName +#p0")
	public StudentPo findById(Long id){
		Optional<StudentPo> result = studentRepo.findById(id);
		return result.get();
	}

	public StudentPo save(StudentPo studentPo){
		StudentPo s = studentRepo.save(studentPo);
		return s;
	}

	public StudentPo findIdEq1(){
		return studentRepo.findIdEq1();
	}

//	@SneakyThrows
	@Transactional()
//	@Transactional
	public void test1(){
		StudentPo studentPo = new StudentPo();
		studentPo.setName("1");
		studentRepo.save(studentPo);

		//@Transactional 遇到RuntimeException会回滚
		//@Transactional 遇到SneakyThrows + Exception 不会回滚
		//@Transactional(rollbackFor = Exception.class) 遇到SneakyThrows + Exception 会回滚！
//		if(true) {
//			throw new RuntimeException("test");
//		}

//		StudentPo student = new StudentPo();
//		student.setName("test2");
//		studentRepo.save(student);

		if(true) {
			throw new RuntimeException("test");
		}

	}

	@Transactional
	public void test2(){

		//同一个事务，更改没提交是读取的到的
		System.out.println(studentRepo.getOne((long) 11));

		StudentPo studentPo = new StudentPo();
		studentPo.setName("tt");
		studentPo.setId((long) 11);
		studentRepo.save(studentPo);
		System.out.println(studentRepo.getOne((long) 11));

		studentPo.setName("ttt");
		studentRepo.save(studentPo);
		System.out.println(studentRepo.findTop1By());
	}
}
