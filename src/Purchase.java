import java.time.LocalDate;

public class Purchase {
    private Customer purchaseCustomer;
    private Game purchaseGame;
    private LocalDate  purchaseDate;
    private int quantity;

    public Purchase(Customer purchaseCustomer, Game purchaseGame, LocalDate purchaseDate, int quantity) {
        this.purchaseCustomer = purchaseCustomer;
        this.purchaseGame = purchaseGame;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
    }

    public Customer getPurchaseCustomer() {
        return purchaseCustomer;
    }

    public void setPurchaseCustomer(Customer purchaseCustomer) {
        this.purchaseCustomer = purchaseCustomer;
    }

    public Game getPurchaseGame() {
        return purchaseGame;
    }

    public void setPurchaseGame(Game purchaseGame) {
        this.purchaseGame = purchaseGame;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
