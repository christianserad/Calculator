
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 *
 * @author Christian Romar Paul Serad
 */
public class ButtonEventHandler implements EventHandler<ActionEvent>{
    
    private Computer computer;
    
    public ButtonEventHandler(Label label){
        computer = new Computer(label);
    }
    @Override
    public void handle(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String sign = btn.getText();
        
        
        if (Character.isDigit(sign.charAt(0))){
            computer.setNumber(sign);
        }
        else if(sign.charAt(0) == '.'){
            computer.setDecimal(sign);
        }
        else{
            computer.setOperatorSign(sign);
        }
    }
    
}
