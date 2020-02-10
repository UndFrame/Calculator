package ru.copypaste;

import ru.copypaste.mathematic.MathAction;
import ru.copypaste.mathematic.MathObject;

public class MathBlock{

    private MathObject mathObject;
    private final MathAction mathAction;

    public MathBlock(MathObject mathObject, MathAction mathAction) {
        this.mathObject = mathObject;
        this.mathAction = mathAction;
    }

    public MathObject getMathObject() {
        return mathObject;
    }

    public MathAction getMathAction() {
        return mathAction;
    }

    public void setMathObject(MathObject mathObject) {
        this.mathObject = mathObject;
    }
}