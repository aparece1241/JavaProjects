public class Card {
    private String rank;
    private String suit;

    Card(String rank, String suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public String getCard()
    {
        return this.rank + this.suit;
    }
    
}
