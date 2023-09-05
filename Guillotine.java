/**
 * a class representing a Guillotine Game
 * @author Paige Erickson
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.lang.Integer;


public class Guillotine extends Application {
  
  // parameter entered into 
  private static int parameter;
  
  // boolean for if player 1's turn is active
  private static boolean player1Turn = true;
  
  // boolean for player 2's turn is active
  private static boolean player2Turn = false;
  
  // list of cards
  private static LinkedList<Card> cards = new LinkedList<Card>();
  
  // card Deck
  private static CardDeck cardDeck = new CardDeck(cards);  
  
  // list of cards that is actually used
  private static LinkedList<Card> cardsUsed = new LinkedList<Card>();

  // method to run at start of game
  public void start(Stage primaryStage){
    
    // the overall game board
    BorderPane gamePane = new BorderPane();
    
    // scene in which the game is set
    Scene gameScene = new Scene(gamePane);
    
    // space for card deck
    VBox cardDeckBox = new VBox();
    
    // make card deck
    LLNode<Card> nodeptr = this.getCardList().getFirstNode(); 
    
    
    if (parameter >= 2 && parameter <= 41) {
      for(int j = 0; j < parameter && j < this.getCardList().length(); j++){
        this.getCardsUsed().addToFront(nodeptr.getElement());
        nodeptr = nodeptr.getNext();
      }
      LLNode<Card> nodeptr3 = this.getCardsUsed().getFirstNode();

      for (int k = 0; k < this.getCardsUsed().length(); k++){
        cardDeckBox.getChildren().add(new Button(nodeptr3.getElement().toString()));
        nodeptr3 = nodeptr3.getNext();
     }
    }
    
    else{
      for(int i = 0; i < 21 && i < this.getCardList().length(); i++){
        cardsUsed.addToFront(nodeptr.getElement());
        nodeptr = nodeptr.getNext();
      }
      LLNode<Card> nodeptr3 = this.getCardsUsed().getFirstNode();
      for (int j = 0; j < this.getCardsUsed().length(); j++){
        cardDeckBox.getChildren().add(new Button(nodeptr3.getElement().toString()));
        nodeptr3 = nodeptr3.getNext();
     }
    }
    
    // ScrollPane for card deck
    ScrollPane cardDeckPane = new ScrollPane(cardDeckBox);
    
    // player 1's board
    VBox p1Board = new VBox();
    
    // player 1's cards
    VBox p1Cards = new VBox();
    
    // player 1's list of cards
    LinkedList<Card> player1Cards = new LinkedList<Card>();
    
     //ScrollPane for player 1 card deck
    ScrollPane p1CardDeckPane = new ScrollPane(p1Board);
    
    // player 2's board
    VBox p2Board = new VBox();
    
    // player 2's card deck
    VBox p2Cards = new VBox();
    
    //player 2's list of cards
    LinkedList<Card> player2Cards = new LinkedList<Card>();
    
    // ScrollPane for player 2 card deck
    ScrollPane p2CardDeckPane = new ScrollPane(p2Board);
    
    // player 1's name
    Label p1Name = new Label("Player 1");
    
    // player 2's name
    Label p2Name = new Label("Player 2");
    
    // player 1's points
    Label p1Score = new Label("Score: 0");
    
    // player 2's points
    Label p2Score = new Label("Score: 0");
    
    // "People Collected" text
    Label peopleCollected = new Label("People Collected");
    
    // "People Collected" text
    Label peopleCollectedp2 = new Label("People Collected");
    
    /**
     * PLAYER 1 INFORMATION
     */
    
    // button to move the front card back 4
    Button moveFrontBack4 = new Button("Move Front Back 4");
    
    // button to move the front card back 3
    Button moveFrontBack3 = new Button("Move Front Back 3");
    
    // button to move the front card back 2
    Button moveFrontBack2 = new Button("Move Front Back 2");
    
    // button to move the front card back 1
    Button moveFrontBack1 = new Button("Move Front Back 1");
    
    // button to move the front card to the back
    Button moveFrontToEnd = new Button("Move Front to End");
    
    // button to move the last card to the front
    Button lastPersonToFront = new Button("Move Last Person to Front");
    
    // button to reverse the card lineup
    Button reverseLine = new Button("Reverse Line");
    
    // button to reverse the first 5 cards
    Button reverseFirst5 = new Button("Reverse First 5");
    
    // button to skip the next player's turn
    Button skipTurn = new Button("Skip Turn");
    
    // button to take the front person
    Button takeFront = new Button("Take Front Person");
    
    /**
     * PLAYER 2 INFORMATION
     */    
    
    // button to move the front card back 4
    Button moveFrontBack4p2 = new Button("Move Front Back 4");
    
    // button to move the front card back 3
    Button moveFrontBack3p2 = new Button("Move Front Back 3");
    
    // button to move the front card back 2
    Button moveFrontBack2p2 = new Button("Move Front Back 2");
    
    // button to move the front card back 1
    Button moveFrontBack1p2 = new Button("Move Front Back 1");
    
    // button to move the front card to the back
    Button moveFrontToEndp2 = new Button("Move Front to End");
    
    // button to move the last card to the front
    Button lastPersonToFrontp2 = new Button("Move Last Person to Front");
    
    // button to reverse the card lineup
    Button reverseLinep2 = new Button("Reverse Line");
    
    // button to reverse the first 5 cards
    Button reverseFirst5p2 = new Button("Reverse First 5");
    
    // button to skip the next player's turn
    Button skipTurnp2 = new Button("Skip Turn");
    
    // button to take the front person
    Button takeFrontp2 = new Button("Take Front Person");
    
    // adds all of player 1's buttons to the board
    p1Board.getChildren().add(p1Name);
    p1Board.getChildren().add(p1Score);
    p1Board.getChildren().add(moveFrontBack4);
    p1Board.getChildren().add(moveFrontBack3);
    p1Board.getChildren().add(moveFrontBack2);
    p1Board.getChildren().add(moveFrontBack1);
    p1Board.getChildren().add(moveFrontToEnd);
    p1Board.getChildren().add(reverseLine);
    p1Board.getChildren().add(reverseFirst5);
    p1Board.getChildren().add(skipTurn);
    p1Board.getChildren().add(takeFront);
    p1Board.getChildren().add(peopleCollected);  
    p1Board.getChildren().add(p1Cards);
    
    // adds all of player 2's buttons to the board
    p2Board.getChildren().add(p2Name);
    p2Board.getChildren().add(p2Score);
    p2Board.getChildren().add(moveFrontBack4p2);
    p2Board.getChildren().add(moveFrontBack3p2);
    p2Board.getChildren().add(moveFrontBack2p2);
    p2Board.getChildren().add(moveFrontBack1p2);
    p2Board.getChildren().add(moveFrontToEndp2);
    p2Board.getChildren().add(reverseLinep2);
    p2Board.getChildren().add(reverseFirst5p2);
    p2Board.getChildren().add(skipTurnp2);
    p2Board.getChildren().add(takeFrontp2);
    p2Board.getChildren().add(peopleCollectedp2);   
    p2Board.getChildren().add(p2Cards);
    
    // sets up the board
    gamePane.setRight(p2CardDeckPane);
    gamePane.setLeft(p1CardDeckPane);
    gamePane.setCenter(cardDeckPane);
   
    if (cardsUsed.length() > 0){
    moveFrontBack4.setOnMouseClicked(e -> {
      if (player1Turn == true && cardsUsed.length() > 4){
        cardsUsed.moveBack(4);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack4.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 4)
        moveFrontBack4.setDisable(true);
      else
        ;
    }); 
    
    moveFrontBack3.setOnMouseClicked(e -> {
      if(player1Turn == true && cardsUsed.length() > 3){
        cardsUsed.moveBack(3);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack3.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 3){
        moveFrontBack3.setDisable(true);
      }
      else
        ;
    }); 
    
    moveFrontBack2.setOnMouseClicked(e -> {
      if(player1Turn == true && cardsUsed.length() > 2){
        cardsUsed.moveBack(2);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack2.setDisable(true);
      }
       else if (player1Turn == true && cardsUsed.length() <= 2){
        moveFrontBack2.setDisable(true);
      }
      else
        ;
    }); 
    
    moveFrontBack1.setOnMouseClicked(e -> {
      if(player1Turn == true && cardsUsed.length() > 1){
        cardsUsed.moveBack(1);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack1.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 1){
        moveFrontBack1.setDisable(true);
      }
      else
        ;
    }); 
    
    moveFrontToEnd.setOnMouseClicked(e -> {
      if (player1Turn == true && cardsUsed.length() > 1){
        cardsUsed.moveBack(cardsUsed.length() - 1);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontToEnd.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 1){
        moveFrontToEnd.setDisable(true);
      }
      else
        ;
    }); 
    
    reverseLine.setOnMouseClicked(e -> {
      if (player1Turn == true && cardsUsed.length() > 1){
        cardsUsed.reverseList();
        updateCardList(cardsUsed, cardDeckBox);
        reverseLine.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 1){
        reverseLine.setDisable(true);
      }
      else
        ;
    }); 
    
    reverseFirst5.setOnMouseClicked(e -> {
      if(player1Turn == true && cardsUsed.length() > 5){
        cardsUsed.reverseFirstK(5);
        updateCardList(cardsUsed, cardDeckBox);
        reverseFirst5.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 5){
        reverseFirst5.setDisable(true);
      }
      else
        ;
    }); 
    
    skipTurn.setOnMouseClicked(e -> {
      if(player1Turn == true){
        setPlayer1Turn(false);
        setPlayer2Turn(true);
        skipTurn.setDisable(true);
      }
      else 
        ;
    }); 
    
    takeFront.setOnMouseClicked(e -> {
      if(player1Turn == true){
        LinkedList.addCard(player1Cards, cardsUsed);
        updateCardList(cardsUsed, cardDeckBox);
        updateCardList(player1Cards, p1Cards);
        p1Score.setText("Score: " + LinkedList.findPlayerTotal(player1Cards));
        moveFrontBack4.setDisable(true);
        setPlayer1Turn(false);
        setPlayer2Turn(true);
        if(cardsUsed.length() == 0){
          cardDeckBox.getChildren().add(new Label(LinkedList.playerWin(player1Cards, player2Cards)));
        }
      }
      else
        ;
    });       
    
    moveFrontBack4p2.setOnMouseClicked(e -> {
      if(player2Turn == true && cardsUsed.length() > 4){
        cardsUsed.moveBack(4);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack4p2.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 4){
        moveFrontBack4p2.setDisable(true);
      }
      else
        ;
    }); 
    
    moveFrontBack3p2.setOnMouseClicked(e -> {
      if(player2Turn == true && cardsUsed.length() > 3){
        cardsUsed.moveBack(3);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack3p2.setDisable(true);
      }
      else if (player2Turn == true && cardsUsed.length() <= 3){
        moveFrontBack3p2.setDisable(true);
      }
      else
        ;
    }); 
    
    moveFrontBack2p2.setOnMouseClicked(e -> {
      if(player2Turn == true && cardsUsed.length() > 2){
        cardsUsed.moveBack(2);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack2p2.setDisable(true);
      }
      else if (player2Turn == true && cardsUsed.length() <= 2){
        moveFrontBack2p2.setDisable(true);
      }
      else
        ;
    }); 
    
    moveFrontBack1p2.setOnMouseClicked(e -> {
      if(player2Turn == true && cardsUsed.length() > 1){
        cardsUsed.moveBack(1);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontBack1p2.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 1){
        moveFrontBack1p2.setDisable(true);
      }
      else
        ;
    }); 
    
    moveFrontToEndp2.setOnMouseClicked(e -> {
      if (player2Turn == true && cardsUsed.length() > 1){
        cardsUsed.moveBack(cardsUsed.length() - 1);
        updateCardList(cardsUsed, cardDeckBox);
        moveFrontToEndp2.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 1){
        moveFrontToEndp2.setDisable(true);
      }
      else
        ;
    }); 
    
    reverseLinep2.setOnMouseClicked(e -> {
      if (player2Turn == true && cardsUsed.length() > 1){
        cardsUsed.reverseList();
        updateCardList(cardsUsed, cardDeckBox);
        reverseLinep2.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 1){
        reverseLinep2.setDisable(true);
      }
      else
        ;
    }); 
    
    reverseFirst5p2.setOnMouseClicked(e -> {
      if(player2Turn == true && cardsUsed.length() > 1){
        cardsUsed.reverseFirstK(5);
        updateCardList(cardsUsed, cardDeckBox);
        reverseFirst5p2.setDisable(true);
      }
      else if (player1Turn == true && cardsUsed.length() <= 1){
        reverseFirst5p2.setDisable(true);
      }
      else
        ;
      
    }); 
    
    skipTurnp2.setOnMouseClicked(e -> {
      if(player2Turn == true){
        setPlayer2Turn(false);
        setPlayer1Turn(true);
        skipTurnp2.setDisable(true);
      }
      else 
        ;
    }); 
    
    takeFrontp2.setOnMouseClicked(e -> {
      if(player2Turn == true){
        LinkedList.addCard(player2Cards, cardsUsed);
        updateCardList(cardsUsed, cardDeckBox);
        updateCardList(player2Cards, p2Cards);
        p2Score.setText("Score: " + LinkedList.findPlayerTotal(player2Cards));
        setPlayer2Turn(false);
        setPlayer1Turn(true);
        if(cardsUsed.length() == 0){
          cardDeckBox.getChildren().add(new Label(LinkedList.playerWin(player1Cards, player2Cards)));
        }
      }
      else
        ;
    });
    }
    
    else {
      moveFrontBack4.setDisable(true);
      moveFrontBack3.setDisable(true);
      moveFrontBack2.setDisable(true);
      moveFrontBack1.setDisable(true);
      moveFrontToEnd.setDisable(true);
      reverseLine.setDisable(true);
      reverseFirst5.setDisable(true);
      skipTurn.setDisable(true);
      takeFront.setDisable(true);
      peopleCollected.setDisable(true);
      moveFrontBack4p2.setDisable(true);
      moveFrontBack3p2.setDisable(true);
      moveFrontBack2p2.setDisable(true);
      moveFrontBack1p2.setDisable(true);
      moveFrontToEndp2.setDisable(true);
      reverseLinep2.setDisable(true);
      reverseFirst5p2.setDisable(true);
      skipTurnp2.setDisable(true);
      takeFrontp2.setDisable(true);
    }
    
    // stage in which the scene is set
    primaryStage.setScene(gameScene);
    
    // display gameboard
    primaryStage.show(); 
 
  }
  
  
  /**
   * gets the parameters given by user
   * @return returns the parameters 
   */
  public int getParameter(){
    return this.parameter;
  }
  
  /**
   * gets the card deck
   * @return returns card deck
   */
  public CardDeck getCardDeck(){
    return this.cardDeck;
  }
  
  /**
   * gets the card list
   * @return returns the card list
   */
  public LinkedList<Card> getCardList(){
    return this.cards;
  }
  
  /**
   * gets the card used list
   * @return returns the cards used list
   */
  public LinkedList<Card> getCardsUsed(){
    return this.cardsUsed;
  }
  
  /**
   * Updates the buttons in a given VBox to the contents of a given list
   * @param cards       cardList to make into buttons
   * @param cardDeckBox VBox in which to put new buttons
   */
  public static void updateCardList(LinkedList<Card> cards, VBox cardDeckBox){
    LLNode<Card> nodeptr2 = cards.getFirstNode();
    cardDeckBox.getChildren().clear();
    for(int i = 0; i < cards.length(); i++){
      cardDeckBox.getChildren().add(new Button(nodeptr2.getElement().toString()));
      nodeptr2 = nodeptr2.getNext();
    }
  }
  
  /**
   * sets player 1's turn to true or false
   * @param turnValue true/false value
   */
  public void setPlayer1Turn(boolean turnValue){
    player1Turn = turnValue;
  }
  
  /**
   * sets player 2's turn to true or false
   * @param turnValue true/false value
   */
  public void setPlayer2Turn(boolean turnValue){
    player2Turn = turnValue;
  }

  /**
   * Launches the game
   * @param args the number of cards in the game
   */
  public static void main(String[] args) {
    if(args.length == 0)
      parameter = 20;
    
    else
     parameter = Integer.parseInt(args[0]);
    
     Application.launch(args);
  }   
     
} 