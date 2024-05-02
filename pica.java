import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Pica {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Ievadiet savu vārdu:");
        String address = JOptionPane.showInputDialog(null, "Ievadiet savu adresi:");
        String phoneNumber = JOptionPane.showInputDialog(null, "Ievadiet savu telefona numuru:");
        String[] izmēri = {"Mazā", "Vidējā", "Liela"};
        String izmers = (String) JOptionPane.showInputDialog(null, "Izvēlieties pīcas izmēru:",
                "Pīcas izmērs", JOptionPane.PLAIN_MESSAGE, null, izmēri, izmēri[0]);

        String[] toppings = {"Siers", "Pepperoni", "Sēnes", "Sīpoli"};
        String topping = (String) JOptionPane.showInputDialog(null, "Izvēlieties pīcas toppings:",
                "Pīcas toppings", JOptionPane.PLAIN_MESSAGE, null, toppings, toppings[0]);

        String[] mērces = {"Marināde", "Barbecue", "Ķiploku"};
        String merce = (String) JOptionPane.showInputDialog(null, "Izvēlieties pīcas mērci:",
        "Pīcas mērce", JOptionPane.PLAIN_MESSAGE, null, mērces, mērces[0]);
    }
}