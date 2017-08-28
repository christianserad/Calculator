
import javafx.scene.control.Label;



/**
 *
 * @author Christian Romar Paul Serad
 */
public class Computer {
    private Label label;
    private String num1 = "0";
    private String num2 = "0";
    private boolean decimal1;
    private boolean decimal2;
    private boolean operatorActivate;
    private String operator;
    
    public Computer(Label label){
        this.label = label;
    }
    
    public void setNumber(String number){
        if(!operatorActivate){
            if(num1.equals("0")){
                num1 = number;
            }
            else{
                num1 = num1 + number;
            }
            label.setText(num1);
        }
        else{
            if(num2.equals("0")){
                num2 = number;
            }
            else{
                num2 = num2 + number;
            }
            label.setText(num1 + " " + operator + " " + num2);
        }
    }
    
    public void setDecimal(String dot){
        if(!operatorActivate && !decimal1){
            num1 += dot;
            decimal1 = true;
            label.setText(num1);
        }
        else if(operatorActivate && !decimal2){
            num2 += dot;
            decimal2 = true;
            label.setText(num1 + " " + operator + " " + num2);
        }
    }
    
    public void setOperatorSign(String sign){
        if(operatorActivate){
            compute();
            if(!sign.equals("=")){
                operatorActivate = true;
                operator = sign;   
                label.setText(num1 + " " + operator);
            } 
            else{
                label.setText(num1);
            }
        }
        else if(!sign.equals("=")){
            operatorActivate = true;
            operator = sign;
            label.setText(num1 + " " + operator);
        }
    }
    
    public void compute(){
        switch(operator){
            case "+":
                num1 = String.valueOf(Double.parseDouble(num1) + Double.parseDouble(num2));
                break;
            case "-":
                num1 = String.valueOf(Double.parseDouble(num1) - Double.parseDouble(num2));
                break;
            case "X":
                num1 = String.valueOf(Double.parseDouble(num1) * Double.parseDouble(num2));
                break;
            case "/":
                num1 = String.valueOf(Double.parseDouble(num1) / Double.parseDouble(num2));
                break;
        }
        
        if(Double.parseDouble(num1) % 1 == 0){
            num1 = String.valueOf((int)Double.parseDouble(num1));
            decimal1 = false;
        }
        num2 = "0";
        decimal2 = false;
        operatorActivate = false;
    }
}
