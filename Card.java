/** 
 * a class to represent a card
 * @author Paige Erickson
 */
public class Card {

  /* name of the card */
  private String name;
 
  /* value of the card */
  private int value;
    
  /* group name of the card */
  private String group;
  
  /* constructor for a card */
  public Card(String name, int value, String group){
    this.name = name;
    this.value = value;
    this.group = group;
  }
  
  /**
   * gets name of card 
   */
  public String getName(){
    return this.name;
  }
  
  /**
   * gets value of card 
   */
  public int getValue(){
    return this.value;
  }
  
  /**
   * gets group name of card 
   * @return  
   */
  public String getGroup(){
    return this.group;
  }
  
  /**
   * gets String value of the card
   * @return a String that hold the name, group, and value of the card
   */
  @Override
  public String toString(){
    if(this.getValue() != 0)
      return this.getName() + ", " + this.getGroup() + ": " + this.getValue();
    else 
      return this.getName() + ", " + this.getGroup() + ": *";
  }
  
}