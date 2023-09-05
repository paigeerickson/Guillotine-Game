public class CardDeck extends LinkedList{

  private LinkedList<Card> cards = new LinkedList<Card>();
  public CardDeck(LinkedList<Card> cards){
    this.cards = cards;
    cards.addToFront(new Card("King Louis XVI", 5, "Royal"));
    cards.addToFront(new Card("King Louis XVI", 5, "Royal"));
    cards.addToFront(new Card("Marie Antoinette", 5, "Royal"));
    cards.addToFront(new Card("Regent", 4, "Royal"));
    cards.addToFront(new Card("Duke", 3, "Royal"));
    cards.addToFront(new Card("Baron", 3, "Royal"));
    cards.addToFront(new Card("Count", 2, "Royal"));
    cards.addToFront(new Card("Countess", 2, "Royal"));
    cards.addToFront(new Card("Lord", 2, "Royal"));
    cards.addToFront(new Card("Lady", 2, "Royal"));
    cards.addToFront(new Card("Cardinal", 5, "Church"));
    cards.addToFront(new Card("Archbishop", 4, "Church"));
    cards.addToFront(new Card("Nun", 3, "Church"));
    cards.addToFront(new Card("Bishop", 2, "Church"));
    cards.addToFront(new Card("Priest", 1, "Church"));
    cards.addToFront(new Card("Priest", 1, "Church"));
    cards.addToFront(new Card("Heretic", 0, "Church"));
    cards.addToFront(new Card("Governor", 4, "Civic"));
    cards.addToFront(new Card("Mayor", 3, "Civic"));
    cards.addToFront(new Card("Councilman", 3, "Civic"));
    cards.addToFront(new Card("Judge", 2, "Civic"));
    cards.addToFront(new Card("Judge", 2, "Civic"));
    cards.addToFront(new Card("Tax Collector", 0, "Civic"));
    cards.addToFront(new Card("Sheriff", 1, "Civic"));
    cards.addToFront(new Card("Sheriff", 1, "Civic"));
    cards.addToFront(new Card("Palace Guard", 0, "Military"));                      
    cards.addToFront(new Card("Palace Guard", 0, "Military")); 
    cards.addToFront(new Card("Palace Guard", 0, "Military"));
    cards.addToFront(new Card("Palace Guard", 0, "Military"));
    cards.addToFront(new Card("Palace Guard", 0, "Military"));
    cards.addToFront(new Card("General", 4, "Military"));
    cards.addToFront(new Card("Colonel", 3, "Military"));
    cards.addToFront(new Card("Captain", 2, "Military"));
    cards.addToFront(new Card("Lieutenant", 1, "Military"));
    cards.addToFront(new Card("Lieutenant", 1, "Military"));
    cards.addToFront(new Card("Tragic Figure", -1, "Commoner"));
    cards.addToFront(new Card("Heroic Figure", -3, "Commoner"));
    cards.addToFront(new Card("Student", -1, "Commoner"));
    cards.addToFront(new Card("Student", -1, "Commoner"));
    cards.addToFront(new Card("Student", -1, "Commoner"));
    cards.addToFront(new Card("Student", -1, "Commoner"));
    
    cards.shuffle();
  }  
}