import javax.swing.*;

public class ArregloUnidimensional {
    static JFrame frame;

    public static void main(String[] args) {
        inicializarJFrame();
        frame.setVisible(true);
    }

    private static void inicializarJFrame() {
        //creacion del JFrame
        frame = new JFrame();
        frame.setSize(300, 280);
        //jFrameInterfaz.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Arreglo Unidimensional");
    }
}
