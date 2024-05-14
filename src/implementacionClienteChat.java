import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente, Runnable{
    public String nombre;
     chatServidor servidor;

    public implementacionClienteChat(String nombre, chatServidor servidor) throws Exception {
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }

    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        System.err.println(mensaje);
    }

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        String mensaje;

        while (true) {
            mensaje = s.nextLine();
            try {
                servidor.mensaje(nombre + ": " + mensaje);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
