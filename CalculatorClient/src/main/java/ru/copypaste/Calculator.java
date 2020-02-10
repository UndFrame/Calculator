package ru.copypaste;

import java.util.Optional;

public interface Calculator {
    static Calculator getInstance() {
        return WindowCalculator.get();
    }

    // (10 + 10) + (10-2)

    Optional<Double> getResult();

    void addMathBlock(MathBlock mathBlock);
}
