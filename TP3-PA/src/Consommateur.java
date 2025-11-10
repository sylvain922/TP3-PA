public class Consommateur extends Thread {
    private final BAL bal;

    public Consommateur(BAL bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        try {
            String lettre = bal.retirer();
            while (!lettre.equals("*")) {
                System.out.println("Consommateur affiche : " + lettre);
                Thread.sleep(700);

                lettre = bal.retirer(); // Retirer la lettre suivante
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
