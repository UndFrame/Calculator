package ru.copypaste.mathematic;

public interface MathAction {

    MathObject getResult(MathObject a,MathObject b);
    MathActionType getType();

    static MathAction empty(){
        return new MathAction() {
            @Override
            public MathObject getResult(MathObject a, MathObject b) {
                return null;
            }

            @Override
            public MathActionType getType() {
                return null;
            }
        };
    }
}
