package com.sistemamonitoreosaludpublica;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.HashSet;
import java.util.Set;

public class Principal extends javax.swing.JFrame {
    DefaultTableModel defaultTableModel;
    MortalityRateDAO mortalityRateDAO;
    DefaultCategoryDataset datosBarras;
    DefaultCategoryDataset datosLineal;
    Set<String> listaGeneros;
    Set<String> listaEnfermedades;

    public Principal() {
        initComponents();
        this.setTitle("Sistema de Monitoreo de Salud Pública");
        this.setLocationRelativeTo(Principal.this);
        
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Datos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        panel_Barras = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        graficoBarras = new javax.swing.JPanel();
        panel_Lineal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboEnfermedad = new javax.swing.JComboBox<>();
        graficoLineal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_Archivo = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        menu_Datos = new javax.swing.JMenu();
        menuVerDatos = new javax.swing.JMenuItem();
        menu_Graficos = new javax.swing.JMenu();
        menuVerBarras = new javax.swing.JMenuItem();
        menuVerLineal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        panel_Datos.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Tasas de Mortalidad");
        panel_Datos.add(jLabel1);
        jLabel1.setBounds(0, 0, 537, 40);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Año", "Departamento", "Sexo", "Enfermedad", "N° Defunciones", "Tasa Bruta", "Tasa Ajuste", "Error", "Lim. Inferior", "Lim. Superior", "Cluster"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        panel_Datos.add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 1190, 660);

        getContentPane().add(panel_Datos, "card2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Mortalidad de enfermedades");

        comboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graficoBarrasLayout = new javax.swing.GroupLayout(graficoBarras);
        graficoBarras.setLayout(graficoBarrasLayout);
        graficoBarrasLayout.setHorizontalGroup(
            graficoBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1235, Short.MAX_VALUE)
        );
        graficoBarrasLayout.setVerticalGroup(
            graficoBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_BarrasLayout = new javax.swing.GroupLayout(panel_Barras);
        panel_Barras.setLayout(panel_BarrasLayout);
        panel_BarrasLayout.setHorizontalGroup(
            panel_BarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BarrasLayout.createSequentialGroup()
                .addGroup(panel_BarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_BarrasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(graficoBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_BarrasLayout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel_BarrasLayout.createSequentialGroup()
                .addGap(484, 484, 484)
                .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_BarrasLayout.setVerticalGroup(
            panel_BarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_BarrasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graficoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel_Barras, "card3");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Mortalidad de enfermedades por año");

        comboEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEnfermedadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graficoLinealLayout = new javax.swing.GroupLayout(graficoLineal);
        graficoLineal.setLayout(graficoLinealLayout);
        graficoLinealLayout.setHorizontalGroup(
            graficoLinealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1235, Short.MAX_VALUE)
        );
        graficoLinealLayout.setVerticalGroup(
            graficoLinealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_LinealLayout = new javax.swing.GroupLayout(panel_Lineal);
        panel_Lineal.setLayout(panel_LinealLayout);
        panel_LinealLayout.setHorizontalGroup(
            panel_LinealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_LinealLayout.createSequentialGroup()
                .addGroup(panel_LinealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_LinealLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(graficoLineal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_LinealLayout.createSequentialGroup()
                        .addGroup(panel_LinealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_LinealLayout.createSequentialGroup()
                                .addGap(484, 484, 484)
                                .addComponent(comboEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_LinealLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_LinealLayout.setVerticalGroup(
            panel_LinealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_LinealLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(comboEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graficoLineal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel_Lineal, "card3");

        menu_Archivo.setText("Archivo");

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menu_Archivo.add(menuSalir);

        jMenuBar1.add(menu_Archivo);

        menu_Datos.setText("Datos");

        menuVerDatos.setText("Visualizar datos");
        menuVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerDatosActionPerformed(evt);
            }
        });
        menu_Datos.add(menuVerDatos);

        jMenuBar1.add(menu_Datos);

        menu_Graficos.setText("Gráficos");

        menuVerBarras.setText("Visualizar gráfico de barras");
        menuVerBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerBarrasActionPerformed(evt);
            }
        });
        menu_Graficos.add(menuVerBarras);

        menuVerLineal.setText("Visualizar gráfico lineal");
        menuVerLineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerLinealActionPerformed(evt);
            }
        });
        menu_Graficos.add(menuVerLineal);

        jMenuBar1.add(menu_Graficos);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerDatosActionPerformed
        // TODO add your handling code here:
        panel_Datos.setVisible(true);
        panel_Barras.setVisible(false);
        panel_Lineal.setVisible(false);
    }//GEN-LAST:event_menuVerDatosActionPerformed

