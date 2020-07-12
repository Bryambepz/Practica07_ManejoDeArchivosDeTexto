/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorArchivo;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author braya
 */
public class VentanaDesencriptar extends javax.swing.JInternalFrame {
    private ControladorArchivo ctrlArchivo;
    private VentanaEncriptar ventanaEncriptar;
    
    /**
     * Creates new form VentanaDesencriptar
     */
    public VentanaDesencriptar() {
        initComponents();
        ctrlArchivo = new ControladorArchivo(rutae());
        vacio();
    }
    
    public String rutae() {
        String r = "C/Users/braya/Documents";
        txtRutad.setText(r);
        return r;
    }
    
//    public String ruta(){
//        String ruta = "C/Users/braya/Documents";
//        txtRutad.setText(ruta);
//        return ruta;
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtATexto = new javax.swing.JTextArea();
        txtRutad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAEncrip = new javax.swing.JTextArea();
        btnDesencriptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnExaminar1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        txtATexto.setColumns(20);
        txtATexto.setRows(5);
        jScrollPane2.setViewportView(txtATexto);

        txtAEncrip.setEditable(false);
        txtAEncrip.setColumns(20);
        txtAEncrip.setRows(5);
        jScrollPane1.setViewportView(txtAEncrip);

        btnDesencriptar.setText("Desencriptar");
        btnDesencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesencriptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ruta");

        btnExaminar1.setText("Examinar");
        btnExaminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminar1ActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRutad, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExaminar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesencriptar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnExaminar1)
                    .addComponent(btnGuardar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnDesencriptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExaminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminar1ActionPerformed
        // TODO add your handling code here:
        vacio();
        JFileChooser file = new JFileChooser();
        int seleccion = file.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File rutaArchivo = file.getSelectedFile();
            if (rutaArchivo.exists() == false) {
                JOptionPane.showMessageDialog(this, "No existe ese archivo");
            } else {
                txtRutad.setText(rutaArchivo.getAbsolutePath());
                try (FileReader fr = new FileReader(rutaArchivo)) {
                    String texto = "";
                    int valor = fr.read();
                    while (valor != -1) {
                        texto = texto + (char) valor;
                        valor = fr.read();
                    }
                    this.txtAEncrip.setText(texto);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No selecciono ningun archivo");
        }
    }//GEN-LAST:event_btnExaminar1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (!txtATexto.getText().equals("")) {
            ctrlArchivo.guardarTextp(txtATexto.getText(), txtRutad.getText());
            JOptionPane.showMessageDialog(this, "Se ha guardado el texto desencriptado");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No hay nada para guardar");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDesencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesencriptarActionPerformed
        // TODO add your handling code here:
        if (!txtAEncrip.equals("")) {
            String textoDes = txtAEncrip.getText();
            String desencriptado = ctrlArchivo.desencriptar(textoDes);
            txtATexto.setText(desencriptado);
            ctrlArchivo.guardar(textoDes, txtRutad.getText());
//        btnDesencriptar.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "No hay texto encriptado");
        }
        
    }//GEN-LAST:event_btnDesencriptarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        vacio();
    }//GEN-LAST:event_formInternalFrameActivated
    
    public void vacio(){
        txtATexto.setText("");
        txtRutad.setText("C/Users/braya/Documents");
        txtAEncrip.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesencriptar;
    private javax.swing.JButton btnExaminar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAEncrip;
    private javax.swing.JTextArea txtATexto;
    private javax.swing.JTextField txtRutad;
    // End of variables declaration//GEN-END:variables
}