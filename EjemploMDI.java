import javax.swing.*;

public class EjemploMDI extends JFrame {

    private JDesktopPane escritorio;

    public EjemploMDI() {
        setTitle("Ejemplo de MDI con JInternalFrame");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear el escritorio (contenedor de ventanas internas)
        escritorio = new JDesktopPane();
        setContentPane(escritorio);

        // Crear una barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Ventanas");
        JMenuItem nuevaVentana = new JMenuItem("Nueva ventana");

        // Acción al hacer clic en "Nueva ventana"
        nuevaVentana.addActionListener(e -> crearVentanaInterna());

        menu.add(nuevaVentana);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void crearVentanaInterna() {
        JInternalFrame ventanaInterna = new JInternalFrame(
            "Documento " + (escritorio.getAllFrames().length + 1),
            true,  // resizable
            true,  // closable
            true,  // maximizable
            true   // iconifiable
        );

        ventanaInterna.setSize(300, 200);
        ventanaInterna.setVisible(true);

        // Agregar la ventana interna al escritorio
        escritorio.add(ventanaInterna);
        try {
            ventanaInterna.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EjemploMDI().setVisible(true);
        });
    }
}
