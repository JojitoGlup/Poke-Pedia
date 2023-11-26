package com.mycompany.proyecto.pokepedia;

import static com.mycompany.proyecto.pokepedia.PokemonApp.LOGGER;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;


public class AppPokemon extends javax.swing.JFrame {
    public static final Logger LOGGER = LoggerConfig.getLogger();

   private PokemonApiTypes pokemonTypes;
    
    public AppPokemon() {
        initComponents();
        cargarTiposPokemon();
        deshabilitarElementos();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupRadio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboBoxTipos = new javax.swing.JComboBox<>();
        btnTipo = new javax.swing.JButton();
        btnPokemon = new javax.swing.JButton();
        textFieldPokemon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        lbHabilidad = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbDescripcionHabilidad = new javax.swing.JLabel();
        lbAtaque = new javax.swing.JLabel();
        lbDanoAtaque = new javax.swing.JLabel();
        lbDescripcionAtaque = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbilustracion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pokemonList = new javax.swing.JList<>();
        rbEspecie = new javax.swing.JRadioButton();
        rbNombre = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarPor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel3.setText("Proyecto final: PokePedia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        comboBoxTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTiposActionPerformed(evt);
            }
        });

        btnTipo.setText("Siguiente");
        btnTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoActionPerformed(evt);
            }
        });

        btnPokemon.setText("Siguiente");
        btnPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("Seleccione un tipo de Pokemon");

        lblName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblName.setText("Escriba el nombre del Pokemon que desee");

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));

        jPanel3.setBackground(new java.awt.Color(153, 0, 204));

        lbNombre.setText("Nombre:");

        lbHabilidad.setText("Habilidad:");

        lbTipo.setText("Tipo:");

        lbDescripcionHabilidad.setText("Descripción de la Habilidad:");

        lbAtaque.setText("Daño:");

        lbDanoAtaque.setText("Daño del ataque:");

        lbDescripcionAtaque.setText("Descripción del Ataque: ");

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(lbilustracion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lbilustracion, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDanoAtaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAtaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(263, 263, 263))
                            .addComponent(lbHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDescripcionHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDescripcionAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHabilidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDescripcionHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAtaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDanoAtaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescripcionAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pokemonList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokemonListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pokemonList);

        groupRadio.add(rbEspecie);
        rbEspecie.setText("Especie");
        rbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEspecieActionPerformed(evt);
            }
        });

        groupRadio.add(rbNombre);
        rbNombre.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Seleccione el tipo de búsqueda:");

        btnBuscarPor.setText("OK");
        btnBuscarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboBoxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTipo)
                        .addGap(139, 139, 139))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(textFieldPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPokemon))
                                .addComponent(lblName)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscarPor)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarPor)
                            .addComponent(rbNombre)
                            .addComponent(rbEspecie))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTipo)
                            .addComponent(comboBoxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPokemon))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void cargarTiposPokemon() {
    comboBoxTipos.addItem("normal");
    comboBoxTipos.addItem("fighting");
    comboBoxTipos.addItem("flying");
    comboBoxTipos.addItem("poison");
    comboBoxTipos.addItem("ground");
    comboBoxTipos.addItem("rock");
    comboBoxTipos.addItem("bug");
    comboBoxTipos.addItem("ghost");
    comboBoxTipos.addItem("steel");
    comboBoxTipos.addItem("fire");
    comboBoxTipos.addItem("water");
    comboBoxTipos.addItem("grass");
    comboBoxTipos.addItem("electric");
    comboBoxTipos.addItem("psychic");
    comboBoxTipos.addItem("ice");
    comboBoxTipos.addItem("dragon");
    comboBoxTipos.addItem("dark");
    comboBoxTipos.addItem("fairy");
    comboBoxTipos.addItem("unknown");
    comboBoxTipos.addItem("shadow");
}
private void deshabilitarElementos(){
    lblName.setEnabled(false);
    textFieldPokemon.setEnabled(false);
    btnPokemon.setEnabled(false);
    jLabel1.setEnabled(false);
    comboBoxTipos.setEnabled(false);
    btnTipo.setEnabled(false);
    pokemonList.setEnabled(false);
}

 
private DefaultListModel listaPokemon(){
    DefaultListModel modelo =  new DefaultListModel();
    String tipoSeleccionado = comboBoxTipos.getSelectedItem().toString();
    PokemonApiTypes pokemonTypes = new PokemonApiTypes(tipoSeleccionado);
    
    String[] pokemonDelTipo = pokemonTypes.getListaPokemones();

    if (pokemonDelTipo != null && pokemonDelTipo.length > 0) {
        for(String pokemon: pokemonDelTipo){
            modelo.addElement(pokemon);
        }
    } else {
        
    }
    return modelo;
 }

    private void comboBoxTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTiposActionPerformed

    private void btnTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoActionPerformed
        pokemonList.setModel(listaPokemon());
    }//GEN-LAST:event_btnTipoActionPerformed

    private void btnPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemonActionPerformed
        String nombrePokemon = textFieldPokemon.getText().trim();

    if (!nombrePokemon.isEmpty()) {
        PokemonApiName pokemonInfo = new PokemonApiName(nombrePokemon);
        Pokemon pokemon = pokemonInfo.getPokemon();

        lbNombre.setText("Nombre: " + pokemon.getNombre());

        try {
            String imageUrl = pokemon.getIlustracion();
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);
            
            lbilustracion.setIcon(icon);
        } catch (IOException e) {
            LOGGER.severe("Error al cargar el archivo: "+e.getMessage());
            e.printStackTrace();
            System.out.println("Error al cargar la imagen");
        }
        
        lbTipo.setText("Tipo: " + pokemon.getTipo());
        lbHabilidad.setText("Habilidad: " + pokemon.getHabilidad());
        lbDescripcionHabilidad.setText("Descripción de la Habilidad: " + pokemon.getDescripcionHabilidad());
        lbAtaque.setText("Ataque: " + pokemon.getAtaque());
        lbDanoAtaque.setText("Daño del Ataque: " + pokemon.getDanioAtaque());
        lbDescripcionAtaque.setText("Descripción del Ataque: " + pokemon.getDescripcionAtaque());

        
        
    } else {
        System.out.println("Ingrese un nombre de Pokémon válido");
    }

    }//GEN-LAST:event_btnPokemonActionPerformed

    private void pokemonListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokemonListMouseClicked
        if (evt.getClickCount() == 2) {
            String nombrePokemon = pokemonList.getSelectedValue();
            //System.out.println(nombrePokemon);
            if (!nombrePokemon.isEmpty()) {
                PokemonApiName pokemonInfo = new PokemonApiName(nombrePokemon);
                Pokemon pokemon = pokemonInfo.getPokemon();

                lbNombre.setText("Nombre: " + pokemon.getNombre());

                try {
                    String imageUrl = pokemon.getIlustracion();
                    URL url = new URL(imageUrl);
                    BufferedImage image = ImageIO.read(url);
                    ImageIcon icon = new ImageIcon(image);

                    lbilustracion.setIcon(icon);
                } catch (IOException e) {
                    LOGGER.severe("Error al cargar el archivo: "+e.getMessage());
                    e.printStackTrace();
                    System.out.println("Error al cargar la imagen");
                }
                lbTipo.setText("Tipo: " + pokemon.getTipo());
                lbHabilidad.setText("Habilidad: " + pokemon.getHabilidad());
                lbDescripcionHabilidad.setText("<html>"+"Descripción de la Habilidad: " + pokemon.getDescripcionHabilidad()+"</html>");
                lbAtaque.setText("Ataque: " + pokemon.getAtaque());
                lbDanoAtaque.setText("Daño del Ataque: " + pokemon.getDanioAtaque());
                lbDescripcionAtaque.setText("<html>"+"Descripción del Ataque: " + pokemon.getDescripcionAtaque()+"</html>");
            } else {
                System.out.println("Ingrese un nombre de Pokémon válido");
            }

        }

    }//GEN-LAST:event_pokemonListMouseClicked

    private void rbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEspecieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEspecieActionPerformed

    private void btnBuscarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorActionPerformed
        
        if(rbEspecie.isSelected()){
            jLabel1.setEnabled(true);
            comboBoxTipos.setEnabled(true);
            btnTipo.setEnabled(true);
            pokemonList.setEnabled(true);
            lblName.setEnabled(false);
            textFieldPokemon.setEnabled(false);
            btnPokemon.setEnabled(false);
            
        }else if(rbNombre.isSelected()){
            lblName.setEnabled(true);
            textFieldPokemon.setEnabled(true);
            btnPokemon.setEnabled(true);
            jLabel1.setEnabled(false);
            comboBoxTipos.setEnabled(false);
            btnTipo.setEnabled(false);
            pokemonList.setEnabled(false);
        }
    }//GEN-LAST:event_btnBuscarPorActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppPokemon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPor;
    private javax.swing.JButton btnPokemon;
    private javax.swing.JButton btnTipo;
    private javax.swing.JComboBox<String> comboBoxTipos;
    private javax.swing.ButtonGroup groupRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAtaque;
    private javax.swing.JLabel lbDanoAtaque;
    private javax.swing.JLabel lbDescripcionAtaque;
    private javax.swing.JLabel lbDescripcionHabilidad;
    private javax.swing.JLabel lbHabilidad;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbilustracion;
    private javax.swing.JLabel lblName;
    private javax.swing.JList<String> pokemonList;
    private javax.swing.JRadioButton rbEspecie;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JTextField textFieldPokemon;
    // End of variables declaration//GEN-END:variables
}
