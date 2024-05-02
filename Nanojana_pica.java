import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Pica {
    private String izmers;
    private String toppings;
    private String merce;
    private boolean piegade;

    private static final double MAZA_CENA = 8.99;
    private static final double VIDĒJA_CENA = 10.99;
    private static final double LIELA_CENA = 12.99;

    public Pica(String izmers, String toppings, String merce, boolean piegade) {
        this.izmers = izmers;
        this.toppings = toppings;
        this.merce = merce;
        this.piegade = piegade;
    }

    public double aprekinatCenu() {
        double kopsumma = 0;

        switch (izmers) {
            case "Mazā":
                kopsumma += MAZA_CENA;
                break;
            case "Vidējā":
                kopsumma += VIDĒJA_CENA;
                break;
            case "Liela":
                kopsumma += LIELA_CENA;
                break;
        }

        return kopsumma;
    }

    @Override
    public String toString() {
        String piegadesVeids = piegade ? "Piegāde" : "Aptieka";
        return "Picas izmērs: " + izmers +
                "\nToppings: " + toppings +
                "\nMērce: " + merce +
                "\nPiegāde: " + piegadesVeids;
    }
}

public class Nanojana_pica {
    public static void main(String[] args) {
        String vards = JOptionPane.showInputDialog(null, "Ievadiet savu vārdu:");
        String adrese = JOptionPane.showInputDialog(null, "Ievadiet savu adresi:");
        String telefonaNumurs = JOptionPane.showInputDialog(null, "Ievadiet savu telefona numuru:");

        String[] izmēri = {"Mazā", "Vidējā", "Liela"};
        String izmers = (String) JOptionPane.showInputDialog(null, "Izvēlieties pīcas izmēru:",
                "Pīcas izmērs", JOptionPane.PLAIN_MESSAGE, null, izmēri, izmēri[0]);

        String[] toppings = {"Siers", "Pepperoni", "Sēnes", "Sīpoli"};
        String topping = (String) JOptionPane.showInputDialog(null, "Izvēlieties pīcas toppings:",
                "Pīcas toppings", JOptionPane.PLAIN_MESSAGE, null, toppings, toppings[0]);

        String[] mērces = {"Marināde", "Barbecue", "Ķiploku"};
        String merce = (String) JOptionPane.showInputDialog(null, "Izvēlieties pīcas mērci:",
                "Pīcas mērce", JOptionPane.PLAIN_MESSAGE, null, mērces, mērces[0]);

        int piegadesIzvele = JOptionPane.showConfirmDialog(null,
                "Vai vēlaties piegādi?", "Piegāde",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        boolean piegade = piegadesIzvele == JOptionPane.YES_OPTION;

        Pica pica = new Pica(izmers, topping, merce, piegade);

        double kopsumma = pica.aprekinatCenu();

        JOptionPane.showMessageDialog(null,
                "Klienta informācija:\n" +
                        "Vārds: " + vards + "\n" +
                        "Adrese: " + adrese + "\n" +
                        "Telefona numurs: " + telefonaNumurs + "\n\n" +
                        pica.toString() + "\n\n" +
                        "Kopējā cena: $" + String.format("%.2f", kopsumma),
                "Pīcas pasūtījums", JOptionPane.INFORMATION_MESSAGE);

        saglabatPasutijumuFaila(vards, adrese, telefonaNumurs, pica.toString(), kopsumma);
    }

    private static void saglabatPasutijumuFaila(String vards, String adrese, String telefonaNumurs, String picaInfo, double kopsumma) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("order.txt", true))) {
            writer.println("Klienta informācija:");
            writer.println("Vārds: " + vards);
            writer.println("Adrese: " + adrese);
            writer.println("Telefona numurs: " + telefonaNumurs);
            writer.println("Pasūtījums:");
            writer.println(picaInfo);
            writer.println("Kopējā cena: $" + String.format("%.2f", kopsumma));
            writer.println("-------------------------------------");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda, nevarēja saglabāt pasūtījumu failā.", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
    }
}
