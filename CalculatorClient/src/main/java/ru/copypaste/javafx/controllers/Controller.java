package ru.copypaste.javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import ru.copypaste.Calculator;
import ru.copypaste.CalculatorApp;
import ru.copypaste.MathBlock;
import ru.copypaste.mathematic.MathAction;
import ru.copypaste.mathematic.mathactions.MultiplicationMathAction;
import ru.copypaste.mathematic.mathactions.SummMathAction;
import ru.copypaste.mathematic.mathobjects.IntegerMathObject;

import java.util.Optional;

public class Controller {

    private static Calculator calculator = Calculator.getInstance();

    private int value = 0;

    private String text = "";


    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button enther;
    @FXML
    private Button mult;

    @FXML
    private Label mainLable;

    @FXML
    public void entherMethod() {
        calculator.addMathBlock(
                new MathBlock(
                        new IntegerMathObject(value),
                        MathAction.empty()
                )
        );
        Optional<Double> result = calculator.getResult();
        result.ifPresent(r -> {
            mainLable.setText(""+result.get());
            value = 0;
            text = "";
        });
    }

    @FXML
    public void plusMethod() {
        calculator.addMathBlock(
                new MathBlock(
                        new IntegerMathObject(value),
                        new SummMathAction()
                )
        );
        text = text + value + "+";
        value=0;
        update();
    }

    @FXML
    public void minusMethod() {
        calculator.addMathBlock(
                new MathBlock(
                        new IntegerMathObject(value),
                        new SummMathAction()
                )
        );
        text = text + value + "-";
        value = 0;
        update();
    }

    @FXML
    public void buttonMethod0() {
        value = (value == 0) ? 0 : value * 10;
        update();
    }

    @FXML
    public void buttonMethod1() {
        value = (value == 0) ? 1 : value * 10 + 1;
        update();
    }

    @FXML
    public void buttonMethod2() {
        value = (value == 0) ? 2 : value * 10 + 2;
        update();
    }

    @FXML
    public void buttonMethod3() {
        value = (value == 0) ? 3 : value * 10 + 3;
        update();
    }

    @FXML
    public void buttonMethod4() {
        value = (value == 0) ? 4 : value * 10 + 4;
        update();
    }

    @FXML
    public void buttonMethod5() {
        value = (value == 0) ? 5 : value * 10 + 5;
        update();
    }

    @FXML
    public void buttonMethod6() {
        value = (value == 0) ? 6 : value * 10 + 6;
        update();
    }

    @FXML
    public void buttonMethod7() {
        value = (value == 0) ? 7 : value * 10 + 7;
        update();
    }

    @FXML
    public void buttonMethod8() {
        value = (value == 0) ? 8 : value * 10 + 8;
        update();
    }

    @FXML
    public void buttonMethod9() {
        value = (value == 0) ? 9 : value * 10 + 9;
        update();
    }

    @FXML
    public void multMethod(){
        calculator.addMathBlock(
                new MathBlock(
                        new IntegerMathObject(value),
                        new MultiplicationMathAction()
                )
        );
        text = text + value + "*";
        value = 0;
        update();
    }

    public void update() {
        if(text.length()>10)
            mainLable.setFont(new Font("",10));
        mainLable.setText(text + " || " + value);
    }

}
