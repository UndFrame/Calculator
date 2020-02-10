package ru.copypaste.javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ru.copypaste.Calculator;
import ru.copypaste.CalculatorApp;
import ru.copypaste.MathBlock;
import ru.copypaste.mathematic.MathAction;
import ru.copypaste.mathematic.mathactions.SummMathAction;
import ru.copypaste.mathematic.mathobjects.IntegerMathObject;

public class Controller {

    private static Calculator calculator = Calculator.getInstance();

    @FXML
    private Button button;

    @FXML
    private Label mainLable;


    @FXML
    public void onClickMethod() {


        calculator.addMathBlock(new MathBlock(
                new IntegerMathObject(12),
                new SummMathAction()
        ));
        calculator.addMathBlock(new MathBlock(
                new IntegerMathObject(12),
                MathAction.empty()
        ));
        mainLable.setText(calculator.getResult()+"");
    }

}
