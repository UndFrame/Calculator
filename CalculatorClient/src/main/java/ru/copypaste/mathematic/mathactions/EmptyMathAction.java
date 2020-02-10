package ru.copypaste.mathematic.mathactions;

import ru.copypaste.mathematic.MathAction;
import ru.copypaste.mathematic.MathActionType;
import ru.copypaste.mathematic.MathObject;

public class EmptyMathAction implements MathAction {

    private static EmptyMathAction emptyMathAction;

    public static EmptyMathAction getInstance(){
        if(emptyMathAction == null) emptyMathAction = new EmptyMathAction();
        return emptyMathAction;
    }

    @Override
    public MathObject getResult(MathObject a, MathObject b) {
        return null;
    }

    @Override
    public MathActionType getType() {
        return null;
    }
}
