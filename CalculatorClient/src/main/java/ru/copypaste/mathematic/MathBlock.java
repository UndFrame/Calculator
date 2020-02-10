package ru.copypaste.mathematic;

class MathBlock{

    private MathObject mathObject;
    private MathAction mathAction;

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
}
