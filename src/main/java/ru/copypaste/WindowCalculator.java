package ru.copypaste;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.copypaste.mathematic.MathAction;
import ru.copypaste.mathematic.MathActionType;
import ru.copypaste.mathematic.MathObject;
import ru.copypaste.mathematic.mathactions.SummMathAction;
import ru.copypaste.mathematic.mathobjects.IntegerMathObject;

import java.util.ArrayList;
import java.util.List;

public class WindowCalculator extends Application implements Calculator {

    private Stage stage;

    private static volatile WindowCalculator windowCalculator;

    public WindowCalculator() {
        windowCalculator = this;
    }

    synchronized static Calculator get() {
        return windowCalculator;
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/MainWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("JavaFX and Maven");
        stage.setScene(new Scene(root));
        stage.show();
        this.stage = stage;
    }

    private List<MathBlock> mathBlockList = new ArrayList<>();

    public double getResult() {
        List<MathBlock> newMathBlockList = new ArrayList<>(mathBlockList.size());

        for (int i = 0; i < mathBlockList.size() - 1; i++) {
            MathBlock mathBlock = mathBlockList.get(i);
            MathBlock mathBlockRight = mathBlockList.get(i + 1);
            if (mathBlock.getMathAction().getType() == MathActionType.MULTIPLICATION
                    || mathBlock.getMathAction().getType() == MathActionType.DIVISION) {
                MathObject result = mathBlock.getMathAction().getResult(mathBlock.getMathObject(), mathBlockRight.getMathObject());
                mathBlockRight.setMathObject(result);
                newMathBlockList.add(mathBlockRight);
            } else if (mathBlock.getMathAction().getType() == MathActionType.SUMM
                    || mathBlock.getMathAction().getType() == MathActionType.SUBTRACTION) {
                newMathBlockList.add(mathBlock);
            }
        }

        System.out.println(mathBlockList.size() );

        newMathBlockList.add(mathBlockList.get(mathBlockList.size() - 1));
        mathBlockList.clear();
        double result = 0;
        for (int i = 0; i < newMathBlockList.size() - 1; i++) {
            MathBlock mathBlock = newMathBlockList.get(i);
            MathBlock mathBlockRight = newMathBlockList.get(i + 1);
            result += mathBlock.getMathAction().getResult(mathBlock.getMathObject(), mathBlockRight.getMathObject()).get();
        }

        newMathBlockList.clear();
        stage.setTitle(result+"");
        return result;
    }

    @Override
    public void addMathBlock(MathBlock mathBlock) {
        mathBlockList.add(mathBlock);
        System.out.println(12);
    }

}
