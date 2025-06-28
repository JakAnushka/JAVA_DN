//In this file there is solution code of all exercises and it is commented above every code stating which is part of what excercise.
//This file contains code of JUnit, Mockito and SL4J exercises


//JUnit_Basic Testing Exercises
//Excercise 3 : Assertions in Junit
public class SimpleCalculator {

    public int add(int numberA, int numberB){
        return numberA+numberB;
    }
    public Integer safeAdd(Integer a, Integer b) {
        if (a == null || b == null) {
            return null;
        }
        return Integer.sum(a, b);
    }
}


//Mockito Exercises
//Exercise 1: Mocking and Stubbing
public class SimpleCalculator {
    private MathService mathService;

    public SimpleCalculator(MathService mathService) {
        this.mathService = mathService;
    }
    public int addNumbers(int numberA, int numberB){
        return mathService.add(numberA,numberB);
    }
}


//SL4J Logging Exercises
//Logging using SLF4J
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SimpleCalculator {

    private static final Logger logger = LoggerFactory.getLogger(SimpleCalculator.class);
    private MathService mathService;

    public SimpleCalculator(MathService mathService) {
        this.mathService = mathService;
        logger.info("SimpleCalculator initialized with MathService.");
    }

    public int addNumbers(int a, int b) {
        logger.debug("Attempting to add {} and {}", a, b);
        int result = mathService.add(a, b);
        logger.info("Result of addition: {}", result);
        return result;
    }

        public static void main(String[] args) {
            MathService mathService = new MathService() {
                @Override
                public int add(int a, int b) {
                    return a + b;
                }
            };

            SimpleCalculator calculator = new SimpleCalculator(mathService);
            calculator.addNumbers(10, 15);
        }
    }
