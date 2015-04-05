import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Leslie on 24/08/2014.
 */
public class ventana extends JFrame {

    JFrame analizador = new JFrame();

    ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("fondo.jpg"));
    Image imagen = icono.getImage();
    ImageIcon ico = new ImageIcon(imagen.getScaledInstance(1010,610,Image.SCALE_SMOOTH));
    JLabel fondo = new JLabel(ico);

    JLabel archxml = new JLabel("Archivo XML");
    JTextArea txtoxml =  new JTextArea();
    JScrollPane scroll = new JScrollPane(txtoxml);
    JTextArea txtresultados = new JTextArea();
    JScrollPane Scrollresul = new JScrollPane(txtresultados);
    JButton analizar = new JButton("Analizar");
    JLabel opciones = new JLabel("Opciones Manuales");
    JButton buscar = new JButton("Buscar Archivo");

    JLabel nombre = new JLabel("Nombre");
    JLabel carnet = new JLabel("Carnet");
    JLabel semestre= new JLabel("Semestre");

    JTextField txtnombre = new JTextField();
    JTextField txtcarnet = new JTextField();
    JTextField txtsemestre = new JTextField();

    JButton agregar = new JButton("Agregar Registro");
    JButton modificar = new JButton("Modificar Registro");
    JButton eliminar = new JButton("Eliminar Registro");
    JButton lista = new JButton("Mostrar Lista");

    JFileChooser fc = new JFileChooser();
    String cadena;




    public String leer(String nombre){

        try{File f;
            FileReader lectorArchivo;

            f = new File(nombre);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);

            String l="";
            String aux="";

            while(true)
            {   aux=br.readLine();
                if(aux!=null)  l=l+aux+"\n";
                else break;}

            br.close();
            lectorArchivo.close();
            return l;

        }catch(IOException e){
            System.out.println("Error:"+e.getMessage());}
        return null;}




    public String leerstring(String nombre){
        try{File f;
            FileReader lectorArchivo;

            f = new File(nombre);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);

            String l="";
            String aux="";

            while(true)
            {aux=br.readLine();
                if(aux!=null)  l=l+aux+"";
                else  break;}

            br.close();
            lectorArchivo.close();
            return l;

        }catch(IOException e){
            System.out.println("Error:"+e.getMessage()); }
        return null;
    }



        public ventana (){

            final Main m = new Main();

            analizador.setSize(700, 600);
            analizador.setLocationRelativeTo(this);
            analizador.setResizable(false);
            analizador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            archxml.setForeground(Color.white);
            archxml.setFont(new Font("Maiandra GD", Font.BOLD, 18));
            archxml.setBounds(35,20,200,20);

            txtoxml.setBounds(25,55,330, 460);
            scroll.setBounds(new Rectangle(25,55,330, 460));

            txtresultados.setBounds(25, 55, 330, 460);
            Scrollresul.setBounds(new Rectangle(400, 280, 250, 260));

            analizar.setBounds(235, 525, 100,20);
            buscar.setBounds(30, 525, 200, 20);
            opciones.setForeground(Color.white);
            opciones.setFont(new Font("Maiandra GD", Font.BOLD, 18));
            opciones.setBounds(410, 25, 200,20);
            carnet.setForeground(Color.white);
            carnet.setFont(new Font("Maiandra GD", Font.ITALIC, 15));
            carnet.setBounds(400, 55, 100, 20);
            txtcarnet.setBounds(500, 55, 150, 20);
            nombre.setForeground(Color.white);
            nombre.setFont(new Font("Maiandra GD", Font.ITALIC, 15));
            nombre.setBounds(400, 90, 100, 20);
            txtnombre.setBounds(500, 90, 150,20);
            semestre.setForeground(Color.white);
            semestre.setFont(new Font("Maiandra GD", Font.ITALIC, 15));
            semestre.setBounds(400, 120, 100, 20);
            txtsemestre.setBounds(500, 120, 150, 20);
            modificar.setBounds(400, 165, 200,20);
            agregar.setBounds(400, 190, 200, 20);
            eliminar.setBounds(400, 215, 200, 20);
            lista.setBounds(400, 240, 200, 20);

            fondo.setBounds(-20, -20, 1050,650 );


            analizador.add(archxml);
            analizador.getContentPane().add(scroll,BorderLayout.CENTER);
            analizador.getContentPane().add(Scrollresul,BorderLayout.CENTER);
            analizador.add(opciones);
            analizador.add(carnet);
            analizador.add(txtcarnet);
            analizador.add(nombre);
            analizador.add(txtnombre);
            analizador.add(semestre);
            analizador.add(txtsemestre);
            analizador.add(agregar);
            analizador.add(modificar);
            analizador.add(eliminar);
            analizador.add(analizar);
            analizador.add(buscar);
            analizador.add(lista);
            analizador.add(fondo);

            analizador.setLayout(null);
            analizador.setVisible(true);


            agregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (txtnombre.getText().equals("") || txtcarnet.getText().equals("") || txtsemestre.getText().equals("")) {
                        JOptionPane.showMessageDialog(analizador, "No todos los campos estan llenos", "Error", JOptionPane.ERROR_MESSAGE);


                    } else {
                        String nombre = txtnombre.getText();
                        int carnet = Integer.parseInt(txtcarnet.getText());
                        int semestre = Integer.parseInt(txtsemestre.getText());

                        m.Listadatos.addregistro(carnet, nombre, semestre);

                        txtnombre.setText("");
                        txtcarnet.setText("");
                        txtsemestre.setText("");
                    }}}
                );

            eliminar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (txtcarnet.getText().equals("")) {
                        JOptionPane.showMessageDialog(analizador, "El campo -carnet- está vacio", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {
                        int carnetPE = Integer.parseInt(txtcarnet.getText());
                        int ta = m.Listadatos.tamañolista();
                        for(int i=0; i< ta;i++){
                           if (carnetPE == m.Listadatos.obtener(i).carnet){
                               m.Listadatos.eliminar(i);
                           };     }

                        txtcarnet.setText("");
                       }

                }});

            modificar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (txtcarnet.getText().equals("")) {
                        JOptionPane.showMessageDialog(analizador, "El campo -carnet- está vacio", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {
                        int carnetPM = Integer.parseInt(txtcarnet.getText());
                        int ta = m.Listadatos.tamañolista();

                        for(int i=0; i< ta;i++){

                            if (carnetPM == m.Listadatos.obtener(i).carnet){
                                if (txtnombre.getText().equals("")){}
                                else{m.Listadatos.obtener(i).setNombre(txtnombre.getText());}

                                if(txtsemestre.getText().equals("")){}
                                else{m.Listadatos.obtener(i).setSemestre(Integer.parseInt(txtsemestre.getText()));}
                            }}
                        txtnombre.setText("");
                        txtcarnet.setText("");
                        txtsemestre.setText("");
                    }

                }});

            buscar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fc.showSaveDialog(fc);
                    int rest = fc.APPROVE_OPTION;
                    if(rest==JFileChooser.APPROVE_OPTION)
                    {String b=fc.getSelectedFile().toString();
                    txtoxml.setText(leer(b));
                    cadena = leerstring(b);}
                }});


            analizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    txtresultados.setText(analizadorle(cadena));
                }});

            lista.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Tabla n = new Tabla();
                    int ta = m.Listadatos.tamañolista();
                    for (int i = 0; i < ta; i++) {
                        n.MostrarDatos(m.Listadatos.obtener(i));
                    }}});
        }



    public String analizadorle(String cad){
        char [] arreglo = cad.toCharArray();
        String[] palabrasres;
        String tempest1 = "";
        String tempest2 = "";
        String tempest3 = "";

        int estadoactual = 0;
        int estadoaccion = 0;
        String resultado = "";
        int i = 0;

       while( i< arreglo.length){

            if(estadoactual==0) {

                if (arreglo[i] == '<') {
                    estadoactual = 11;
                    tempest1 =  "<";
                    i++;
                } else if (Character.isDigit(arreglo[i])) {
                    estadoactual = 12;
                    tempest2 = Character.toString(arreglo[i]);
                    i++;
                } else if (Character.isLetter(arreglo[i])) {
                    estadoactual = 13;
                    tempest3 = Character.toString(arreglo[i]);
                    i++;}
                else{
                    estadoactual = 14;
                    i++;}
            }

            else if(estadoactual ==14){
                resultado = resultado + "\nNo_pertenece";
                estadoactual=0;
            }
            else if(estadoactual == 11){
                    if (Character.isLetter(arreglo[i])||arreglo[i]=='/'){
                        estadoactual = 11;
                        tempest1 = tempest1 + Character.toString(arreglo[i]);
                        i++;
                    }
                    else if (arreglo[i]=='>')
                    {estadoactual = 21;
                    tempest1 = tempest1 + Character.toString(arreglo[i]);
                    i++;}
                    else{
                    resultado = resultado + "\nNo_pertenece";
                        estadoactual = 0;
                        i++;
                    }}

            else if (estadoactual==21){
                        resultado = resultado + "\n Token_Abrir||Cerrar";
                //////////////////////////////////////// condicion abre o cierre

                            estadoactual = 0;
                            tempest1 = "";
                    }

            else if (estadoactual==12){

                    if(Character.isDigit(arreglo[i])){
                        estadoactual=12;
                        tempest2 = tempest2 + Character.toString(arreglo[i]);
                        i++;
                    } else {
                        estadoactual = 22;
                        tempest2 = tempest2 + Character.toString(arreglo[i]);
                    }}

            else if(estadoactual == 22){
                   resultado = resultado + "\n Token_digito";

                /////////////////////////////////////////////////// condiciones digito

                    estadoactual = 0;
                    tempest2 = "";
                    }

            else if(estadoactual == 13){

                    if(Character.isLetter(arreglo[i])||arreglo[i]==' '){
                        estadoactual = 13;
                        tempest3 = tempest3 + Character.toString(arreglo[i]);
                        i++;
                    } else {
                        estadoactual = 23;
                        tempest3 = tempest3 + Character.toString(arreglo[i]);
                    }}

            else if(estadoactual == 23){
                resultado = resultado + "\n Token_palabra";

                /////////////////////////////////////////////// condiciones palabra

                estadoactual = 0;
                tempest3 = "";}
            }
        ///////////////////// termina while
        return resultado;

        }


}




