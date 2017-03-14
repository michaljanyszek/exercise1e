package wdsr.exercise1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilDivisionTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}
	
	@Test
	public void test16dividedBy4() {
		//given
		doReturn(4.0).when(calculator).divide(anyInt(), anyInt());
		when((calculator).divide(16, 4)).thenReturn(4.0);
		
		//when
		String result = calcUtil.getDivisionText(16, 4);
		
		//then
		assertThat(result, equalTo("16 / 4 = 4.0"));
		verify(calculator).divide(16, 4);	
	}		

	@Test(expected=IllegalArgumentException.class)
	public void testDivisionByZero() {
		// given
		doThrow(new IllegalArgumentException()).when(calculator).divide(anyInt(), eq(0));

		// when
		calcUtil.getDivisionText(3, 0);
		
		// then
		// empty - exception expected
	}
}
