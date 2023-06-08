package br.com.joao.simoes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.joao.simoes.converters.NumberConverter;
import br.com.joao.simoes.exceptions.UnsupportedMathOperationException;
import br.com.joao.simoes.math.SimpleMath;

@RestController
@RequestMapping(path="/calc")
public class MathController {
	
	private SimpleMath simpleMath = new SimpleMath();
	
	@RequestMapping(path="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, 
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please set a numeric value");
			
		}
		
		return simpleMath.sum(Double.valueOf(numberOne), Double.valueOf(numberTwo));
		
	}
	
	@RequestMapping(path="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne, 
					          @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please set a numeric value");
			
		}
		
		return simpleMath.subtraction(Double.valueOf(numberOne), Double.valueOf(numberTwo));
		
	}
	
	@RequestMapping(path="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, 
					             @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please set a numeric value");
			
		}
		
		return simpleMath.multiplication(Double.valueOf(numberOne), Double.valueOf(numberTwo));
		
	}
	
	@RequestMapping(path="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable(value = "numberOne") String numberOne, 
					       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please set a numeric value");
			
		}
		
		return simpleMath.division(Double.valueOf(numberOne), Double.valueOf(numberTwo));
		
	}
	
	@RequestMapping(path="/average/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double average(@PathVariable(value = "numberOne") String numberOne, 
					      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please set a numeric value");
			
		}
		
		return simpleMath.average(Double.valueOf(numberOne), Double.valueOf(numberTwo));
		
	}
	
	@RequestMapping(path="/sqrt/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please set a numeric value");
			
		}
		
		return simpleMath.squareRoot(Double.valueOf(numberOne));
		
	}
		
}
