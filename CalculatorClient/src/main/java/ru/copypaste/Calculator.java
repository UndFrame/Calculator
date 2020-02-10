package ru.copypaste;

public interface Calculator {
    static Calculator getInstance() {
        return WindowCalculator.get();
    }

    // (10 + 10) + (10-2)

    double getResult();

    void addMathBlock(MathBlock mathBlock);
}
