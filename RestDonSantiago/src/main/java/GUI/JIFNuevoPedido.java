
package GUI;
import javax.swing.JDesktopPane;
import java.util.ArrayList;
import accesoDatos.BaseDatosPedidos;
import accesoDatos.BaseDatosRegistro;
import entidades.Mozos;
import entidades.Mesas;
import entidades.Platos;
import entidades.Bebidas;
import entidades.Pedido;
import entidades.DetallePedido;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel; 
import javax.swing.JOptionPane;
import java.time.LocalTime;



public class JIFNuevoPedido extends javax.swing.JInternalFrame {
    //atributos para enlazar clases
    private BaseDatosRegistro bd;
    private BaseDatosPedidos bdP;
    private DefaultTableModel modeloPlatos;
    private DefaultTableModel modeloDetalle;
    //pedido actual
    private Pedido pedidoActual;
    
    //constructor apra crear un pedido desde cero
    public JIFNuevoPedido(BaseDatosRegistro bd, BaseDatosPedidos bdP) {
        initComponents();
        this.bd = bd;
        this.bdP = bdP;
        this.pedidoActual=null; // se coloca null porque aun no ha pedido
        iniciarComponentesPersonalizados();
    }
    
    //constructor para añadir items al pedido a existente
    public JIFNuevoPedido(BaseDatosRegistro bd, BaseDatosPedidos bdP, Pedido pedidoExistente) {
        initComponents();
        this.bd = bd;
        this.bdP = bdP;
        this.pedidoActual = pedidoExistente;
        
        iniciarComponentesPersonalizados();
        
        cargarDatosPedidoExistente(); 
    }
    
    private void cargarDatosPedidoExistente() {
        //se bloquea el numero del pedido
        txtPedido.setText(pedidoActual.getNumeroPedido());
        txtPedido.setEnabled(false);

        //bloquea automaticamente el combox de mesa
        for (int i = 0; i < comboxMesa.getItemCount(); i++) {
            String item = comboxMesa.getItemAt(i);
            if (item.contains(pedidoActual.getMesa().getNumero())) {
                comboxMesa.setSelectedIndex(i);
                break;
            }
        }
        comboxMesa.setEnabled(false);

        //bloquea automaticamente el combox de mozo
        for (int i = 0; i < comboxMozo.getItemCount(); i++) {
            String item = comboxMozo.getItemAt(i);
            if (item.contains(pedidoActual.getMozo().getApellido())) { // Ajusta la lógica
                comboxMozo.setSelectedIndex(i);
                break;
            }
        }
        comboxMozo.setEnabled(false);

        
        actualizarTablaDetalle();
        
        //camcia el titulo a la ventana
        this.setTitle("AGREGANDO ÍTEMS AL PEDIDO: " + pedidoActual.getNumeroPedido());
    }
    
    private void iniciarComponentesPersonalizados() {
        // se muestr la Hora Actual
        txtHora.setText(LocalTime.now().toString().substring(0, 8)); 

        //Llenar ComboBox de Mesas
        for (Mesas m : bd.mesa) {
            comboxMesa.addItem(m.getNumero() + " (Capacidad: " + m.getCapacidad() + ")");
        }

        //Llenar ComboBox de Mozos
        for (Mozos mz : bd.mozo) {
            comboxMozo.addItem(mz.getApellido() + ", " + mz.getNombre());
        }

        // Modelo para columna de platos/bebidas disponibles
        modeloPlatos = (DefaultTableModel) tablaPlatos.getModel();
        modeloPlatos.setRowCount(0); // Limpiar filas iniciales
        cargarItemsDisponibles(); // Carga todos los platos y bebidas

        // Modelo para el detalle del pedido
        modeloDetalle = (DefaultTableModel) tablaDetPed.getModel();
        modeloDetalle.setRowCount(0); // Limpiar filas iniciales

        
    }
    private void cargarItemsDisponibles() {

        // Cargar Platos
        for (Platos p : bd.plato) {
            // [ PLATO/BEBIDA, CANTIDAD DISPONIBLE, PRECIO]
            modeloPlatos.addRow(new Object[]{
                p.getNombre(), 
                p.getCantidad(), 
                p.getPrecio()
            });
        }

        // Cargar Bebidas
        for (Bebidas b : bd.bebida) {
            modeloPlatos.addRow(new Object[]{
                b.getNombre(), 
                b.getCantidad(), 
                b.getPrecio()
            });
        }
    }
    private void actualizarTablaDetalle() {
        modeloDetalle.setRowCount(0); // Limpiar tabla
        for (DetallePedido det : pedidoActual.getDetalles()) {
            modeloDetalle.addRow(new Object[]{
                det.getCantidad(),
                det.getNomItem(),
                det.getPrecioUnitario(),
                det.getSubtotal()
            });
        }
        // SE MUESTRA EL TOTAL
        btnActualizar.setText("GUARDAR");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboxMesa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboxMozo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        spnCant = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetPed = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setTitle("NUEVO PEDIDO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N

        comboxMesa.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        comboxMesa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboxMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxMesaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mesa:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mozo:");

        comboxMozo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        comboxMozo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboxMozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxMozoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("N° de pedido:");

        txtPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedidoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Hora:");

        txtHora.setEditable(false);
        txtHora.setFocusable(false);
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(comboxMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboxMozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPedido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIÓN DE PLATOS Y BEBIDAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 14))); // NOI18N

        tablaPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PLATO/BEBIDA", "CANTIDAD DISPONIBLE", "PRECIO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPlatos);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cantidad:");

        btnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/carrito.gif"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        spnCant.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        spnCant.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnCant, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(spnCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DEL PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 14))); // NOI18N

        tablaDetPed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CANTIDAD", "PLATO", "PRECIO", "SUBTOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaDetPed);

        btnActualizar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/Guardar.gif"))); // NOI18N
        btnActualizar.setText("GUARDAR");
        btnActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
        );

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imagenes/Salir.gif"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboxMozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxMozoActionPerformed
    
    }//GEN-LAST:event_comboxMozoActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (pedidoActual == null || pedidoActual.getDetalles().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ítems para registrar en el pedido.", "Pedido Vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Usar el método de la BaseDatosPedidos
        String mensaje = bdP.agregarPedido(pedidoActual);

        JOptionPane.showMessageDialog(this, mensaje, "Registro de Pedido", JOptionPane.INFORMATION_MESSAGE);

        // Restablecer el formulario para un nuevo pedido
        restablecerFormulario();
    }//GEN-LAST:event_btnActualizarActionPerformed
    private void restablecerFormulario() {
        pedidoActual = null;
        txtPedido.setText("");
        txtPedido.setEnabled(true);
        comboxMesa.setSelectedIndex(-1); 
        comboxMesa.setEnabled(true);
        comboxMozo.setSelectedIndex(-1);
        comboxMozo.setEnabled(true);
        modeloDetalle.setRowCount(0);
        spnCant.setValue(0);
        btnActualizar.setText("GUARDAR");
        txtHora.setText(LocalTime.now().toString().substring(0, 8)); 
        
    }
    private void comboxMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxMesaActionPerformed
    
    }//GEN-LAST:event_comboxMesaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try{
            int filaSeleccionada = tablaPlatos.getSelectedRow();
            int cantidad = (int) spnCant.getValue();

            if (filaSeleccionada == -1 || cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Seleccione un plato/bebida y una cantidad válida.", "Error de Selección", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Obtener datos del ítem seleccionado
            String nomItem = (String) modeloPlatos.getValueAt(filaSeleccionada, 0);
            int stockDisponible = (Integer) modeloPlatos.getValueAt(filaSeleccionada, 1);
            double precioUnitario = (Double) modeloPlatos.getValueAt(filaSeleccionada, 2);
            
            if(cantidad == 0){
                JOptionPane.showMessageDialog(this, "La cantidad que usted eligio debe ser como mínimo uno.", "Cantidad Incorreta", 0);
            } else {
            }
            if (cantidad > stockDisponible) {
                JOptionPane.showMessageDialog(this, "La cantidad solicitada (" + cantidad + ") excede el stock disponible (" + stockDisponible + ").", "Stock Insuficiente", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Crear el objeto Pedido si aún no existe
            if (pedidoActual == null) {
                String numPedido = txtPedido.getText().trim();
                if (numPedido.isEmpty() || comboxMesa.getSelectedIndex() == -1 || comboxMozo.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "Debe completar el N° de pedido, Mesa y Mozo antes de agregar ítems.", "Datos Incompletos", 0);
                    return;
                }

                // Obtener la entidad real seleccionada
                Mesas mesaSel = bd.mesa.get(comboxMesa.getSelectedIndex());
                Mozos mozoSel = bd.mozo.get(comboxMozo.getSelectedIndex());

                // Crear el nuevo Pedido
                pedidoActual = new Pedido(numPedido, mesaSel, mozoSel, new Date());
                txtPedido.setEnabled(false); // Bloquear cambios en los datos principales
                comboxMesa.setEnabled(false);
                comboxMozo.setEnabled(false);
            }

            //Crear el DetallePedido y agregarlo al Pedido
            DetallePedido detalle = new DetallePedido(nomItem, precioUnitario, cantidad);
            pedidoActual.agregarDetalle(detalle);
            //se busca el plato y se resta para descontar del stock
            for (entidades.Platos p : bd.plato) {
            if (p.getNombre().equals(nomItem)) {
                p.setCantidad(p.getCantidad() - cantidad);
                break;
                }
            }
            for (entidades.Bebidas b : bd.bebida) {
            if (b.getNombre().equals(nomItem)) {
                b.setCantidad(b.getCantidad() - cantidad);
                break;
                }
            }
            //se actualzia la celda
            modeloPlatos.setValueAt(stockDisponible - cantidad, filaSeleccionada, 1);
            //Actualizar la tabla de Detalle del Pedido
            actualizarTablaDetalle();

            spnCant.setValue(0); // Reiniciar el spinner
        }catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Cantidad Inválida", 2);
        
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Problema de Stock", 2);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
           }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboxMesa;
    private javax.swing.JComboBox<String> comboxMozo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnCant;
    private javax.swing.JTable tablaDetPed;
    private javax.swing.JTable tablaPlatos;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtPedido;
    // End of variables declaration//GEN-END:variables
}
