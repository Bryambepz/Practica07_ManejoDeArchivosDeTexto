/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorArchivo;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author braya
 */
public class VentanaEncriptar extends javax.swing.JInternalFrame {

    /**
     * Atributos de la clase
     */
    private ControladorArchivo controladorArchivo;

    public VentanaEncriptar(ControladorArchivo controladorArchivo) {
        initComponents();
	this.controladorArchivo = controladorArchivo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRuta = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtATexto = new javax.swing.JTextArea();
        btnEncriptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAEncrip = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtATexto.setColumns(20);
        txtATexto.setRows(5);
        jScrollPane1.setViewportView(txtATexto);

        btnEncriptar.setText("Encriptar");
        btnEncriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncriptarActionPerformed(evt);
            }
        });

        txtAEncrip.setEditable(false);
        txtAEncrip.setColumns(20);
        txtAEncrip.setRows(5);
        jScrollPane2.setViewportView(txtAEncrip);

        jLabel1.setText("Ruta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEncriptar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnGuardar)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnGuardar))
                        .addGap(150, 150, 150)
                        .addComponent(btnEncriptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre un JFileChooser para seleccionar un archivo en donde se guardará el texto encriptado.
     * Si no existe el archivo lo crea.
     * Si el archivo ya existe pregunta si desea sobreescribir
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        int seleccion = file.showSaveDialog(this);
        try {
	    if (seleccion == JFileChooser.APPROVE_OPTION) {
		File archivo = file.getSelectedFile();
		txtRuta.setText(archivo.getAbsolutePath());
		if(!archivo.exists()){
		    archivo.createNewFile();
		    btnEncriptarActionPerformed(evt);
		    controladorArchivo.guardar(txtATexto.getText(), archivo);
		}else{
		    int op = JOptionPane.showConfirmDialog(this, "El archivo ya existe, ¿Desea sobreescribirlo?");
		    if(op == JOptionPane.OK_OPTION){
			archivo.delete();
			archivo.createNewFile();
			btnEncriptarActionPerformed(evt);
			controladorArchivo.guardar(txtATexto.getText(), archivo);
		    }
		}
	    }
	} catch (IOException ex) {
	    JOptionPane.showMessageDialog(this, "Error al guardar el archivo");
	}
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * Desencripta el texto que está en el JTextArea
     */
    private void btnEncriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncriptarActionPerformed
        String texto = txtATexto.getText();
	texto = controladorArchivo.encriptar(texto);
	txtAEncrip.setText(texto);
    }//GEN-LAST:event_btnEncriptarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        vacio();
    }//GEN-LAST:event_formInternalFrameClosed

    /**
     * Limpia todos los campos con texto
     */
    public void vacio(){
	txtATexto.setText("");
	txtAEncrip.setText("");
	txtRuta.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncriptar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAEncrip;
    private javax.swing.JTextArea txtATexto;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
