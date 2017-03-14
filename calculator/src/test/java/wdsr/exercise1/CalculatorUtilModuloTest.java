package wdsr.exercise1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test(expected=ArithmeticException.class)
	public void testModuloByZero() {
		//given
		when((calculator).modulo(anyInt(), eq(0))).thenThrow(new ArithmeticException());
		
		//when
		calcUtil.getModuloText(16, 0);
		
		//then
		//empty
	}

	@Test
	public void testModulo16By4() {
		//given
		when((calculator).modulo(16, 4)).thenReturn(0);
		
		//when
		String result = calcUtil.getModuloText(16, 4);
		
		//then
		assertThat(result, is("16 % 4 = 0"));
		verify(calculator).modulo(16, 4);
	}
}
