package ru.copypaste.mathematic;

public enum MathActionType {
    MULTIPLICATION(3),
    DIVISION(2),
    SUMM(1),
    SUBTRACTION(0),
    ;

    private int priority;

    MathActionType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
