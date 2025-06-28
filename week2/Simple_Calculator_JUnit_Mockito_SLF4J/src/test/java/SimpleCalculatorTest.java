//In this file there is solution code of all exercises and it is commented above every code stating which is part of what excercise.
//This file contains code of JUnit, Mockito and SL4J exercises

//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.mockito.Mockito.*;


//JUnit_Basic Testing Exercises
//Exercise 3 : Assertions in Junit
import static org.junit.Assert.*;
import org.junit.Test;

public class SimpleCalculatorTest {
    @Test
    public void twoPlusTwoShouldEqualFour() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void threePlusSevenShouldEqualTen() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertTrue(calculator.add(3, 7) == 10);
    }

    @Test
    public void threePlusfourShouldNotEqualTen() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertFalse(calculator.add(3, 4) == 10);
    }

    @Test
    public void resultShouldBeNullIfAnyInputIsNull() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertNull(calculator.safeAdd(null, 5));
        assertNull(calculator.safeAdd(3, null));
    }

    @Test
    public void resultShouldNotBeNullIfBothInputsAreNotNull() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertNotNull(calculator.safeAdd(3, 4));
    }

    @Test
    public void fourDividedByTwoShouldEqualTwo() {
        //Arrange
        SimpleCalculator calculator = new SimpleCalculator();
        //Act
        int res = calculator.divison(4, 2);
        //Assert
        assertEquals(2, res);

    }
}

//Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in Junit

import static org.junit.Assert.*;
        import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class SimpleCalculatorTest {
    private SimpleCalculator calculator;

    @Before
    public void setUp() {
        calculator = new SimpleCalculator(); // Arrange
        System.out.println("Setup: Calculator initialized.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator object cleaned up.");
    }

    @Test
    public void testAdditionOfTwoPositiveNumbers() {
        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testAdditionOfPositiveAndNegativeNumber() {
        // Act
        int result = calculator.add(10, -4);

        // Assert
        assertEquals(6, result);
    }

    @Test
    public void testAdditionWithZero() {
        // Act
        int result = calculator.add(0, 5);

        // Assert
        assertEquals(5, result);
    }
}


//Mockito Exercises
//Exercise 1: Mocking and Stubbing
import static org.junit.Assert.*;
        import org.junit.Test;
import static org.mockito.Mockito.*;

public class SimpleCalculatorTest
{

    @Test
    public void testAddNumbersUsingMockService() {
        // Step 1: Create mock
        MathService mockService = mock(MathService.class);

        // Step 2: Stub the method
        when(mockService.add(2, 3)).thenReturn(5);

        // Step 3: Inject mock into calculator
        SimpleCalculator calculator = new SimpleCalculator(mockService);
        // Step 4: Call and assert
        int result = calculator.addNumbers(2, 3);
        assertEquals(5, result);
    }
}


//Exercise 2: Verifying Interactions
import static org.junit.Assert.*;
        import org.junit.Test;
import static org.mockito.Mockito.*;

public class SimpleCalculatorTest
{	@Test
public void testAddNumbersUsingMockService() {
    // Step 1: Create mock
    MathService mockService = mock(MathService.class);

    // Step 2: Stub the method
    when(mockService.add(2, 3)).thenReturn(5);

    // Step 3: Inject mock into calculator
    SimpleCalculator calculator = new SimpleCalculator(mockService);

    // Step 4: Call method with specific arguments
    calculator.addNumbers(4, 6);
    //  Step 5: Verify interaction with exact arguments
    verify(mockService).add(4, 6);
}}
