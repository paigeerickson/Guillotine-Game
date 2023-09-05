import org.junit.*;
import static org.junit.Assert.*;
import javafx.scene.layout.VBox;

/* 
 * Tester class for Guillotine Game classes
 * @author Paige Erickson
 */

public class GuillotineGameTester {


  /**
   * Tests for Card class
   */
  @Test
  public void CardTester (){
    Card kingLouis = new Card ("King Louis XIV", 5, "Royal");
    
    // test getName()
    assertEquals("King Louis XIV", kingLouis.getName());
    // test getValue()
    assertEquals(5, kingLouis.getValue());
    
    // test getGroup()
    assertEquals("Royal", kingLouis.getGroup());
  }
  
  
  /** 
   * Tests for moveBack() function
   */
  @Test 
  public void moveBackTester (){
  
   LinkedList<Card> cardPossible = new LinkedList<Card>();
   LinkedList<Card> cardPossible2 = new LinkedList<Card>();
    
   cardPossible.addToFront(new Card("Marie Antoinette", 5, "Royal"));
   cardPossible.addToFront(new Card("Councilman", 3, "Civic"));
   cardPossible.addToFront(new Card("Heroic Figure", -3, "Commoner"));                      
   cardPossible.addToFront(new Card("King Louis XIV", 5, "Royal"));
   cardPossible.addToFront(new Card("Tragic Figure", -1, "Commoner"));
   
    // Test put first
    cardPossible.moveBack(1);
    assertEquals("King Louis XIV Tragic Figure Heroic Figure Councilman Marie Antoinette ", LinkedList.printListCards(cardPossible));
    
    // Test put middle
    cardPossible.moveBack(3);
    assertEquals("Tragic Figure Heroic Figure Councilman King Louis XIV Marie Antoinette ", LinkedList.printListCards(cardPossible)); 
    
    // Test put last
    cardPossible.moveBack(4);
    assertEquals("Heroic Figure Councilman King Louis XIV Marie Antoinette Tragic Figure ", LinkedList.printListCards(cardPossible));     
    
    cardPossible2.addToFront(new Card("Marie Antoinette", 5, "Royal"));
   
    // Test with 1 content 
    cardPossible2.moveBack(1);
    assertEquals("Marie Antoinette ", LinkedList.printListCards(cardPossible2));     
    cardPossible2.moveBack(3);
    assertEquals("Marie Antoinette ", LinkedList.printListCards(cardPossible2)); 
    
    cardPossible2.addToFront(new Card("Cardinal", 5, "Church"));
    cardPossible2.addToFront(new Card("Judge", 2, "Civic"));
    cardPossible2.addToFront(new Card("Palace Guard", 0, "Military")); 
    
    // Test with many contents
    cardPossible2.moveBack(2);
    assertEquals("Judge Cardinal Palace Guard Marie Antoinette ", LinkedList.printListCards(cardPossible2));
   
  }
  
  /**
   * Tests for moveFirstToLast
   */
  @Test
  public void moveFirstToLast (){
   LinkedList<Card> cardPossible2 = new LinkedList<Card>();

    
    // Test with 0 contents
    cardPossible2.moveFirstToLast();
    assertEquals("", LinkedList.printListCards(cardPossible2));
    
    cardPossible2.addToFront(new Card("Marie Antoinette", 5, "Royal"));
   
    // Test with 1 content 
    cardPossible2.moveFirstToLast();
    assertEquals("Marie Antoinette ", LinkedList.printListCards(cardPossible2));
    
    cardPossible2.addToFront(new Card("Cardinal", 5, "Church"));
    cardPossible2.addToFront(new Card("Judge", 2, "Civic"));
    cardPossible2.addToFront(new Card("Palace Guard", 0, "Military")); 
    
    // Test with many contents
    cardPossible2.moveFirstToLast();  
    assertEquals("Judge Cardinal Marie Antoinette Palace Guard ", LinkedList.printListCards(cardPossible2));
  
  }
  
