package d.d.controller;

import d.d.model.*;
import d.d.repository.StudentRepo;
import d.d.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/** Rest
	 * GET:查询；
	 * POST：新增；
	 * PUT：修改；
	 * DELETE：删除；
	 *
	 **/
	@Transactional
	@PostMapping
	public StudentPo save(@RequestBody @Valid StudentPo studentPo){
		return studentService.save(studentPo);
	}

	@GetMapping
	public StudentPo findById(Long id){
		return studentService.findById(id);
	}

	@GetMapping(value = "/eq1")
	public StudentPo findIdEq1(){
		return studentService.findIdEq1();
	}

	@PostMapping("/post")
	public  void  post(@RequestBody @Valid TestTo testTo){
		//RequestBody只能接受一次，多个参数只能放进map中
		System.out.println("testTo = " + testTo);
	}

	@PostMapping("/e")
	public Resp e(){
		studentService.test1();
		return new Resp("ok");
	}


}
