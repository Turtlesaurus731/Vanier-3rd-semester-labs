package vanierpatrick.assignment01typingtutor;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
        VBox textArea = new VBox(10);

        keyboard.setHgap(5);
        keyboard.setVgap(5);
        keyboard.setPadding(new Insets(20));
        buildKeyboard(keyboard);
        
        Label inputLabel = new Label("Text to Type:");
        TextField inputField = new TextField();
        Label outputLabel = new Label("What you wrote:");
        TextField outputField = new TextField();
        Label pressedKey = new Label("Pressed key:\n");
        
        inputField.setEditable(false);
        outputField.setEditable(false);
        
        textArea.getChildren().addAll(
                inputLabel, inputField,
                outputLabel, outputField,
                pressedKey);
        
        root.setTop(textArea);
        root.setCenter(keyboard);
        Scene scene = new Scene(root);
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
            Button button = new Button(key.toString());
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