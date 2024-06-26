package info.christianbatista.controllers;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import info.christianbatista.exceptions.UnsupportedMathOperationException;
import info.christianbatista.math.SimpleMath;
import info.christianbatista.validation.NumericValidation;



@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
//	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
		if(!NumericValidation.isNumeric(numberOne) || !NumericValidation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumericValidation.convertToDouble(numberOne), NumericValidation.convertToDouble(numberTwo));
				}



	@GetMapping(value = "/multi/{numberOne}/{numberTwo}")
	
	public Double multi(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
		if(!NumericValidation.isNumeric(numberOne) || !NumericValidation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.multi(NumericValidation.convertToDouble(numberOne), NumericValidation.convertToDouble(numberTwo));
	}
	@GetMapping(value = "/div/{numberOne}/{numberTwo}")
	
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
		if(!NumericValidation.isNumeric(numberOne) || !NumericValidation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.div(NumericValidation.convertToDouble(numberOne), NumericValidation.convertToDouble(numberTwo));
	}
	@GetMapping(value = "/raiz/{numberOne}")
	
	public Double raiz(
			@PathVariable(value = "numberOne") String numberOne
			) throws Exception{
		
		if(!NumericValidation.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.raiz(NumericValidation.convertToDouble(numberOne));
	}
	
	
	}
