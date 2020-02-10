package ru.copypaste.mathematic.mathactions;

import ru.copypaste.mathematic.MathAction;
import ru.copypaste.mathematic.MathActionType;
import ru.copypaste.mathematic.MathObject;
import ru.copypaste.mathematic.mathobjects.IntegerMathObject;

public class MultiplicationMathAction implements MathAction {
    @Override
    public MathObject getResult(MathObject a, MathObject b) {
        return new IntegerMathObject((int)(a.get()*b.get()));
    }

    @Override
    public MathActionType getType() {
        return MathActionType.MULTIPLICATION;
    }
}
