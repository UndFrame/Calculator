package ru.copypaste.mathematic;

import ru.copypaste.mathematic.mathactions.SummMathAction;

public class MathActionFactory {

    public MathAction create(MathActionType mathAction){
        if(mathAction == MathActionType.SUMM){
            return new SummMathAction();
        }

        return null;
    }

}
