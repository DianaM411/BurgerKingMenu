import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        pnl.setPreferredSize(new Dimension(1200, 700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnl);
        this.pack();

        //ponemos el minimo value de 0 en los spinners
        spinnerKetchup.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        spinnerBarbacoa.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        spinnerMostaza.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        spinnerThai.setModel(new SpinnerNumberModel(0, 0, 10, 1));

        btnPedido.addActionListener(new ActionListener() {
            @Override
            //esto pasa cuando le damos al boton
            public void actionPerformed(ActionEvent e) {
                try {
                    final double MENUBASE=8;//el menu basico vale 8 euros
                    double precioTotal = MENUBASE;
                    ArrayList opcionesElegidas = new ArrayList<>();

                    //si elige las opciones con coste extra se le anade esto al precioTotal
                    if (ternera.isSelected()) {
                        precioTotal = precioTotal + 1;
                        opcionesElegidas.add("ternera");
                    }
                    if (vegana.isSelected()){
                        precioTotal = precioTotal + 1;
                        opcionesElegidas.add("vegana");
                    }
                    if (caseras.isSelected()){
                        precioTotal = precioTotal + 1;
                        opcionesElegidas.add("patatas caseras");
                    }
                    if (dobleOpcional.isSelected()){
                        precioTotal = precioTotal + 2;
                        opcionesElegidas.add("hamburgesa doble");
                    }
                    if (quesoOpcional.isSelected()){
                        precioTotal = precioTotal + 0.5;
                        opcionesElegidas.add("extra queso");
                    }
                    if (patatasOpcional.isSelected()){
                        precioTotal = precioTotal + 1;
                        opcionesElegidas.add("extra patatas");
                    }

                    //si ha elegido salsas, contamos cuantas y anadimos al precioTotal
                    int cuantosDeKetchup = (int) spinnerKetchup.getValue();
                    if (cuantosDeKetchup > 0){
                        opcionesElegidas.add("ketchup");
                        precioTotal = precioTotal + 0.5 * cuantosDeKetchup;
                    }

                    int cuantosDeBarbacoa = (int) spinnerBarbacoa.getValue();
                    if (cuantosDeBarbacoa > 0){
                        opcionesElegidas.add("salsa barbacoa");
                        precioTotal = precioTotal + 0.5 * cuantosDeBarbacoa;
                    }

                    int cuantosDeMostaza = (int) spinnerMostaza.getValue();
                    if (cuantosDeMostaza > 0){
                        opcionesElegidas.add("mostaza");
                        precioTotal = precioTotal + 0.5 * cuantosDeMostaza;
                    }

                    int cuantosDeThai = (int) spinnerThai.getValue();
                    if (cuantosDeThai > 0){
                        opcionesElegidas.add("salsa thai");
                        precioTotal = precioTotal + 0.5 * cuantosDeThai;
                    }


                    //si recoge el pedido en el local le restamos un 20%
                    if (recogidaLocal.isSelected()){
                        opcionesElegidas.add("recogida en el local");
                        precioTotal = precioTotal - 0.2 * precioTotal;
                    }


                    //calculamos el precio con IVA
                    final double IVA= 0.21;
                    double importeIVA = IVA * precioTotal;
                    double precioConIVA = precioTotal + importeIVA;

                    //si elige cerveza comprobamos que es mayor de edad
                    if (cerveza.isSelected()) {
                        opcionesElegidas.add("cerveza");
                        JOptionPane.showConfirmDialog(pnl,
                                "PROHIBIDA LA VENTA DE BEBIDAS ALCOHÓLICAS A MENORES DE 18 AÑOS! ERES MAYOR DE EDAD?", // Texto del mensaje
                                "Confirma tu edad", // Título
                                JOptionPane.YES_NO_OPTION);
                    }

                    //guardamos las opciones elegidas para imprimirlas mas tarde
                    if (pollo.isSelected())
                        opcionesElegidas.add("pollo");
                    if (cerdo.isSelected())
                        opcionesElegidas.add("cerdo");
                    if (normal.isSelected())
                        opcionesElegidas.add("pan normal");
                    if (integral.isSelected())
                        opcionesElegidas.add("pan integral");
                    if (centeno.isSelected())
                        opcionesElegidas.add("centeno");
                    if (cola.isSelected())
                        opcionesElegidas.add("cola");
                    if (fritas.isSelected())
                        opcionesElegidas.add("patatas fritas");
                    if (gajo.isSelected())
                        opcionesElegidas.add("patatas gajo");
                    if (naranja.isSelected())
                        opcionesElegidas.add("refresco naranja");
                    if (limon.isSelected())
                        opcionesElegidas.add("refresco limon");
                    if (agua.isSelected())
                        opcionesElegidas.add("agua");
                    if (repartoDomicilio.isSelected())
                        opcionesElegidas.add("reparto a domicilio");

                    String listaOpciones = String.join(", ", opcionesElegidas);//convert an ArrayList to a string

                    //imprimimos la informacion de pedido con todos los precios
                    textAreaInfoPedido.setText("Precio Menu: €" + String.valueOf(precioTotal) + "\nOpciones elegidas: " + listaOpciones+ "\nIVA: €" + String.valueOf(importeIVA) + "\nPrecio Final(IVA incluido): €" + String.valueOf(precioConIVA));

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

