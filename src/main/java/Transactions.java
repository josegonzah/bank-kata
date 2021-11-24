import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transactions {
    private int balance = 0;
    private int deposit = 0;
    private int withdrawal = 0;
    private int transaction;
    private LocalDate date;

    public int getTransaction(){
        return transaction;
    }

    public int getBalance() {
        return balance;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getWithdrawal() {
        return withdrawal;
    }

    public LocalDate getDate(){
        return date;
    }

    public Transactions(int amount, LocalDate date, String operation, int balance){
        this.balance = balance;
        this.date = date;
        if(operation == "deposit"){
            this.deposit = amount;
            return;
        }
        if (operation == "withdraw"){
            this.withdrawal = amount;
            return;
        }
        if(operation == "transaction"){
            this.transaction = amount;
            return;
        }

    }

}
