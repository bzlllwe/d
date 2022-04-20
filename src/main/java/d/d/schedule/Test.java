package d.d.schedule;


import d.d.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Test {

	private final long syncDelay = 5 * 1000;

	@Autowired
	private StudentRepo studentRepo;


//	@Scheduled(fixedDelay = syncDelay)
	public void task(){
		log.info("查询开始");
		long begin = System.nanoTime();
		studentRepo.getOne((long) 11).getName();
		log.info("查询结束 "+ (System.nanoTime() - begin));
	}

//	@Scheduled(fixedDelay = syncDelay)
	public void task2(){
		log.info("查询开始");
		long begin =System.nanoTime();
		studentRepo.getOne((long) 12).getName();
		log.info("查询结束 "+ (System.nanoTime() - begin));
	}
}
