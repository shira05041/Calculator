package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorController {

	@FXML
	private Label prevnum;

	@FXML	  
	private Label resuLt;
    
    private double num1 = 0 ;
    private double num2 = 0 ;
    private double total = 0;
    private boolean check = true;
    private String operator = "";

    //this method calculate 2 numbers according to the operator
    public double create(double num1, double num2, String operator) {
    	switch (operator) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if(num2==0)
				return 0;
			return (num1 / num2);
		default:
			break;
		}
		return 0;
    }

    
    
    public void number(String number) {
    	
    	resuLt.setText(resuLt.getText() + number);
    }
    
    public void prevNumber(String number) {
    	prevnum.setText(prevnum.getText() + number);
    }
    
    public void prevOperator(String operator) {
    	prevnum.setText(prevnum.getText() + " " + operator + " ");
    }
    
    //this method works when you press a number button
    @FXML
    void culculateProcess(ActionEvent event) {
    	if(check) {
    		resuLt.setText("");
    		prevnum.setText("");
    	
    	    check = false;
    	}
    Button button = (Button)event.getSource();
    String value = button.getText();
    number(value);
    prevNumber(value);
     
   }
    
    //this method works when you press an operator button
    @FXML
    void operatorProcess(ActionEvent event) {

    	Button button = (Button)event.getSource();
        String value = button.getText();
        if(!value.equals("=")) { //if you pressed any operator except the operator = .
        	if(!operator.isEmpty()) {
        		num2 = Double.parseDouble(resuLt.getText());
        		num1 = create(num1, num2, operator);
        		
        		prevnum.setText(String.valueOf(num1));
        		resuLt.setText("");
        		
        		
        	    
        	}
        	else{ //if you press the = button
        			num1 = Double.parseDouble(resuLt.getText());
        			resuLt.setText("");
        		}
	
       	operator=value;
        prevOperator(operator); 	
        }
        
        else {
        	if(operator.isEmpty())//if someone pressed = without any numbers
        		return;
            num2 = Double.parseDouble(resuLt.getText());
        	total = create(num1, num2, operator);
        	resuLt.setText(String.valueOf(total));
        	
        	operator = "";
        	check  = true ; 
    		}
    }
        
    	//this method works when you pressed the clear button.	
        @FXML
        void clear(ActionEvent event) {
 
        		resuLt.setText("0");
        		prevnum.setText("");
        		check = true;
        }
        
        //this method works when you pressed the -/+ button. this method create a negative number.
        @FXML
        void plusMinus(ActionEvent event) {
        	
        	resuLt.setText("");
    		prevnum.setText("");
        	number("-");
        	prevNumber("-");
        	check=false;


        }
}   
   
    
  
    