  /**
   * Tests for moveLastToFirst()
   */
  @Test
  public void moveLastToFirstTester (){
    
   LinkedList<Card> cardPossible = new LinkedList<Card>();
   cardPossible.moveLastToFirst();
     
   // Test 0 & second branch of if statement
   assertEquals(null, cardPossible.getFirstNode());
   
   cardPossible.addToFront(new Card("Marie Antoinette", 5, "Royal"));
   
   // Test 1
   cardPossible.moveLastToFirst();
   assertEquals("Marie Antoinette " , LinkedList.printListCards(cardPossible));
                
   cardPossible.addToFront(new Card("Councilman", 3, "Civic"));
   cardPossible.addToFront(new Card("Palace Guard", 0, "Military"));     
   cardPossible.addToFront(new Card("King Louis XIV", 5, "Royal"));
   cardPossible.addToFront(new Card("Tragic Figure", -1, "Commoner"));
   
   // Test many & first branch of if statement
   cardPossible.moveLastToFirst();
   cardPossible.moveLastToFirst();
   
   assertEquals("Councilman Marie Antoinette Tragic Figure King Louis XIV Palace Guard ", LinkedList.printListCards(cardPossible));
   
  }
  
  /**
   * Tests for reverseFirstK()
   */
  @Test
  public void reverseFirstKTest (){
    LinkedList<Card> cardPossible = new LinkedList<Card>();
   cardPossible.reverseFirstK(3);
     
   // Test 0 & second branch of if statement
   assertEquals("", LinkedList.printListCards(cardPossible));
   
   cardPossible.addToFront(new Card("Marie Antoinette", 5, "Royal"));
   
   // Test 1
   cardPossible.reverseFirstK(1);   
   assertEquals("Marie Antoinette ", LinkedList.printListCards(cardPossible));
   
   // Test 1 but call a larger number
   cardPossible.reverseFirstK(5);   
   assertEquals("Marie Antoinette ", LinkedList.printListCards(cardPossible));
                
   cardPossible.addToFront(new Card("Councilman", 3, "Civic"));
   cardPossible.addToFront(new Card("Palace Guard", 0, "Military"));     
   cardPossible.addToFront(new Card("King Louis XIV", 5, "Royal"));
   cardPossible.addToFront(new Card("Tragic Figure", -1, "Commoner"));
   
   // Test many and middle
   cardPossible.reverseFirstK(3);
   assertEquals("Palace Guard King Louis XIV Tragic Figure Councilman Marie Antoinette ", LinkedList.printListCards(cardPossible));
   
   // Test last
   cardPossible.reverseFirstK(5);
   assertEquals("Marie Antoinette Councilman Tragic Figure King Louis XIV Palace Guard ", LinkedList.printListCards(cardPossible));
  
  }
  
  
  /**
   * Tests for reverseFirst()
   */
  @Test
  public void reverseListTester (){
   LinkedList<Card> cardPossible = new LinkedList<Card>();
   cardPossible.reverseList();
     
   // Test 0
   assertEquals(null, cardPossible.getFirstNode());
   
   cardPossible.addToFront(new Card("Marie Antoinette", 5, "Royal"));
   
   // Test 1
   cardPossible.reverseList();   
   assertEquals("Marie Antoinette ", LinkedList.printListCards(cardPossible));
                
   cardPossible.addToFront(new Card("Councilman", 3, "Civic"));
   cardPossible.addToFront(new Card("Palace Guard", 0, "Military"));     
   cardPossible.addToFront(new Card("King Louis XIV", 5, "Royal"));
   cardPossible.addToFront(new Card("Tragic Figure", -1, "Commoner"));
   
   // Test many
   cardPossible.reverseList();
   assertEquals("Marie Antoinette Councilman Palace Guard King Louis XIV Tragic Figure ", LinkedList.printListCards(cardPossible));
  
  }
  
