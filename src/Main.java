import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
           String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
           String nom = nombre;

           Registry rmii = LocateRegistry.getRegistry("localhost", 3000);

           chatServidor servidor = (chatServidor) rmii.lookup("Chat");
           new Thread(new implementacionClienteChat(nom, servidor)).start();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
