import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {

    private int currentBalance = 0;
    private LocalDate currentDate = LocalDate.now();
    private ArrayList<Transactions> movements;
    private DateTimeFormatter formatter;
    private String historial = "";

    public void deposit(int amount, String date) {
        this.currentBalance += amount;
        movements.add(new Transactions(amount, convertDate(date), "deposit", currentBalance ));
    }

    public void withdraw(int amount, String date){
        this.currentBalance -= amount;
        movements.add(new Transactions(amount, convertDate(date), "withdraw", currentBalance ));
    }

    public void transfer(int amount, String date){
        this.currentBalance -= amount;
        movements.add(new Transactions(amount, currentDate, "transfer", currentBalance));
    }

    void printStatements() {
        movements.stream().filter(x->x.getTransaction()==0).sorted(Comparator.comparing(Transactions::getDate).reversed()).forEach(x->statements(x));

    }

    private LocalDate convertDate(String date){
        try {
            date=date.replace("/","-");
            this.currentDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (Exception e){
        }
        return this.currentDate;
    }

    private void statements(Transactions transactions){
        historial+=formatter.format(transactions.getDate())+"     "+transactions.getDeposit()+"     "+transactions.getWithdrawal()+"     "+transactions.getBalance()+"\n";
    }

}
