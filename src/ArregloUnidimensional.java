import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ArregloUnidimensional {
    static JFrame frame;
    static JPanel panelPadre, firstSonPanel, panelTitle, secondSonPanelButtons, thirdSonPanelResult;
    static JTextField txtAddNum, txtPosition;
    static JButton btnAddData, btnDeleteData, btnClearArray, btnShowArray, btnCalculateAverage;
    static JLabel lblTitle, lblResult;

    public static void main(String[] args) {
        inicializarJFrame();
        inicializarComponentes();
        inicializarPanelPadre();
        inicializarPanelTitle();
        inicializarFirstSonPanelAddData();
        inicializarSecondSonPanelButtons();
        inicilizarThirdSonPanelResult();
        addComponentsToPanelTitle();
        addComponentsToFirstSonPanel();
        addComponentsToSecondSonPanelButtons();
        addComponentsToThirdSonPanelResult();
        addPanelsToPanelPadre();
        addPanelPadreToFrame();
        frame.setVisible(true);
    }

    private static void addComponentsToThirdSonPanelResult() {
        thirdSonPanelResult.add(lblResult);
    }

    private static void inicilizarThirdSonPanelResult() {
        thirdSonPanelResult = new JPanel(new GridLayout(0, 1));
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), " Resultado");
        titledBorder.setTitleColor(Color.GRAY);
        CompoundBorder innerBorder = new CompoundBorder(titledBorder, BorderFactory.createEmptyBorder(5, 5, 5, 5));
        thirdSonPanelResult.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), innerBorder));
    }

    private static void addComponentsToSecondSonPanelButtons() {
        secondSonPanelButtons.add(btnAddData);
        secondSonPanelButtons.add(btnDeleteData);
        secondSonPanelButtons.add(btnClearArray);
        secondSonPanelButtons.add(btnShowArray);
        secondSonPanelButtons.add(btnCalculateAverage);
    }

    private static void inicializarSecondSonPanelButtons() {
        GridLayout gridLayout = new GridLayout(0, 1);
        gridLayout.setVgap(4);
        secondSonPanelButtons = new JPanel(gridLayout);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Acciones");
        titledBorder.setTitleColor(Color.GRAY);
        CompoundBorder innerBorder = new CompoundBorder(titledBorder, new EmptyBorder(5, 5, 5, 5));
        secondSonPanelButtons.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), innerBorder));
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
        panelPadre.add(secondSonPanelButtons);
        panelPadre.add(thirdSonPanelResult);
    }

    private static void inicializarFirstSonPanelAddData() {
        firstSonPanel = new JPanel(new GridLayout(1, 2));
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Dato y Posición");
        titledBorder.setTitleColor(Color.GRAY);
        CompoundBorder innerBorder = new CompoundBorder(titledBorder, new EmptyBorder(5, 5, 5, 5));
        firstSonPanel.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), innerBorder));
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
        btnDeleteData = new JButton("Eliminar Dato");
        btnClearArray = new JButton("Borrar datos del arreglo");
        btnShowArray = new JButton("Mostrar datos del arreglo");
        btnCalculateAverage = new JButton("Calcular promedio");
        lblResult = new JLabel(" ");
        lblResult.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
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
        frame.setSize(300, 356);
        //jFrameInterfaz.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Arreglo Unidimensional");
    }
}
