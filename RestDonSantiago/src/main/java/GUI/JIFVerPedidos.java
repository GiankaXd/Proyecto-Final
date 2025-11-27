
package GUI;
import accesoDatos.BaseDatosPedidos;
import accesoDatos.BaseDatosRegistro;
import entidades.Pedido;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel; 
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;

/**
 *
 * @author Lenovo
 */
    
public class JIFVerPedidos extends javax.swing.JInternalFrame {
    //atributos para enlazar las clases

    private BaseDatosPedidos bdP;
    private BaseDatosRegistro bd;
    private DefaultTableModel modeloTabla;
    
    public JIFVerPedidos(BaseDatosPedidos bdP, BaseDatosRegistro bd) {
        initComponents();
        this.bdP = bdP;
        this.bd = bd;
        iniciarComponentesPersonalizados();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidosActivos = new javax.swing.JTable();
        btnVerDetalle = new javax.swing.JButton();
        btnCancelarPedido = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setTitle("VER PEDIDOS ACTIVOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PEDIDOS ACTIVOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N

        tablaPedidosActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° DE PEDIDO", "MESA", "HORA", "TOTAL", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPedidosActivos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnVerDetalle.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnVerDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/Lista.gif"))); // NOI18N
        btnVerDetalle.setText("VER DETALLE");
        btnVerDetalle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        btnCancelarPedido.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnCancelarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/paper (1).png"))); // NOI18N
        btnCancelarPedido.setText("CANCELAR PEDIDO");
        btnCancelarPedido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/refresh.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/Salir.gif"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/carrito.gif"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void iniciarComponentesPersonalizados() {
        modeloTabla = (DefaultTableModel) tablaPedidosActivos.getModel();
        cargarPedidosActivos();
    }
    // Método para llenar la tabla
    private void cargarPedidosActivos() {
        modeloTabla.setRowCount(0); //Limpia las filas
        
        // se llama al metiodo que contiene todos los datos de la base de datos de lso pedidos
        ArrayList<Pedido> lista = bdP.listarPedidos();
        
        for (Pedido p : lista) {
            
            modeloTabla.addRow(new Object[]{
                p.getNumeroPedido(), p.getMesa().getNumero(), p.getHora().toString().substring(11, 19), p.getcalcularTotal(), p.getEstado()
            });
        }
    }
    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
                                                   
        int filaSeleccionada = tablaPedidosActivos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido para cancelar.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
            }

            String numPedido = (String) modeloTabla.getValueAt(filaSeleccionada, 0); // Obtener N° de Pedido

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar el pedido N° " + numPedido + "?", "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Llamar al método de la base de datos
            String resultado = bdP.eliminarPedido(numPedido);

            JOptionPane.showMessageDialog(this, resultado, "Resultado", 1);

            // Recargar la tabla para ver los cambios
            cargarPedidosActivos();
            }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarPedidosActivos();
        JOptionPane.showMessageDialog(this, "Lista de pedidos actualizada.", "Actualización", 1);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int filaSeleccionada = tablaPedidosActivos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido de la lista para agregarle más productos.", "Aviso", 2);
            return;
            }

        String numPedido = (String) tablaPedidosActivos.getValueAt(filaSeleccionada, 0);

        //se busca el item p[ara agregar en la base de datos pedidos
        Pedido editarPedido = bdP.buscarPedido(numPedido);

        if (editarPedido != null) {
            JDesktopPane deskFondo = this.getDesktopPane();

            //aqui se usa el segundo constuctor, al cual se le pasara el registro, pedidos y el item para agregar y editar el epdido
            JIFNuevoPedido ventanaEdicion = new JIFNuevoPedido(bd, bdP, editarPedido);

            deskFondo.add(ventanaEdicion);
            ventanaEdicion.setVisible(true);
            } else {
            JOptionPane.showMessageDialog(this, "Error al recuperar el pedido.", "Error", 0);
            }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        //se verifica si hayy una fila seleccionada
        int filaSeleccionada = tablaPedidosActivos.getSelectedRow();

        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido para ver el detalle.", "Error", 2);
            return;
        }

        //obtener numero de la  columna donde esta el numero de pedido
        String numPedido = (String) tablaPedidosActivos.getValueAt(filaSeleccionada, 0); 
        
        entidades.Pedido seleccion = bdP.buscarPedido(numPedido); 

        if (seleccion != null) {
            JDesktopPane deskFondo = this.getDesktopPane();
            JIFDetallePedido detalle = new JIFDetallePedido(seleccion); 
            deskFondo.add(detalle);
            detalle.setVisible(true);
        } else {
             javax.swing.JOptionPane.showMessageDialog(this, "Error crítico: No se encontró el pedido en la memoria.", "Error", 0);
        }
    }//GEN-LAST:event_btnVerDetalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPedidosActivos;
    // End of variables declaration//GEN-END:variables
}
