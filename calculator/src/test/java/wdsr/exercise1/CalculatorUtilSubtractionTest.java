package wdsr.exercise1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when; 
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilSubtractionTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test
	public void test3minus1() {
		//given
		when(calculator.subtract(3, 1)).thenReturn(2);
		
		//when
		String result = calcUtil.getSubstractionText(3, 1);
		
		//then
		assertThat(result, is("3 - 1 = 2"));
		verify(calculator).subtract(3,1);
	}

	@Test
	public void testSubtractProperlyEmbeddedNegativeValuesWithBrackets() {
		// given
		when(calculator.subtract(-3, -1)).thenReturn(-2);

		// when
		String actual = calcUtil.getSubstractionText(-3, -1);

		// then
		assertEquals("-3 - -1 = -2", actual);
	}
}
