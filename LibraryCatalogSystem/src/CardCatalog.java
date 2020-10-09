/**
 * @author aparece1241
 */
public class CardCatalog implements Comparable<CardCatalog>{
    private String cardId;
    private String bookTitle;
    private String bookAuthor;
    private String yearPublished;
    private String publisher;


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public int compareTo(CardCatalog o) {
        return this.getCardId().compareTo(o.getCardId());
    }
}
