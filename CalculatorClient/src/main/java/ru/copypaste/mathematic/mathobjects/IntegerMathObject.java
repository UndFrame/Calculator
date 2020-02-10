package ru.copypaste.mathematic.mathobjects;

import ru.copypaste.mathematic.MathObject;

public class IntegerMathObject implements MathObject {

    private int value;

    public IntegerMathObject(int value) {
        this.value = value;
    }

    @Override
    public double get() {
        return value;
    }
}
