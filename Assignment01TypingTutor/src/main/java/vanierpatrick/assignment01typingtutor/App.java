package vanierpatrick.assignment01typingtutor;

import javafx.scene.input.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane keyboard = new GridPane();
        VBox topArea = new VBox(10);
        HBox bottomArea = new HBox(100);
        
        keyboard.setHgap(5);
        keyboard.setVgap(5);
        keyboard.setPadding(new Insets(20));
        buildKeyboard(keyboard);
        
        String[] textToInput = {
            "Try typing this text. Do it as quickly and accurately as you can.",
            "Next type another line of input data.",
            "The quick brown fox jumps over the lazy dog.",
            "Five big quacking zephyrs jolt my wax bed.",
            "Sympathizing would fix Quaker objectives.",
            "A large fawn jumped quickly over white zinc boxes."
        };
        
        int[] currentTextToInput = {0};
        
        Label inputLabel = new Label("Text to Type:");
        TextField inputField = new TextField();
        Label outputLabel = new Label("What you wrote:");
        TextField outputField = new TextField();
        Label pressedKey = new Label("Pressed key:");
        
        inputField.setText(textToInput[0]);
        inputField.setEditable(false);
        outputField.setEditable(false);
        
        topArea.getChildren().addAll(
                inputLabel, inputField,
                outputLabel, outputField,
                pressedKey);
        
        Button resetButton = new Button("Reset");
        Button nextButton = new Button("Next");
        Label counterLabel = new Label("1/6");
        
        bottomArea.getChildren().addAll(resetButton, nextButton, counterLabel);
        bottomArea.setAlignment(Pos.CENTER);
        
        nextButton.setOnAction(e -> {
            if (currentTextToInput[0] < textToInput.length - 1) {
                currentTextToInput[0]++;
                inputField.setText(textToInput[currentTextToInput[0]]);
                outputField.clear();
                counterLabel.setText(
                        (currentTextToInput[0] + 1 + "/" + textToInput.length));
            }
        });
        
        resetButton.setOnAction(e -> {
            currentTextToInput[0] = 0;
            inputField.setText(textToInput[0]);
            outputField.clear();
            counterLabel.setText("1/6");
        });
        
        root.setTop(topArea);
        root.setCenter(keyboard);
        root.setBottom(bottomArea);
        Scene scene = new Scene(root);
        
        scene.setOnKeyPressed(e ->{
            try {
                KeyboardKeys.valueOf(e.getCode().toString());
                pressedKey.setText("Pressed Key:" + e.getCode());
            } catch (IllegalArgumentException exception) {
                pressedKey.setText("Not handled");
            }
        });
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    /**
     * Use the info stored in KeyboardKeys to build the keyboard layout
     * @param keyboard the keyboard GridPane in which the keys will be added to
     */
    private void buildKeyboard(GridPane keyboard) {
        Map<KeyboardKeys, Button> keyboardButtons = new HashMap<>();
        int row = 0;
        int column = 0;
        
        for (KeyboardKeys key : KeyboardKeys.values()) {
            String keyText = key.toString();
            
            if (key == KeyboardKeys.PERIOD) {
                keyText = ".";
            }
            
            Button button = new Button(keyText);
            button.setPrefWidth(50);
            keyboardButtons.put(key, button);
            
            if (key == KeyboardKeys.SHIFT) {
                button.setPrefWidth(80);
                keyboard.add(button, 0, 3, 2, 1);
            } 
            else if (key == KeyboardKeys.SPACE) {
                button.setPrefWidth(200);
                keyboard.add(button, 2, 3, 6, 1);
            }else {
                keyboard.add(button, column, row);
                column++;

                if (row == 0 && column == 10) {
                    row++;
                    column = 0;
                } 
                else if (row == 1 && column == 9) {
                    row++;
                    column = 0;
                }
            }    
        }
    }
}