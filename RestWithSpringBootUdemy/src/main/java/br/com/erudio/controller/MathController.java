package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.util.NumericUtil;

/**
 * 
 * @author Edilson
 *
 */
@RestController
public class MathController {

	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		validarNumeros(numberOne, numberTwo);
		
		return NumericUtil.convertToDouble(numberOne) + NumericUtil.convertToDouble(numberTwo);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		validarNumeros(numberOne, numberTwo);
		
		return NumericUtil.convertToDouble(numberOne) - NumericUtil.convertToDouble(numberTwo);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		validarNumeros(numberOne, numberTwo);
		
		return NumericUtil.convertToDouble(numberOne) * NumericUtil.convertToDouble(numberTwo);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divide(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		validarNumeros(numberOne, numberTwo);
		
		validarDenominadorZero(numberTwo);
		
		return NumericUtil.convertToDouble(numberOne) / NumericUtil.convertToDouble(numberTwo);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		validarNumeros(numberOne, numberTwo);
		
		validarDenominadorZero(numberTwo);
		
		return (NumericUtil.convertToDouble(numberOne) / NumericUtil.convertToDouble(numberTwo)) / 2;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
	public Double square(@PathVariable("numberOne") String numberOne) throws Exception {
		
		if (!NumericUtil.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Somente números deverão ser informados.");
		}
		
		return Math.sqrt(NumericUtil.convertToDouble(numberOne));
	}
	
	private void validarNumeros(String numberOne, String numberTwo) {
		if (!NumericUtil.isNumeric(numberOne) || !NumericUtil.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Somente números deverão ser informados.");
		}
	}
	
	private void validarDenominadorZero(String number) {
		if (NumericUtil.convertToDouble(number).compareTo(0D) == 0) {
			throw new UnsupportedMathOperationException("Informe um número diferente de zero para o denominador.");
		}
	}
}
