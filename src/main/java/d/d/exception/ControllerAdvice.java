package d.d.exception;


import d.d.model.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(Exception.class)
	public Resp simpleEH(Exception e){
		log.error("全局异常信息：" + e.getMessage() , e);
		return new Resp( -1 , "全局异常：" + e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Resp simpleEH(MethodArgumentNotValidException e){
		FieldError error = e.getBindingResult().getFieldError();
		String message = error.getDefaultMessage();
		log.warn("参数验证失败：" + message);
		return new Resp( -1 , message);
	}

}
