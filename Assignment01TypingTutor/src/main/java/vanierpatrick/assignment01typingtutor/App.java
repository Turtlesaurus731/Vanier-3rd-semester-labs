package vanierpatrick.assignment01typingtutor;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane keyboard = new GridPane();
        
        keyboard.setHgap(5);
        keyboard.setVgap(5);
        keyboard.setPadding(new Insets(20));
        BuildKeyboard(keyboard);
        
        root.setCenter(keyboard);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    private void BuildKeyboard(GridPane keyboard) {
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