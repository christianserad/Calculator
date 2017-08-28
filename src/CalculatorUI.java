
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class CalculatorUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        // Calculator Screen Label
        Label calculatorScreen = new Label("0");
        
        // Event Handler
        ButtonEventHandler buttonEventHandler = new ButtonEventHandler(calculatorScreen);
        
        // Button Digit
        Button[] btnNumber = new Button[10];
        
        // Button Dot
        Button dot = new Button(".");
        dot.setPrefWidth(40);
        dot.setOnAction(buttonEventHandler);
        
        // Button Operator Signs
        Button[] operatorSign = new Button[5];

        grid.add(calculatorScreen, 0, 0, 4, 1);

        int digit = btnNumber.length - 1;

        for (int row = 1; row < 5; row++) {
            for (int column = 2; column >= 0; column--) {
                try {
                    btnNumber[digit] = new Button(Integer.toString(digit));
                    btnNumber[digit].setPrefWidth(40);
                    btnNumber[digit].setOnAction(buttonEventHandler);
                    grid.add(btnNumber[digit], column, row);
                    digit -= 1;
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        grid.add(dot, 1, 4);
        grid.add(operatorSign[0] = new Button("/"), 0, 4);
        grid.add(operatorSign[1] = new Button("X"), 3, 1);
        grid.add(operatorSign[2] = new Button("-"), 3, 2);
        grid.add(operatorSign[3] = new Button("+"), 3, 3);
        grid.add(operatorSign[4] = new Button("="), 3, 4);
        
        for(int i = 0; i < operatorSign.length; i++){
            operatorSign[i].setPrefWidth(40);
            operatorSign[i].setOnAction(buttonEventHandler);
        }
        
       

        grid.setGridLinesVisible(false);
        
        Scene scene = new Scene(grid, 200, 200);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
