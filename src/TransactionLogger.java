import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private List<String> historique = new ArrayList<>();

    public TransactionLogger() {
        this.log("TransactionLogger initialisé");
    }

    private String prefixeLog(String value) {
        StringBuilder resultat = new StringBuilder();

        resultat.append("Transaction n°");
        resultat.append(this.historique.size());
        resultat.append(" => ");
        resultat.append(value);

        return resultat.toString();
    }

    public void log(String value) {
        String logFormate = this.prefixeLog(value);
        this.historique.add(logFormate);
        System.out.println(logFormate);
    }

    public void getHistorique() {
        System.out.println();
        this.historique.forEach(System.out::println);
    }
}
