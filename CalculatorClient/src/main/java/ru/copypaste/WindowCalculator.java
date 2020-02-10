package ru.copypaste;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.copypaste.mathematic.MathAction;
import ru.copypaste.mathematic.MathObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    private List<MathBlock> mathBlockList = new LinkedList<>();


    @Override
    public Optional<Double> getResult() {
        if (mathBlockList.size() > 1) {
            MathBlock finalMathBlock = null;

            List<MathBlock> newMathBlockList = new LinkedList<>();

            int size = mathBlockList.size() - 1;

            for (int m = 0; m < size; m++) {
                System.out.println(mathBlockList.size());
                for (int i = 0; i < mathBlockList.size() - 1; i++) {
                    System.out.println(i + ":" + mathBlockList.size());
                    MathBlock mathBlock = mathBlockList.get(i);
                    MathBlock mathBlockRight = mathBlockList.get(i + 1);
                    if (mathBlockRight.getMathAction().getType() == null || mathBlock.getMathAction().getType().getPriority() >= mathBlockRight.getMathAction().getType().getPriority()) {
                        MathObject result = mathBlock.getMathAction().getResult(mathBlock.getMathObject(), mathBlockRight.getMathObject());
                        mathBlockRight.setMathObject(result);
                        finalMathBlock = mathBlockRight;
                        if (mathBlockRight.getMathAction().getType() == null)
                            newMathBlockList.add(mathBlockRight);

                    } else {
                        newMathBlockList.add(mathBlock);
                    }
                }
                mathBlockList.clear();
                mathBlockList = newMathBlockList;
                newMathBlockList = new LinkedList<>();
                System.out.println(mathBlockList.size());
                if (mathBlockList.size() <= 1)
                    break;
            }


            mathBlockList.clear();
            if (finalMathBlock != null) {
                return Optional.of(finalMathBlock.getMathObject().get());
            }
        }
        return Optional.empty();
    }

    @Override
    public void addMathBlock(MathBlock mathBlock) {
        if ((mathBlock.getMathAction() == MathAction.empty() && mathBlockList.size() > 0) || mathBlock.getMathAction() != MathAction.empty())
            mathBlockList.add(mathBlock);
    }

}
