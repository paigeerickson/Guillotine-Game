import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> implements Iterable{
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    firstNode = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }

  /**
   * Changes the front node.
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }

  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
  /**
   * Add an element to the front of the linked list
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Removes and returns the element at the front of the linked list
   * @return the element removed from the front of the linked list
   * @throws NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirstNode().getElement();
      setFirstNode(getFirstNode().getNext());
      return save;
    }
  }

  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int count = 0;
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr != null) {
      count++;
      nodeptr = nodeptr.getNext();
    }
    return count;
  }
  
  /**
   * Adds an element to the end of the linkd list
   * @param element the element to insert at the end
   */
  public void addToEnd(T element) {
    if (isEmpty())
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFirstNode();
      while (nodeptr.getNext() != null) 
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  /**
   * Moves a node back a given number of spaces
   * @param n   number of spaces to move the card back
   */
  public void moveBack(int n){
    // original node to move back
    LLNode<T> savedNode = this.getFirstNode();
    
    // node pointer to traverse the list 
    LLNode<T> nodeptr = this.getFirstNode();
    
    if(n <= this.length() && n != 0 && this.length() > 1) {
      
      for(int i = 0; i < n; i++){
        nodeptr = nodeptr.getNext();
      }
      
      nodeptr.insertAfter(savedNode.getElement());
      this.removeFromFront();
    }
    
    else
      ;
  }
  
  /**
   * Moves the first node to the back of the linkd list
   */
  public void moveFirstToLast(){
    if(this.length() > 0){
      this.addToEnd(this.getFirstNode().getElement());
      this.removeFromFront();
    }
    else
      ;
  }
  
  /**
   * Moves last node to the first in the linkd list
   */
  public void moveLastToFirst(){
    // node pointer to traverse the list
    LLNode<T> nodeptr = this.getFirstNode();
    
    if(this.getFirstNode() != null & this.length() > 1){
      for(int i = 0; i < this.length() - 2; i++)
        nodeptr = nodeptr.getNext();
      
      this.addToFront(nodeptr.getNext().getElement());
      nodeptr.deleteNext();
       
    }
    
    else
      ;
  }  
  
  /**
   * Reverses the first k number of nodes in the linkd list
   * @param k number of nodes to reverse in the list
   */
  public void reverseFirstK(int k){
    if(k <= this.length() && k != 0 && this.length() > 1) {      
      for(int i = k - 1; i > 0; i--){
        this.moveBack(i);
      }
    }
    else
      ;
  }
  
   /**
   * Reverses the entire list
   */
  public void reverseList(){
    reverseFirstK(this.length());
  }

////////////// NOTE  /////////////////
  /* up until this point in the code, a template file contatining mostly incomplete functions 
     (the functions above) were used to complete this project. The following functions were
     entirely written by me with only the outside assistance being that of other classmates 
     for debugging. 
  */
  
    /**
   * shuffles a given list of items into a TilePane
   */
  public void shuffle(){
    if(this.length() > 1){
      for(int i = 0; i < this.length() * 2; i++){
        int rndCard = (int)(Math.random() * this.length());
        this.moveBack(rndCard);
      }
    }
  }
  
  /** 
   * Adds the first card to the player's deck
   * @param bigDeck big deck from which to remove the card
   */
  public static void addCard(LinkedList<Card> playerDeck, LinkedList<Card> bigDeck){
    if(bigDeck.length() > 0){
      playerDeck.addToFront(bigDeck.getFirstNode().getElement());
      bigDeck.removeFromFront();
    }
    else
      ;
  }
  
  /**
   * returns a statement declaring the winner
   * @param playerDeck1 player 1's deck of cards to add up
   * @param playerDeck2 player 2's deck of cards to add up
   * @return returns statement declaring player win or a tie
   */
  public static String playerWin(LinkedList<Card> player1Deck, LinkedList<Card> player2Deck){
    if(findPlayerTotal(player1Deck) > findPlayerTotal(player2Deck))
      return "Player 1 Total: " + findPlayerTotal(player1Deck) + "\nPlayer 2 Total: " + findPlayerTotal(player2Deck) + "\nPlayer 1 wins!";
    else if(findPlayerTotal(player2Deck) > findPlayerTotal(player1Deck))
      return "Player 1 Total: " + findPlayerTotal(player1Deck) + "\nPlayer 2 Total: " + findPlayerTotal(player2Deck) + "\nPlayer 2 wins!";
    else
      return "Player 1 Total: " + findPlayerTotal(player1Deck) + "\nPlayer 2 Total: \n" + "It was a tie!";  
  }
  
  /**
   * Adds the player totals together
   * @param playerDeck player's deck of cards to add together
   */
  public static int findPlayerTotal(LinkedList<Card> playerDeck){
    // player total to return
    int pointTotal = 0;
    
    // nodeptr to traverse list
    LLNode<Card> nodeptr = playerDeck.getFirstNode();
    for (int i = 0; i < playerDeck.length(); i++){
      pointTotal = pointTotal + nodeptr.getElement().getValue();
    }
    
    for (int j = 0; j < playerDeck.length(); j++){
      if(playerDeck.containsName("Countess") && playerDeck.containsName("Count"))
        pointTotal = pointTotal + 4;      
      
      if(playerDeck.containsName("Lord") && playerDeck.containsName("Lady"))
        pointTotal = pointTotal + 4;
      
      if(playerDeck.containsName("Heretic"))
        pointTotal = pointTotal + playerDeck.howManyTypeContains("Church");
      
      if(playerDeck.containsName("Palace Guard")){
        int pgCounter = 0;
        LLNode<Card> nodeptrPG = playerDeck.getFirstNode();
        for(int i = 0; i < playerDeck.length() - 1; i++){
          if(nodeptrPG.getElement() instanceof Card){
            Card cardNode = (Card)nodeptrPG.getElement();
            if(cardNode.getName() == "PalaceGuard")
              pgCounter++;
            else
              nodeptr = nodeptr.getNext();
          }
          else
            nodeptr = nodeptr.getNext();
          
          pointTotal = pointTotal + (pgCounter * pgCounter);
        }
      }
      
      if (playerDeck.containsName("Tragic Figure")){
        pointTotal = pointTotal + (playerDeck.howManyTypeContains("Commoner") * (-1));
        
      }
    }
    return pointTotal;
  }
  
  /**
   * Return an iterator for this list
   * @return the iterator for the list
   */
  @Override
  public LinkedListIterator<T> iterator() {
    return new LinkedListIterator<T>(getFirstNode());
  }
  
   /**
   * Prints the contents of a linked list to System.out.
   * @param list the linked list to print
   */
  public static String printListCards(LinkedList<Card> list) {
    // nodeptr to traverse list
    LLNode nodeptr = list.getFirstNode ();
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < list.length(); i++){
      if(nodeptr.getElement() instanceof Card){
        // card version of the nodeptr element
        Card newNode = (Card)nodeptr.getElement();
        str.append(newNode.getName());
        str.append(" ");
      }   
      nodeptr = nodeptr.getNext();
    }
    return str.toString();
  }
  
  /**
   * Detects if the list contains an item with a given name
   * @param name name of item being looked for
   */
  public boolean containsName(String name){
    // nodeptr to traverse list
    LLNode<T> nodeptr = this.getFirstNode();
    for(int i = 0; i < this.length() - 1; i++){
      if(nodeptr.getElement() instanceof Card){
        // card version of nodeptr element
        Card cardNode = (Card)nodeptr.getElement();
        if(cardNode.getName() == name)
          return true;
        else
          nodeptr = nodeptr.getNext();
      }
      else
        nodeptr = nodeptr.getNext();
    }
    return false;
  }
  
  /**
   * finds how many cards of a certain group are present in a list
   * @param type group type to be found
   */
  public int howManyTypeContains(String type){
    // total number of cards in the list
    int total = 0;
    // nodeptr to traverse the list
    LLNode<T> nodeptr = this.getFirstNode();
    for(int i = 0; i < this.length() - 1; i++){
      if(nodeptr.getElement() instanceof Card){
        Card cardNode = (Card)nodeptr.getElement();
        if(cardNode.getGroup() == type)
          total = total + 1;
        else
          nodeptr = nodeptr.getNext();
      }
      else
        nodeptr = nodeptr.getNext();
    }
    return total;
  }
    
  /**
   * Take a linked list that is already sorted in order and add a new element
   * into the correct location
   * @param list the linked list
   * @param element the element to add
   */
  public static <S extends Comparable<? super S>> void insertInOrder(LinkedList<S> list, S element) {
    if (list.isEmpty()) {
      list.addToFront(element);
    }
    else {
      // case 1: the element goes to front of list
      if (element.compareTo(list.getFirstNode().getElement()) < 0)
        list.addToFront(element);
      // case 2: the element goes elsewhere, create a nodeptr to find where it goes
      else {
        LLNode<S> nodeptr = list.getFirstNode();
        while (nodeptr.getNext() != null && nodeptr.getNext().getElement().compareTo(element) < 0)
          nodeptr = nodeptr.getNext();
        // when the loop ends the element goes after nodeptr
        nodeptr.setNext(new LLNode<>(element, nodeptr.getNext()));
      }
    }
  }
}
