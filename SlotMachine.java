//************************************************************************
// SlotsMachine.java Author: Miguel Rivas
//
// Demonstrates panes with random pictures and switch statements to emulate a slot machine.
//************************************************************************
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class SlotMachine extends Application {
    
private FlowPane slotsPane, buttonPane,closingPane;
private StackPane images;
private VBox primary;
private Label spinLabel,resultsLabel,buttonPanetxt;
private Button spinButton, cashButton,yesButton,noButton;      
private int spinResult,tokens;  

public void start(Stage primaryStage)
{
//this is the number of tokens that the user starts off with 
tokens =5;
spinResult=0;
    
 //FlowPane that holds will hold the spin label and result label 
 slotsPane= new FlowPane();
 slotsPane.setStyle("-fx-background-color: white");
 slotsPane.setMinSize(50,50);
 slotsPane.setMaxSize(580,490);
 slotsPane.setPrefSize(100,200);
 slotsPane.setAlignment(Pos.CENTER);
  
//text with the current tokens, this will change once start spinning
//the result of the spin plus the current tokens will equal current tokens
 spinLabel= new Label("Current Tokens: " + (tokens+spinResult));
 spinLabel.setFont(Font.font("Helvetcia",FontWeight.NORMAL,30));
 spinLabel.setTextFill(Color.BLUE);
 
 // the result of the last spin taken, with properties of color, font, and font weight 
 resultsLabel= new Label("  Result of spin: " + spinResult);
 resultsLabel.setFont(Font.font("Helvetcia",FontWeight.NORMAL,30));
 resultsLabel.setTextFill(Color.BLUE);
 
 //this will hold the pictures once start spinning and 
 //will be stack them on top of each other so only that picture can be seen
 images =new StackPane();

 //this inserts labels along with the stackpane into the slotsPane
 slotsPane.getChildren().addAll(spinLabel,resultsLabel,images);
 
 //This pane will hold the spin and cashout buttons and label serving to 
 // put text to let the user know how much they earned with the last spin
 buttonPane= new FlowPane();
 buttonPane.setStyle("-fx-background-color: blue");
 buttonPane.setMinSize(50,50);
 buttonPane.setMaxSize(580,490);
 buttonPane.setPrefSize(100,200);
 buttonPane.setAlignment(Pos.CENTER);
 
 //button used to make a spin on slot machine, along with properties and 
 //the event handler 
 spinButton = new Button("Spin");
 spinButton.setFont(Font.font("Ariel",FontWeight.NORMAL,40));
 spinButton.setOnAction(this::processButtonAction);

//button used tocashout with current tokens on slot machine and the event handler
 cashButton = new Button("Cash Out");
 cashButton.setFont(Font.font("Arial",FontWeight.NORMAL,40));
 cashButton.setOnAction(this::processButtonAction);
 
 //this the label that will have text with how much is earned with spin
 buttonPanetxt= new Label("");
 buttonPanetxt.setFont(Font.font("Helvetcia",FontWeight.NORMAL,50));
 buttonPanetxt.setTextFill(Color.WHITE);
 
 //this inserts button nad the labelinto the buttonPane 
 buttonPane.getChildren().addAll(spinButton, cashButton,buttonPanetxt);
 
 //these button will be used to indicate if the user wants to play on the 
 //slot machine again but will not work because has no event handlers
 yesButton= new Button("YES");
 yesButton.setFont(Font.font("Arial",FontWeight.NORMAL,40));
 noButton= new Button("NO");
 noButton.setFont(Font.font("Arial",FontWeight.NORMAL,40));
 
 //this is the closing pane that will be seen once the cashout button is pressed
 closingPane=new FlowPane();
 
 //this is to get the slotsPane and buttonPane vertical to each other,
//centered and the with a background color 
 primary= new VBox();
 primary.setStyle("-fx-background-color: red");
 primary.setAlignment(Pos.CENTER);
 primary.getChildren().addAll(slotsPane,buttonPane);

 // set the screne so it can be seen along with a title 
 Scene scene = new Scene(primary, 600,500);
 primaryStage.setTitle("Slot Machine");
 primaryStage.setScene(scene);
 primaryStage.show();
    
}
// this is where the event handler for the button will take place
public void processButtonAction(ActionEvent event)
{
 //We set imageNum as an integer so later select a case at random 0 through 26
 int imageNum;
 Random rand =new Random();
 imageNum= rand.nextInt(27);

//once the spinButton is pressed the random function will select a case 
if (event.getSource() == spinButton){
    switch(imageNum)
    {
      
    case 0: 
//----------------------------------------------------------------------
// inserts the image and is set to view and in the images StackPane
// this is repeated for all 27 cases 
//----------------------------------------------------------------------
        Image aaa =  new Image("aaa.png");
        ImageView view = new ImageView(aaa);
        images.getChildren().addAll(view);
//---------------------------------------------------------------------        
//every image has a distinct spin result and the new tokens is calculted 
// by taking the curent tokens and adding the spin result and 
//minusing 1 this is the cost of spinning this is the same for all 27 cases.
//----------------------------------------------------------------------
        spinResult= 5;
        tokens+= spinResult-1;
//----------------------------------------------------------------------        
// The labels are then shown with with the new curent tokens and spin result 
// this will be the same for all 27 cases
//----------------------------------------------------------------------
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
        
    case 1: 
        Image aac =  new Image("aac.png");
        ImageView view1 = new ImageView(aac);
        images.getChildren().addAll(view1);
        
        spinResult= 4;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break; 
 

    case 2: 
        Image aao=  new Image("aao.png");
        ImageView view2 = new ImageView(aao);
        images.getChildren().addAll(view2);
        
        spinResult= 1;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 3: 
        Image aca=  new Image("aca.png");
        ImageView view3 = new ImageView(aca);
        images.getChildren().addAll(view3);
        
        spinResult= 2;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 4: 
        Image acc=  new Image("acc.png");
        ImageView view4 = new ImageView(acc);
        images.getChildren().addAll(view4);
        
        spinResult= 3;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;

    case 5: 
        Image aco=  new Image("aco.png");
        ImageView view5 = new ImageView(aco);
        images.getChildren().addAll(view5);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;

    case 6: 
        Image aoa=  new Image("aoa.png");
        ImageView view6 = new ImageView(aoa);
        images.getChildren().addAll(view6);
        
        spinResult= 1;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 7: 
        Image aoc=  new Image("aoc.png");
        ImageView view7 = new ImageView(aoc);
        images.getChildren().addAll(view7);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 8: 
        Image aoo=  new Image("aoo.png");
        ImageView view8 = new ImageView(aoo);
        images.getChildren().addAll(view8);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 9: 
        Image caa=  new Image("caa.png");
        ImageView view9 = new ImageView(caa);
        images.getChildren().addAll(view9);
        
        spinResult= 3;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 10: 
        Image cac=  new Image("cac.png");
        ImageView view10 = new ImageView(cac);
        images.getChildren().addAll(view10);
        
        spinResult= 2;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 11: 
        Image cao=  new Image("cao.png");
        ImageView view11 = new ImageView(cao);
        images.getChildren().addAll(view11);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 12: 
        Image cca=  new Image("cca.png");
        ImageView view12 = new ImageView(cca);
        images.getChildren().addAll(view12);
        
        spinResult= 4;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 13: 
        Image ccc=  new Image("ccc.png");
        ImageView view13 = new ImageView(ccc);
        images.getChildren().addAll(view13);
        
        spinResult= 10;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 14: 
        Image cco=  new Image("cco.png");
        ImageView view14 = new ImageView(cco);
        images.getChildren().addAll(view14);
        
        spinResult= 2;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 15: 
        Image coa=  new Image("coa.png");
        ImageView view15 = new ImageView(coa);
        images.getChildren().addAll(view15);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 16: 
        Image coc=  new Image("coc.png");
        ImageView view16 = new ImageView(coc);
        images.getChildren().addAll(view16);
        
        spinResult= 2;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 17: 
        Image coo=  new Image("coo.png");
        ImageView view17 = new ImageView(coo);
        images.getChildren().addAll(view17);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
        
    case 18: 
        Image oaa=  new Image("oaa.png");
        ImageView view18 = new ImageView(oaa);
        images.getChildren().addAll(view18);
        
        spinResult= 1;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 19: 
        Image oac=  new Image("oac.png");
        ImageView view19 = new ImageView(oac);
        images.getChildren().addAll(view19);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 20: 
        Image oao=  new Image("oao.png");
        ImageView view20 = new ImageView(oao);
        images.getChildren().addAll(view20);
        
        spinResult= -1;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 21: 
        Image oca=  new Image("oca.png");
        ImageView view21 = new ImageView(oca);
        images.getChildren().addAll(view21);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 22: 
        Image occ=  new Image("occ.png");
        ImageView view22 = new ImageView(occ);
        images.getChildren().addAll(view22);
        
        spinResult= 1;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 23: 
        Image oco=  new Image("oco.png");
        ImageView view23 = new ImageView(oco);
        images.getChildren().addAll(view23);
        
        spinResult= -1;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 24: 
        Image ooa=  new Image("ooa.png");
        ImageView view24 = new ImageView(ooa);
        images.getChildren().addAll(view24);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 25: 
        Image ooc=  new Image("ooc.png");
        ImageView view25 = new ImageView(ooc);
        images.getChildren().addAll(view25);
        
        spinResult= 0;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;
    
    case 26: 
        Image ooo=  new Image("ooo.png");
        ImageView view26 = new ImageView(ooo);
        images.getChildren().addAll(view26);
        
        spinResult= -5;
        tokens+= spinResult-1;
        spinLabel.setText("Current Tokens: " + tokens);
        resultsLabel.setText(" Result of Spin:" + spinResult);
        buttonPanetxt.setText("You've Earned " + spinResult );
    break;

// the switch the ends here and if statement for spinButton  
    }
}

// an else if statement to incialeize if cashoutButton is pressed
else if (event.getSource() == cashButton){

// the buttonPane Label will be used for closing screen and the text is changed
//to state how many tokens were won and if user would like to play again.
    buttonPanetxt.setText("Congratulations you have earned " + tokens+ " tokens!"+ 
             "\n Would you like to play again?" );
     
//the closing pane is set up with dimension, postion, color properties
     closingPane.setStyle("-fx-background-color: Green");
     closingPane.setMinSize(400,400);
     closingPane.setMaxSize(1000,900);
     closingPane.setPrefSize(650,650);
     closingPane.setAlignment(Pos.CENTER);

// adds the buttonpane label, yes,and no button to closing pane.
     closingPane.getChildren().addAll(buttonPanetxt,yesButton,noButton);
 
//since the primary Pane is holds everything so the scene can seen I
//remove the slots and button Pane and included the new closing Pane 
     primary.getChildren().removeAll(slotsPane,buttonPane);
     primary.getChildren().addAll(closingPane);
        }
            
    }

}



