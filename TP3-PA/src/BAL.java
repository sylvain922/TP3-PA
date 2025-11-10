public class BAL {
    private final String[] tampon;
    private int tete;
    private int queue;
    private int nbLettres;

    public BAL(int taille) {
        tampon = new String[taille];
        tete = 0;
        queue = 0;
        nbLettres = 0;
    }

    public synchronized void deposer(String lettre) throws InterruptedException {
        while (nbLettres == tampon.length) {
            // Attente si le tampon est plein
            wait();
        }
        tampon[queue] = lettre; // Déposer la lettre à la position de la queue
        queue = (queue + 1) % tampon.length;
        nbLettres++;
        System.out.println("Lettre déposée : " + lettre);
        notifyAll();
    }

    public synchronized String retirer() throws InterruptedException {
        while (nbLettres == 0) {
            // Attente si le tampon est vide
            wait();
        }
        String lettre = tampon[tete]; // Retirer la lettre à la position de la tête
        tete = (tete + 1) % tampon.length;
        nbLettres--;
        System.out.println("Lettre retirée : " + lettre);
        if (lettre.equals("*")) {
            System.out.println("Consommateur affiche : *");
        }
        notifyAll();
        return lettre;
    }
}
