import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ArregloUnidimensional {
    static JFrame frame;
    static JPanel panelPadre, firstSonPanel, panelTitle;
    static JTextField txtAddNum;
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
        firstSonPanel.add(btnAddData);
    }

    private static void addPanelsToPanelPadre() {
        panelPadre.add(panelTitle);
        panelPadre.add(firstSonPanel);
    }

    private static void inicializarFirstSonPanelAddData() {
        firstSonPanel = new JPanel(new GridLayout(1, 2));
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Agregar Dato");
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
        txtAddNum.setHorizontalAlignment(SwingConstants.CENTER);
        String placeHolder = "Digita el dato";
        txtAddNum.setText(placeHolder);
        txtAddNum.setForeground(Color.GRAY);
        txtAddNum.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (txtAddNum.getText().equals(placeHolder)) {
                    txtAddNum.setText("");
                    txtAddNum.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (txtAddNum.getText().isEmpty()) {
                    txtAddNum.setForeground(Color.GRAY);
                    txtAddNum.setText(placeHolder);
                }
            }
        });
        btnAddData = new JButton("Agregar Dato");
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
