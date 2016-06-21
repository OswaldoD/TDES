/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tdes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author usuario
 */
public class Visual extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Visual
     */
    public Visual() {
        super("Triple DES");
        setBounds(300,110,500,500);
        setResizable(false);
        initComponents();
        tdes = new TDES();
        tdes.setInputFile(txtArchivoEntrada.getText());
        tdes.setOutputFile(txtArchivoSalida.getText());
        tdes.setKey(txtLlave.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        container = new javax.swing.JPanel();
        txtLlave = new javax.swing.JTextField();
        lblLlave = new javax.swing.JLabel();
        lblArchivo = new javax.swing.JLabel();
        btnDesencriptar = new javax.swing.JButton();
        btnEncriptar = new javax.swing.JButton();
        rbtnHexa = new javax.swing.JRadioButton();
        txtArchivoEntrada = new javax.swing.JTextField();
        lblSalida = new javax.swing.JLabel();
        txtArchivoSalida = new javax.swing.JTextField();
        btnCambiar = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmILoad = new javax.swing.JMenuItem();
        jmISalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jmILlaveManual = new javax.swing.JMenuItem();
        jmIDesdeArchivo = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setBackground(java.awt.Color.white);
        container.setForeground(new java.awt.Color(254, 254, 254));
        container.setLayout(null);

        txtLlave.setForeground(new java.awt.Color(83, 83, 83));
        txtLlave.setText("Ninguna");
        txtLlave.setDisabledTextColor(new java.awt.Color(1, 1, 1));
        txtLlave.setEnabled(false);
        txtLlave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLlaveActionPerformed(evt);
            }
        });

        lblLlave.setText("Llave");

        lblArchivo.setText("Archivo Entrada");

        btnDesencriptar.setText("Desencriptar");
        btnDesencriptar.addActionListener(this);
        btnDesencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesencriptarActionPerformed(evt);
            }
        });

        btnEncriptar.setText("Encriptar");
        btnEncriptar.addActionListener(this);
        btnEncriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncriptarActionPerformed(evt);
            }
        });

        rbtnHexa.setText("hexadecimal");
        rbtnHexa.addActionListener(this);

        txtArchivoEntrada.setText("Ruta");
        txtArchivoEntrada.setDisabledTextColor(new java.awt.Color(10, 5, 0));
        txtArchivoEntrada.setEnabled(false);

        lblSalida.setText("Archivo Salida");

        txtArchivoSalida.setText("Ruta");
        txtArchivoSalida.setDisabledTextColor(new java.awt.Color(1, 1, 1));
        txtArchivoSalida.setEnabled(false);

        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(this);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArchivoEntrada)
                            .addComponent(txtLlave, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtArchivoSalida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnHexa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                                .addComponent(btnCambiar)
                                .addGap(10, 10, 10))))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArchivo)
                            .addComponent(lblLlave)
                            .addComponent(lblSalida))))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGap(0, 243, Short.MAX_VALUE)
                .addComponent(btnEncriptar)
                .addGap(65, 65, 65)
                .addComponent(btnDesencriptar)
                .addGap(179, 179, 179))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblLlave)
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLlave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnHexa))
                .addGap(55, 55, 55)
                .addComponent(lblArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArchivoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lblSalida)
                .addGap(3, 3, 3)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiar))
                .addGap(49, 49, 49)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEncriptar)
                    .addComponent(btnDesencriptar))
                .addGap(34, 34, 34))
        );

        jMenu1.setText("File");

        jmILoad.setText("Cargar Archivo");
        jmILoad.addActionListener(this);
        jMenu1.add(jmILoad);

        jmISalir.setText("Salir");
        jmISalir.addActionListener(this);
        jMenu1.add(jmISalir);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Llave");

        jMenu3.setText("Asignar Llave");

        jmILlaveManual.setText("Manual");
        jmILlaveManual.addActionListener(this);
        jMenu3.add(jmILlaveManual);

        jmIDesdeArchivo.setText("Desde Archivo");
        jmIDesdeArchivo.addActionListener(this);
        jMenu3.add(jmIDesdeArchivo);
        jmIDesdeArchivo.getAccessibleContext().setAccessibleName("");

        jMenu2.add(jMenu3);
        jMenu3.getAccessibleContext().setAccessibleName("asgLlave");

        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLlaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLlaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLlaveActionPerformed

    private void btnDesencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesencriptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesencriptarActionPerformed

    private void btnEncriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncriptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEncriptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visual().setVisible(true);
                
            }
        });
    }
    
    private void updateTextFields(){
        txtArchivoEntrada.setText(tdes.getInputFile());
        
        txtArchivoSalida.setText(tdes.getOutputFile());
        
        txtLlave.setText(tdes.getKey());
        
    }
    private int callTDES(String opcion){
        /**
         * 
         * ./tdes -e /home/phoenix/Documentos/file.txt -x -o /home/phoenix/Documentos/salida.txt
         * ./tdes -d /home/phoenix/Documentos/salida.txt -x -o /home/phoenix/Documentos/descripted.txt
         * 
         **/
        
      /*  if(tdes.getInputFile().equals("Ninguna") && 
           tdes.getInputFile().equals("Ninguna") &&
           tdes.getInputFile().equals("Ninguna")){
           */ 
      String tipo_llave = " ";
      if(rbtnHexa.isSelected()){
          tipo_llave = "-x";
      }
      else{
          tipo_llave = " ";
      }
      
      return tdes.pruebaConexion(opcion, tdes.getInputFile(), tipo_llave, tdes.getOutputFile(), tdes.getKey());
    }
    private void cleanInterface(){
        tdes = new TDES();
        
        tdes.setInputFile("Ruta");
        tdes.setOutputFile("Ruta");
        tdes.setKey("Ninguna");
        
        updateTextFields();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnDesencriptar;
    private javax.swing.JButton btnEncriptar;
    private javax.swing.JPanel container;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmIDesdeArchivo;
    private javax.swing.JMenuItem jmILlaveManual;
    private javax.swing.JMenuItem jmILoad;
    private javax.swing.JMenuItem jmISalir;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JLabel lblLlave;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JRadioButton rbtnHexa;
    private javax.swing.JTextField txtArchivoEntrada;
    private javax.swing.JTextField txtArchivoSalida;
    private javax.swing.JTextField txtLlave;
    // End of variables declaration//GEN-END:variables

    private TDES tdes;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jmISalir){
            dispose();
        }
        else if(e.getSource() == jmILoad){
            JFileChooser chooser = new JFileChooser();
          //  FileNameExtensionFilter filter = new FileNameExtensionFilter("file", "txt", "out");
          //  chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
           //     System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath());
            //    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                tdes.setInputFile(chooser.getSelectedFile().getAbsolutePath());
                updateTextFields();
            }
          
        }
        else if(e.getSource() == jmILlaveManual){
            String inputValue = JOptionPane.showInputDialog("Escriba un valor");
            System.out.println("Llave: " + inputValue);
            tdes.setKey(inputValue);
            updateTextFields();

        }
        else if(e.getSource() == jmIDesdeArchivo){
            JFileChooser chooser = new JFileChooser();
           // FileNameExtensionFilter filter = new FileNameExtensionFilter("file", "txt", "out", "key");
          //  chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);            
            if(returnVal == JFileChooser.APPROVE_OPTION) {
             //   System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath());
            //    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                FileManager file = new FileManager();
                String llave = file.loadFile(chooser.getSelectedFile().getAbsolutePath());
                System.out.println(llave);
                tdes.setKey(llave);
                updateTextFields();
            }
        }
        else if(e.getSource() == rbtnHexa){            
            //System.out.println("Hexa -x");
        }
        else if(e.getSource() == btnCambiar){
          ///  String inputValue = JOptionPane.showInputDialog("Escriba el nombre del archivo");
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showSaveDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION){
              //  System.out.println("Nombre: " + chooser.getSelectedFile().getAbsolutePath());
                tdes.setOutputFile(chooser.getSelectedFile().getAbsolutePath());
                updateTextFields();
            }
        }
        else if(e.getSource() == btnEncriptar){
            int u = JOptionPane.showConfirmDialog(this, "¿Desea encriptar el archivo?", "Confirmación de encriptación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
           // System.out.println("Y me trae esto: " + y);
           if(u == 0) {
               // Se acepta la encriptación
               System.out.println("Enviar parametros para encriptar");
               int y = callTDES("-e");
               if (y == 0) {
                   JOptionPane.showMessageDialog(this, "Encriptación Exitosa", "La encriptación ha concluido exitosamente", JOptionPane.INFORMATION_MESSAGE);
                   // Mensaje de exito
                   cleanInterface();
               } else {
                   // Mensaje de error
                   JOptionPane.showMessageDialog(this, "Encriptación fallida", "La encriptación no se ha podido completar, revise los parámetros ingresados e intente nuevamente", JOptionPane.ERROR_MESSAGE);
               }
           }
        }
        else if(e.getSource() == btnDesencriptar){
           int u = JOptionPane.showConfirmDialog(this, "¿Desea desencriptar el archivo?", "Confirmación de desencriptación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
           if(u == 0) {
               // Se acepta la desencriptación
               System.out.println("Enviar parametros para desencriptar " + u);
               int y = callTDES("d");
               // Se acepta la encriptación
               System.out.println("Enviar parametros para encriptar");
               if (y == 0) {
                   // Mensaje de exito
                   JOptionPane.showMessageDialog(this, "La desencriptación ha concluido exitosamente", "Desencriptación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                   cleanInterface();
               } else {
                   // Mensaje de error
                   JOptionPane.showMessageDialog(this, "La desencriptación no se ha podido completar, revise los parámetros ingresados e intente nuevamente", "Desencriptación fallida", JOptionPane.ERROR_MESSAGE);
               }
           }
        }
    }
}
