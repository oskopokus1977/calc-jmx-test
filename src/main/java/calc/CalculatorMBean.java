package calc;

public interface CalculatorMBean {
    int getFirstNumber();

    void setFirstNumber(int firstNumber);

    int getSecondNumber();

    void setSecondNumber(int secondNumber);

    @Override
    String toString();

    int add();
}
