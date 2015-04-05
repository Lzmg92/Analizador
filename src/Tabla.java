import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Leslie on 28/08/2014.
 */
public class Tabla extends JFrame {

    JFrame tabla = new JFrame();


    ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("fondo.jpg"));
    Image imagen = icono.getImage();
    ImageIcon ico = new ImageIcon(imagen.getScaledInstance(1010,610,Image.SCALE_SMOOTH));
    JLabel fondo = new JLabel(ico);

    int con = 0;
    Object [][] data;
    String[] Columnames = {"Carnet", "Nombre", "Semestre"};
    DefaultTableModel registros = new DefaultTableModel(data,Columnames);
    JTable registro = new JTable(registros);
    JScrollPane scrollp = new JScrollPane(registro);

    JButton ok = new JButton("Ok");

    public void MostrarDatos(Datos d){
        registros.insertRow(con, new Object[]{});
        registros.setValueAt(d.getCarnet(), con, 0);
        registros.setValueAt(d.getNombre(), con, 1);
        registros.setValueAt(d.getSemestre(),con, 2);

        con++;
    }

    public Tabla(){

        final Main m = new Main();

        tabla.setSize(600, 500);
        tabla.setLocationRelativeTo(this);
        tabla.setResizable(false);
        tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registro.setPreferredScrollableViewportSize(new Dimension(400, 50));
        tabla.getContentPane().add(scrollp,BorderLayout.CENTER);

       scrollp.setBounds(45, 25, 500, 400);

        ok.setBounds(450, 435, 100,25);
        fondo.setBounds(-20, -20, 1050,650 );

        tabla.add(ok);
        tabla.add(fondo);

        tabla.setLayout(null);
        tabla.setVisible(true);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabla.setVisible(false);
            }});

    }

}
