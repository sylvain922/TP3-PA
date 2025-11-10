public class Producteur extends Thread {
    private final BAL bal;

    public Producteur(BAL bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        try {
            for (char lettre = 'A'; lettre <= 'Z'; lettre++) {
                String lettreStr = String.valueOf(lettre);
                bal.deposer(lettreStr);
                Thread.sleep(500);
            }
            bal.deposer("*");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
