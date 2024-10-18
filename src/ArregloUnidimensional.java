import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ArregloUnidimensional {
    static JFrame frame;
    static JPanel panelPadre, firstSonPanel, panelTitle;
    static JTextField txtAddNum, txtPosition;
    static JButton btnAddData;
    static JLabel lblTitle;

    public static void main(String[] args) {
        inicializarJFrame();
        inicializarComponentes();
        inicializarPanelPadre();
        inicializarPanelTitle();
        inicializarFirstSonPanelAddData();
        addComponentsToPanelTitle();
        addComponentsToFirstSonPanel();
        addPanelsToPanelPadre();
        addPanelPadreToFrame();
        frame.setVisible(true);
    }

    private static void addComponentsToPanelTitle() {
        panelTitle.add(lblTitle);
    }

    private static void inicializarPanelTitle() {
        panelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    }

    private static void addComponentsToFirstSonPanel() {
        firstSonPanel.add(txtAddNum);
        firstSonPanel.add(txtPosition);
    }

    private static void addPanelsToPanelPadre() {
        panelPadre.add(panelTitle);
        panelPadre.add(firstSonPanel);
    }

    private static void inicializarFirstSonPanelAddData() {
        firstSonPanel = new JPanel(new GridLayout(1, 2));
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Dato y Posición");
        firstSonPanel.setBorder(titledBorder);
    }

    private static void addPanelPadreToFrame() {
        frame.getContentPane().add(panelPadre);
    }

    private static void inicializarPanelPadre() {
        panelPadre = new JPanel();
        panelPadre.setLayout(new BoxLayout(panelPadre, BoxLayout.Y_AXIS));
    }

    private static void inicializarComponentes() {
        lblTitle = new JLabel("Actividad 1");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFocusable(true);
        txtAddNum = new JTextField();
        crearJTextField("Digita el dato", txtAddNum);
        txtPosition = new JTextField();
        crearJTextField("Digita el posicion", txtPosition);
        btnAddData = new JButton("Agregar Dato");
    }

    private static void crearJTextField (String placeHolder, JTextField txtField) {
        txtField.setText(placeHolder);
        txtField.setHorizontalAlignment(SwingConstants.CENTER);
        txtField.setForeground(Color.GRAY);
        txtField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (txtField.getText().equals(placeHolder)) {
                    txtField.setText("");
                    txtField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (txtField.getText().isEmpty()) {
                    txtField.setForeground(Color.GRAY);
                    txtField.setText(placeHolder);
                }
            }
        });
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