    private void menuVerBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerBarrasActionPerformed
        // TODO add your handling code here:
        panel_Datos.setVisible(false);
        panel_Barras.setVisible(true);
        panel_Lineal.setVisible(false);
        graficarBarras();
    }//GEN-LAST:event_menuVerBarrasActionPerformed

    private void comboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGeneroActionPerformed
        // TODO add your handling code here:
        graficarBarras();
    }//GEN-LAST:event_comboGeneroActionPerformed

    private void menuVerLinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerLinealActionPerformed
        // TODO add your handling code here:
        panel_Datos.setVisible(false);
        panel_Barras.setVisible(false);
        panel_Lineal.setVisible(true);
        graficarLineal();
    }//GEN-LAST:event_menuVerLinealActionPerformed

    private void comboEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEnfermedadActionPerformed
        // TODO add your handling code here:
        graficarLineal();
    }//GEN-LAST:event_comboEnfermedadActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    public void graficarBarras(){
        datosBarras.clear();
        String genero = comboGenero.getSelectedItem().toString();
        for (MortalityRate a : mortalityRateDAO.all()) {
            if (a.getGender().equalsIgnoreCase(genero)) {
                datosBarras.setValue(a.getNumberDeath(), a.getDisease(), a.getGender());
            }
        }
        
        JFreeChart grafico_barras = ChartFactory.createBarChart("Muertes por género por cada enfermedad en Arequipa",
                "Genero",
                "Cantidad de fallecidos",
                datosBarras,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        ChartPanel graf = new ChartPanel(grafico_barras);
        graf.setMouseWheelEnabled(true);
        
        graficoBarras.setLayout(new BorderLayout());
        graficoBarras.add(graf,BorderLayout.NORTH);
        pack();
        repaint();
    }
    
    public void graficarLineal(){
        datosLineal.clear();
        String enfermedad = comboEnfermedad.getSelectedItem().toString();
        
        for (MortalityRate a : mortalityRateDAO.all()) {
            if (a.getDisease().equalsIgnoreCase(enfermedad)) {
                if (a.getGender().equalsIgnoreCase("Hombre")) {
                    datosLineal.setValue(a.getNumberDeath(), "Hombre", Integer.toString(a.getYear()));
                } else if (a.getGender().equalsIgnoreCase("Mujer")) {
                    datosLineal.setValue(a.getNumberDeath(), "Mujer", Integer.toString(a.getYear()));
                }
            }
        }
        
        JFreeChart grafico_lineal = ChartFactory.createLineChart("Muertes por enfermedad por año en Arequipa",
                "Año",
                "Cantidad de fallecidos",
                datosLineal);
        
        ChartPanel graf = new ChartPanel(grafico_lineal);
        graf.setMouseWheelEnabled(true);
        
        graficoLineal.setLayout(new BorderLayout());
        graficoLineal.add(graf,BorderLayout.NORTH);
        pack();
        repaint();
    }

    public final void iniciar(){
        defaultTableModel = (DefaultTableModel) tblDatos.getModel();
        mortalityRateDAO = new MortalityRateDAO();
        datosBarras = new DefaultCategoryDataset();
        datosLineal = new DefaultCategoryDataset();
        listaGeneros = new HashSet<>();
        listaEnfermedades = new HashSet<>();
        
        // Mostrar datos
        for (MortalityRate a : mortalityRateDAO.all()) {
            if (a.getDepartment().equalsIgnoreCase("Arequipa")) {
                defaultTableModel.addRow(new Object[]{
                    a.getYear(),
                    a.getDepartment(),
                    a.getGender(),
                    a.getDisease(),
                    a.getNumberDeath(),
                    a.getGrossRate(),
                    a.getAdjusmentRate(),
                    a.getError(),
                    a.getLowerLimit(),
                    a.getUpperLimit(),
                    a.getCluster()});
                
                listaGeneros.add(a.getGender());
                listaEnfermedades.add(a.getDisease());
            }
        }
        tblDatos.setModel(defaultTableModel);

        // Rellenar combos
        listaGeneros.forEach(info -> comboGenero.addItem(info));
        listaEnfermedades.forEach(info -> comboEnfermedad.addItem(info));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEnfermedad;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JPanel graficoBarras;
    private javax.swing.JPanel graficoLineal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem menuVerBarras;
    private javax.swing.JMenuItem menuVerDatos;
    private javax.swing.JMenuItem menuVerLineal;
    private javax.swing.JMenu menu_Archivo;
    private javax.swing.JMenu menu_Datos;
    private javax.swing.JMenu menu_Graficos;
    private javax.swing.JPanel panel_Barras;
    private javax.swing.JPanel panel_Datos;
    private javax.swing.JPanel panel_Lineal;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