  /**
   * Tests for shuffle()
   */
  @Test
  public void shuffleTester (){
   LinkedList<Card> cardPossible = new LinkedList<Card>();
   cardPossible.shuffle();
     
   // Test 0
   assertEquals(null, cardPossible.getFirstNode());
   
   cardPossible.addToFront(new Card("Marie Antoinette", 5, "Royal"));
   
   // Test 1
   cardPossible.shuffle();   
   assertEquals("Marie Antoinette ", LinkedList.printListCards(cardPossible));
                
   cardPossible.addToFront(new Card("Councilman", 3, "Civic"));
   cardPossible.addToFront(new Card("Palace Guard", 0, "Military"));     
   cardPossible.addToFront(new Card("King Louis XIV", 5, "Royal"));
   cardPossible.addToFront(new Card("Tragic Figure", -1, "Commoner"));
   
   // Test many
   LinkedList<Card> originalList = cardPossible;
   cardPossible.shuffle();
   assertNotEquals("Tragic Figure King Louis XIV Palace Guard Councilman Marie Antoinette", LinkedList.printListCards(cardPossible));
  }
  
  /* 
   * Test for addCard()
   */
  @Test
  public void addCardTester (){
    LinkedList<Card> cardPossible = new LinkedList<Card>();
    LinkedList<Card> playerDeck = new LinkedList<Card>();
    LinkedList.addCard(playerDeck, cardPossible);
    
    // Test 0
    assertEquals("", playerDeck.getFirstNode());
    
    cardPossible.addToFront(new Card("Marie Antoinette", 5, "Royal"));
    
    // Test 1
    LinkedList.addCard(playerDeck, cardPossible);  
    assertEquals("Marie Antoinette ", LinkedList.printListCards(playerDeck));
    assertEquals(null, cardPossible.getFirstNode());
    
    cardPossible.addToFront(new Card("Councilman", 3, "Civic"));
    cardPossible.addToFront(new Card("Palace Guard", 0, "Military"));     
    cardPossible.addToFront(new Card("King Louis XIV", 5, "Royal"));
    cardPossible.addToFront(new Card("Tragic Figure", -1, "Commoner"));
    
    // Test many
    LinkedList.addCard(playerDeck, cardPossible);  
    assertEquals("Tragic Figure Marie Antoinette ", LinkedList.printListCards(playerDeck));
    assertEquals("King Louis XIV Palace Guard Councilman ", LinkedList.printListCards(cardPossible));
    
    LinkedList.addCard(playerDeck, cardPossible);  
    assertEquals("King Louis XIV Tragic Figure Marie Antoinette ", LinkedList.printListCards(playerDeck));
    assertEquals("Palace Guard Councilman ", LinkedList.printListCards(cardPossible));
    
  }  
  
  /**
   * contains Tester
   */
  @Test
  public void containsNameTester () {
    
    LinkedList<Card> cardPossible = new LinkedList<Card>();
    
    // Test 0
    assertEquals(false, cardPossible.containsName("Marie Antoinette"));
                 
    cardPossible.addToFront(new Card("Marie Antoinette", 5, "Royal"));
    
    //Test 1
    assertEquals(true, cardPossible.containsName("Marie Antoinette"));
    assertEquals(false, cardPossible.containsName("Tragic Figure"));
    
    cardPossible.addToFront(new Card("Councilman", 3, "Civic"));
    cardPossible.addToFront(new Card("Palace Guard", 0, "Military"));     
    cardPossible.addToFront(new Card("King Louis XIV", 5, "Royal"));
    cardPossible.addToFront(new Card("Tragic Figure", -1, "Commoner"));
    
    // Test many
    assertEquals(true, cardPossible.containsName("Palace Guard"));
    assertEquals(false, cardPossible.containsName("General"));
  
  }
  
  
  
}