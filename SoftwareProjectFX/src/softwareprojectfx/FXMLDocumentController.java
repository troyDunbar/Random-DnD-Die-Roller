package softwareprojectfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Label dieLabel;
    @FXML
    private Font x1;
    @FXML
    private Label rollLabel;
    @FXML
    private Label modLabel;
    @FXML
    private Label totalLabel;
    @FXML
    private ChoiceBox dieChoice;
    @FXML
    private Label outputLabel;
    @FXML
    private TextField rollText;
    @FXML
    private Label countLabel;
    @FXML
    private Label modChoiceLabel;
    @FXML
    private TextField modText;
    @FXML
    private Label rollWarning;
    @FXML
    private Label modWarning;
    @FXML
    private Button helpButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //set choiceBox options
        totalLabel.setText("total");
        dieChoice.getItems().clear();
        dieChoice.getItems().add("4");
        dieChoice.getItems().add("6");
        dieChoice.getItems().add("8");
        dieChoice.getItems().add("10");
        dieChoice.getItems().add("12");
        dieChoice.getItems().add("20");
        dieChoice.getItems().add("100");
        dieChoice.setValue("4");
        
    }    

    @FXML
    public void rollButton(ActionEvent event) {
        //set labels Empty
        rollWarning.setText("");
        modWarning.setText("");
        outputLabel.setText("");
        
        //set random generator
        Random rand = new Random();
        
        //set valid roll boolean
        boolean validRoll = false;
        
        //set valid mod boolean
        boolean validMod = false;
        
        // set the sides value
        String stringSides;
        int sides;
        
        stringSides = dieChoice.getValue().toString();
        sides = Integer.parseInt(stringSides);
        
        //set roll value
        String stringRolls;
        int rolls;
        
        //set random roll value
        int randomRoll;
        
        stringRolls = rollText.getText();
        rolls = Integer.parseInt(stringRolls);
        
        //check valid number of rolls
        if(rolls > 100 || rolls < 1){
            rollWarning.setText("invalid number");
            outputLabel.setText("invalid choice");
        }else{
            validRoll = true;
        }
        
        //set mod value
        String stringMod;
        int mod;
        
        stringMod = modText.getText();
        mod = Integer.parseInt(stringMod);
        
        //check valid mod
        if(mod > 100 || mod < -100){
            modWarning.setText("invalid number");
            outputLabel.setText("invalid choice");
        }else{
            validMod = true;
        }
        
        //roll dice
        int total = 0;
        for(int x = 0; x < rolls; x++){
            int randSide = rand.nextInt(sides);
            randSide = randSide + 1;
            total = total + randSide;
        }
        total = total + mod;
        
        //set output if valid options inputted
        if(validRoll == true && validMod == true){
            outputLabel.setText(String.valueOf(total));
        }
        
    }
    
    @FXML
    private void helpScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("FXMLDocument_1.fxml"));
        Parent root1 = (Parent) fxmlLoader1.load();
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Help Screen");
        stage1.setScene(new Scene(root1));
        stage1.setResizable(false);
        stage1.show();
    }
    

    
}
