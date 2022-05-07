import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Burger extends JFrame {


    private JPanel pnl;
    private JMenuBar MenuBar;
    private JMenu MenuPrincipalBurger;
    private JCheckBoxMenuItem dobleOpcional;
    private JCheckBoxMenuItem quesoOpcional;
    private JCheckBoxMenuItem patatasOpcional;
    private JMenu MenuSalsas;
    private JMenu MenuCarne;
    private JMenu MenuPan;
    private JMenu MenuPatatas;
    private JMenu MenuBebidas;
    private JMenu MenuExtras;
    private JRadioButtonMenuItem pollo;
    private JRadioButtonMenuItem cerdo;
    private JRadioButtonMenuItem ternera;
    private JRadioButtonMenuItem vegana;
    private JRadioButtonMenuItem normal;
    private JRadioButtonMenuItem integral;
    private JRadioButtonMenuItem centeno;
    private JRadioButtonMenuItem fritas;
    private JRadioButtonMenuItem gajo;
    private JRadioButtonMenuItem caseras;
    private JRadioButtonMenuItem cola;
    private JRadioButtonMenuItem naranja;
    private JRadioButtonMenuItem limon;
    private JRadioButtonMenuItem agua;
    private JRadioButtonMenuItem cerveza;
    private JMenu MenuReparto;
    private JRadioButtonMenuItem repartoDomicilio;
    private JRadioButtonMenuItem recogidaLocal;
    private JButton btnPedido;
    private JLabel logo;
    private JLabel labelPrecioPedido;
    private JLabel labelKetchup;
    private JSpinner spinnerKetchup;
    private JSpinner spinnerBarbacoa;
    private JSpinner spinnerMostaza;
    private JSpinner spinnerThai;
    private JLabel labelBarbacoa;
    private JLabel labelMostaza;
    private JLabel labelThai;
    private JTextArea textAreaInfoPedido;

    public Burger(String title) {
        super(title);
        pnl.setPreferredSize(new Dimension(800, 700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnl);
        this.pack();



        btnPedido.addActionListener(new ActionListener() {
            @Override
            //esto pasa cuando le damos al boton
            public void actionPerformed(ActionEvent e) {
                try {
                    double precioTotal = 8;//el menu basico vale 8 euros

                    //si elige las opciones con coste extra se le anade esto al precioTotal
                    if (ternera.isSelected())
                        precioTotal = precioTotal + 1;
                    if (vegana.isSelected())
                        precioTotal = precioTotal + 1;
                    if (caseras.isSelected())
                        precioTotal = precioTotal + 1;
                    if (dobleOpcional.isSelected())
                        precioTotal = precioTotal + 2;
                    if (quesoOpcional.isSelected())
                        precioTotal = precioTotal + 0.5;
                    if (patatasOpcional.isSelected())
                        precioTotal = precioTotal + 1;

                    //si ha elegido salsas, contamos cuantas y anadimos al precioTotal
                    int cuantosDeKetchup = (int) spinnerKetchup.getValue();
                    if (cuantosDeKetchup > 0)
                        precioTotal = precioTotal + 0.5 * cuantosDeKetchup;
                    int cuantosDeBarbacoa = (int) spinnerBarbacoa.getValue();
                    if (cuantosDeBarbacoa > 0)
                        precioTotal = precioTotal + 0.5 * cuantosDeBarbacoa;
                    int cuantosDeMostaza = (int) spinnerMostaza.getValue();
                    if (cuantosDeMostaza > 0)
                        precioTotal = precioTotal + 0.5 * cuantosDeMostaza;
                    int cuantosDeThai = (int) spinnerThai.getValue();
                    if (cuantosDeThai > 0)
                        precioTotal = precioTotal + 0.5 * cuantosDeThai;

                    //si recoge el pedido en el local le restamos un 20%
                    if (recogidaLocal.isSelected())
                        precioTotal = precioTotal - 0.2 * precioTotal;

                    //calculamos el precio con IVA
                    double IVA = 0.21 * precioTotal;
                    double precioConIVA = precioTotal + IVA;

                    //si elige cerveza comprobamos que es mayor de edad
                    if (cerveza.isSelected()) {
                        JOptionPane.showConfirmDialog(pnl,
                                "PROHIBIDA LA VENTA DE BEBIDAS ALCOHÓLICAS A MENORES DE 18 AÑOS! ERES MAYOR DE EDAD?", // Texto del mensaje
                                "Confirma tu edad", // Título
                                JOptionPane.YES_NO_OPTION);
                    }

                    //imprimimos la informacion de pedido con todos los precios
                    textAreaInfoPedido.setText("Precio Menu: €" + String.valueOf(precioTotal) + "\nOpciones elegidas: " + "\nIVA: €" + String.valueOf(IVA) + "\nPrecio Final(IVA incluido): €" + String.valueOf(precioConIVA));

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new Burger("Welcome to BurgerKing");
        frame.setVisible(true);
    }
}

