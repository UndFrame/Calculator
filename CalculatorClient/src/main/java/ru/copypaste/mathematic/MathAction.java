package ru.copypaste.mathematic;

import ru.copypaste.mathematic.mathactions.EmptyMathAction;

public interface MathAction {

    MathObject getResult(MathObject a,MathObject b);
    MathActionType getType();

    static MathAction empty(){
        return EmptyMathAction.getInstance();
    }
}
