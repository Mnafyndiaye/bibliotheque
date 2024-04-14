
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author DELL
 */
public class Gestion_livres extends javax.swing.JFrame {

    /**
     * Creates new form Gestion_cotisations
     */

    
    
    
    
    
    public Gestion_livres() {
        initComponents();
        
        chargerDonneesLivres(); // Appel de la méthode pour charger les données de la table "livres"


        
        jLabel5.setLocation(0, 8000);
        
        //this.setTitle("Page connexion");
        this.setTitle("Gestion Livres");
        
        
        //Etat : Activer pour l'instant
 
    // Désactiver la visibilité de la JList
    jPanelDropdownBlack.setVisible(true);
    // Désactiver la JList pour qu'elle ne soit pas cliquable
    jPanelDropdownBlack.setEnabled(true);

        
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        




        // Définition de la position du JLabel
        jPanel2Biblio.add(TableauDeBordBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));
        jPanel2Biblio.add(TableauDeBordBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));
        jPanel2Biblio.add(GestionLivresBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));
        jPanel2Biblio.add(GestionLivresBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));
        jPanel2Biblio.add(GestionUtilisateursBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));
        jPanel2Biblio.add(GestionUtilisateursBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));
        jPanel2Biblio.add(GestionEmpruntsBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));
        jPanel2Biblio.add(GestionEmpruntsBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jPanel2Biblio.add(GestionCotisationsBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));
        jPanel2Biblio.add(GestionCotisationsBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));
        
        
        
        jPanel2Biblio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 710, -1, -1));
        
   
        
        
  

    //Les boutons CRUD de Gestion_livres 
        TableActionEvent_Livres event;
        event = new TableActionEvent_Livres(){
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
            }

            @Override
            public void onDelete(int row) {
                // Message lorsqu'on appuie sur le boutton Delete_GestionLivres
                System.out.println("Delete row : " + row);
                
                if(jTable1_GestionLivres.isEditing()){
                    jTable1_GestionLivres.getCellEditor().stopCellEditing();
                    
                }
                
                // Vérifier d'abord la taille actuelle du modèle de tableau
                int rowCount = jTable1_GestionLivres.getRowCount();
                
                
                // Afficher une boîte de dialogue de confirmation
                int response = JOptionPane.showConfirmDialog(Gestion_livres.this, "Êtes-vous sûr de vouloir supprimer cette ligne ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                
                // Si l'utilisateur confirme la suppression
                if (response == JOptionPane.YES_OPTION) {
                    // Appeler la méthode pour supprimer la ligne du jTable et de la base de données
                    deleteRow(row);
                    
                }
                
            }
            
            // La Méthode delete ROW
            private void deleteRow(int row) {
                PreparedStatement ps;
                ResultSet rs;
                try {
                    // Création de la requête de suppression
                    String query = "DELETE FROM livres WHERE idLivres=?";
                    
                    // Préparation de la requête
                    ps = MyConnection.getConnection().prepareStatement(query);
                    
                    // Obtention de l'ID de la ligne à supprimer
                    
                    int idLivres = (int) jTable1_GestionLivres.getValueAt(row, 0);
                    
                    
                    // Remplacement du paramètre par l'ID de la ligne
                    ps.setInt(1, idLivres);
                    

                    // Exécution de la requête
                        int rowsAffected = ps.executeUpdate();

                        // Vérifier si l'exécution a réussi (rowsAffected contient le nombre de lignes affectées)
                        if (rowsAffected > 0) {
                            // Supprimer la ligne du jTable
                            DefaultTableModel model = (DefaultTableModel) jTable1_GestionLivres.getModel();
                            model.removeRow(row);

                            // Faire apparaître une fenêtre de dialogue informant de la suppression réussie
                            JOptionPane.showMessageDialog(Gestion_livres.this, "La livre a été supprimée avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // Si aucune ligne n'a été affectée, afficher un message d'erreur
                            JOptionPane.showMessageDialog(Gestion_livres.this, "Aucune ligne n'a été supprimée.", "Erreur de suppression", JOptionPane.ERROR_MESSAGE);
                        }
                       
                    // Fermeture des ressources
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Gestion_livres.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(Gestion_livres.this, "Erreur lors de la suppression : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            
            
            
           
            @Override
            public void onView(int row) {
                System.out.println("View row : " + row);
            }
         
        };
        //Position Bottons actions Edit,View etc ....
        jTable1_GestionLivres.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRendue());
        jTable1_GestionLivres.getColumnModel().getColumn(9).setCellEditor(new TableActionsCellEditor(event));
       
        
    }
    
private void chargerDonneesLivres() {
    PreparedStatement ps;
    ResultSet rs;
    
    String query = "SELECT * FROM livres";
    
    try {
        ps = MyConnection.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) jTable1_GestionLivres.getModel();
        model.setRowCount(0);
        
        while (rs.next()) {
            Object[] row = {
                rs.getInt("idLivres"),
                rs.getString("Titre"),
                rs.getString("Editeur"),
                rs.getString("Auteur"),
                rs.getString("ISBN"),
                rs.getDate("Date_de_publication"),
                rs.getString("Genre"),
                rs.getInt("Exemplaires"),
                //rs.getInt("Nombre_de_pages"),
                rs.getString("Langue")
            };
            model.addRow(row);
        }

        // Fermeture des ressources
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        //System.out.println(ex.getMessage());
    }
}
 // Autres parties ...


    
    
    
    
    
public void refreshFrame(JFrame frame) {
    frame.revalidate(); // Actualise la mise en page de la fenêtre
    frame.repaint(); // Redessine la fenêtre avec les modifications
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ShowSetting = new javax.swing.JLabel();
        DisableSetting = new javax.swing.JLabel();
        jPanelDropdownBlack = new javax.swing.JPanel();
        jLabelMonCompte = new javax.swing.JLabel();
        jLabelDéconnexion = new javax.swing.JLabel();
        jLabelMonCompte1 = new javax.swing.JLabel();
        jLabelDéconnexion1 = new javax.swing.JLabel();
        TableauDeBordBlanc2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_GestionLivres = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2Biblio = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        GestionUtilisateursBlanc = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        GestionLivresBlanc = new javax.swing.JLabel();
        GestionEmpruntsBlanc = new javax.swing.JLabel();
        TableauDeBordBlanc = new javax.swing.JLabel();
        TableauDeBordBleu = new javax.swing.JLabel();
        GestionLivresBleu = new javax.swing.JLabel();
        GestionUtilisateursBleu = new javax.swing.JLabel();
        GestionEmpruntsBleu = new javax.swing.JLabel();
        GestionCotisationsBlanc = new javax.swing.JLabel();
        GestionCotisationsBleu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        ShowSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_settings_40px.png"))); // NOI18N
        ShowSetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowSettingMouseClicked(evt);
            }
        });

        DisableSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_settings_40px.png"))); // NOI18N
        DisableSetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DisableSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DisableSettingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(818, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShowSetting)
                    .addComponent(DisableSetting))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DisableSetting)
                    .addComponent(ShowSetting))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDropdownBlack.setForeground(new java.awt.Color(255, 255, 255));
        jPanelDropdownBlack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelDropdownBlackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelDropdownBlackMouseExited(evt);
            }
        });
        jPanelDropdownBlack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMonCompte.setBackground(new java.awt.Color(255, 51, 51));
        jLabelMonCompte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelMonCompte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_gender_neutral_user_23px.png"))); // NOI18N
        jLabelMonCompte.setText("Mon Compte");
        jLabelMonCompte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMonCompte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMonCompteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMonCompteMouseExited(evt);
            }
        });
        jPanelDropdownBlack.add(jLabelMonCompte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelDéconnexion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelDéconnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_exit_23px.png"))); // NOI18N
        jLabelDéconnexion.setText("Déconnexion");
        jLabelDéconnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDéconnexionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDéconnexionMouseExited(evt);
            }
        });
        jPanelDropdownBlack.add(jLabelDéconnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabelMonCompte1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMonCompte1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelMonCompte1.setForeground(new java.awt.Color(0, 51, 255));
        jLabelMonCompte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_gender_neutral_user_23px_1.png"))); // NOI18N
        jLabelMonCompte1.setText("Mon Compte");
        jLabelMonCompte1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMonCompte1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMonCompte1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMonCompte1MouseExited(evt);
            }
        });
        jPanelDropdownBlack.add(jLabelMonCompte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelDéconnexion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelDéconnexion1.setForeground(new java.awt.Color(0, 51, 255));
        jLabelDéconnexion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_exit_23px_1.png"))); // NOI18N
        jLabelDéconnexion1.setText("Déconnexion");
        jLabelDéconnexion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDéconnexion1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDéconnexion1MouseExited(evt);
            }
        });
        jPanelDropdownBlack.add(jLabelDéconnexion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        TableauDeBordBlanc2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        TableauDeBordBlanc2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_35px_6.png"))); // NOI18N
        TableauDeBordBlanc2.setText("Gestion Livres");
        TableauDeBordBlanc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableauDeBordBlanc2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TableauDeBordBlanc2MouseExited(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_save_20px.png"))); // NOI18N
        jButton1.setText("Enregistrer un nouveau livre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_available_updates_filled_20px_1.png"))); // NOI18N
        jButton3.setText("Actualiser");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1_GestionLivres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Titre", "Editeur", "Auteur", "ISBN", "Date de Publication", "Genre", "Exemplaires", "Langue", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_GestionLivres.setRowHeight(40);
        jTable1_GestionLivres.setSelectionBackground(new java.awt.Color(57, 137, 121));
        jScrollPane1.setViewportView(jTable1_GestionLivres);
        if (jTable1_GestionLivres.getColumnModel().getColumnCount() > 0) {
            jTable1_GestionLivres.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1_GestionLivres.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1_GestionLivres.getColumnModel().getColumn(0).setMaxWidth(35);
            jTable1_GestionLivres.getColumnModel().getColumn(1).setMinWidth(185);
            jTable1_GestionLivres.getColumnModel().getColumn(1).setPreferredWidth(185);
            jTable1_GestionLivres.getColumnModel().getColumn(1).setMaxWidth(190);
            jTable1_GestionLivres.getColumnModel().getColumn(2).setMinWidth(155);
            jTable1_GestionLivres.getColumnModel().getColumn(2).setPreferredWidth(155);
            jTable1_GestionLivres.getColumnModel().getColumn(2).setMaxWidth(160);
            jTable1_GestionLivres.getColumnModel().getColumn(3).setMinWidth(155);
            jTable1_GestionLivres.getColumnModel().getColumn(3).setPreferredWidth(155);
            jTable1_GestionLivres.getColumnModel().getColumn(3).setMaxWidth(160);
            jTable1_GestionLivres.getColumnModel().getColumn(4).setMinWidth(120);
            jTable1_GestionLivres.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1_GestionLivres.getColumnModel().getColumn(4).setMaxWidth(125);
            jTable1_GestionLivres.getColumnModel().getColumn(5).setMinWidth(115);
            jTable1_GestionLivres.getColumnModel().getColumn(5).setPreferredWidth(115);
            jTable1_GestionLivres.getColumnModel().getColumn(5).setMaxWidth(120);
            jTable1_GestionLivres.getColumnModel().getColumn(6).setMinWidth(120);
            jTable1_GestionLivres.getColumnModel().getColumn(6).setPreferredWidth(120);
            jTable1_GestionLivres.getColumnModel().getColumn(6).setMaxWidth(125);
            jTable1_GestionLivres.getColumnModel().getColumn(7).setMinWidth(75);
            jTable1_GestionLivres.getColumnModel().getColumn(7).setPreferredWidth(75);
            jTable1_GestionLivres.getColumnModel().getColumn(7).setMaxWidth(80);
            jTable1_GestionLivres.getColumnModel().getColumn(8).setMinWidth(65);
            jTable1_GestionLivres.getColumnModel().getColumn(8).setPreferredWidth(65);
            jTable1_GestionLivres.getColumnModel().getColumn(8).setMaxWidth(70);
            jTable1_GestionLivres.getColumnModel().getColumn(9).setMinWidth(110);
            jTable1_GestionLivres.getColumnModel().getColumn(9).setPreferredWidth(110);
            jTable1_GestionLivres.getColumnModel().getColumn(9).setMaxWidth(125);
        }

        jTextField1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Rechercher un livre :");

        jPanel2Biblio.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2Biblio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("X");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2Biblio.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("© ESP-DGI/ LGLSI-B");
        jLabel5.setAlignmentX(0.75F);
        jLabel5.setAlignmentY(0.75F);
        jPanel2Biblio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_school_100px.png"))); // NOI18N
        jPanel2Biblio.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 90));

        GestionUtilisateursBlanc.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionUtilisateursBlanc.setForeground(new java.awt.Color(255, 255, 255));
        GestionUtilisateursBlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_group_35px.png"))); // NOI18N
        GestionUtilisateursBlanc.setText("Gestion utilisateurs");
        GestionUtilisateursBlanc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GestionUtilisateursBlanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionUtilisateursBlancMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionUtilisateursBlancMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionUtilisateursBlancMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionUtilisateursBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Bibliothécaire");
        jPanel2Biblio.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        GestionLivresBlanc.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionLivresBlanc.setForeground(new java.awt.Color(255, 255, 255));
        GestionLivresBlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_35px.png"))); // NOI18N
        GestionLivresBlanc.setText("Gestion livres");
        GestionLivresBlanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionLivresBlancMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionLivresBlancMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionLivresBlancMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionLivresBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        GestionEmpruntsBlanc.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionEmpruntsBlanc.setForeground(new java.awt.Color(255, 255, 255));
        GestionEmpruntsBlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_sell_35px.png"))); // NOI18N
        GestionEmpruntsBlanc.setText("Gestion emprunts");
        GestionEmpruntsBlanc.setAlignmentX(0.75F);
        GestionEmpruntsBlanc.setAlignmentY(0.75F);
        GestionEmpruntsBlanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionEmpruntsBlancMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionEmpruntsBlancMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionEmpruntsBlancMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionEmpruntsBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        TableauDeBordBlanc.setBackground(new java.awt.Color(255, 255, 255));
        TableauDeBordBlanc.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        TableauDeBordBlanc.setForeground(new java.awt.Color(255, 255, 255));
        TableauDeBordBlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_speed_35px.png"))); // NOI18N
        TableauDeBordBlanc.setText("Tableau de bord");
        TableauDeBordBlanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableauDeBordBlancMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableauDeBordBlancMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TableauDeBordBlancMouseExited(evt);
            }
        });
        jPanel2Biblio.add(TableauDeBordBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        TableauDeBordBleu.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        TableauDeBordBleu.setForeground(new java.awt.Color(0, 51, 255));
        TableauDeBordBleu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_speed_35px_2.png"))); // NOI18N
        TableauDeBordBleu.setText("Tableau de bord");
        TableauDeBordBleu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TableauDeBordBleu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableauDeBordBleuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableauDeBordBleuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TableauDeBordBleuMouseExited(evt);
            }
        });
        jPanel2Biblio.add(TableauDeBordBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        GestionLivresBleu.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionLivresBleu.setForeground(new java.awt.Color(0, 51, 255));
        GestionLivresBleu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_35px_2.png"))); // NOI18N
        GestionLivresBleu.setText("Gestion livres");
        GestionLivresBleu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GestionLivresBleu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionLivresBleuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionLivresBleuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionLivresBleuMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionLivresBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        GestionUtilisateursBleu.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionUtilisateursBleu.setForeground(new java.awt.Color(0, 51, 255));
        GestionUtilisateursBleu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_group_35px_2.png"))); // NOI18N
        GestionUtilisateursBleu.setText("Gestion utilisateurs");
        GestionUtilisateursBleu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GestionUtilisateursBleu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionUtilisateursBleuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionUtilisateursBleuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionUtilisateursBleuMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionUtilisateursBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        GestionEmpruntsBleu.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionEmpruntsBleu.setForeground(new java.awt.Color(0, 51, 255));
        GestionEmpruntsBleu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_sell_35px_3.png"))); // NOI18N
        GestionEmpruntsBleu.setText("Gestion emprunts");
        GestionEmpruntsBleu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GestionEmpruntsBleu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionEmpruntsBleuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionEmpruntsBleuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionEmpruntsBleuMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionEmpruntsBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        GestionCotisationsBlanc.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionCotisationsBlanc.setForeground(new java.awt.Color(255, 255, 255));
        GestionCotisationsBlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_coins_35px.png"))); // NOI18N
        GestionCotisationsBlanc.setText("Gestion cotisations");
        GestionCotisationsBlanc.setAlignmentX(0.75F);
        GestionCotisationsBlanc.setAlignmentY(0.75F);
        GestionCotisationsBlanc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GestionCotisationsBlanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionCotisationsBlancMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionCotisationsBlancMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionCotisationsBlancMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionCotisationsBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

        GestionCotisationsBleu.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        GestionCotisationsBleu.setForeground(new java.awt.Color(0, 51, 255));
        GestionCotisationsBleu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_coins_35px_2.png"))); // NOI18N
        GestionCotisationsBleu.setText("Gestion cotisations");
        GestionCotisationsBleu.setAlignmentX(0.75F);
        GestionCotisationsBleu.setAlignmentY(0.75F);
        GestionCotisationsBleu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GestionCotisationsBleu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionCotisationsBleuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GestionCotisationsBleuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GestionCotisationsBleuMouseExited(evt);
            }
        });
        jPanel2Biblio.add(GestionCotisationsBleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TableauDeBordBlanc2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelDropdownBlack, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2Biblio, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(880, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDropdownBlack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TableauDeBordBlanc2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2Biblio, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1206, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 847, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowSettingMouseClicked
        // TODO add your handling code here:
  
    DisableSetting.setVisible(true);
    DisableSetting.setEnabled(true);
    ShowSetting.setVisible(false);
    ShowSetting.setEnabled(false);
    
    // Désactiver la visibilité de la JList
    jPanelDropdownBlack.setVisible(true);
    // Désactiver la JList pour qu'elle ne soit pas cliquable
    jPanelDropdownBlack.setEnabled(true);

        

    }//GEN-LAST:event_ShowSettingMouseClicked

    private void DisableSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisableSettingMouseClicked
        // TODO add your handling code here:



  
    DisableSetting.setVisible(false);
    DisableSetting.setEnabled(false);
    ShowSetting.setVisible(true);
    ShowSetting.setEnabled(true);
     


    
    // Désactiver la visibilité de la JList
    jPanelDropdownBlack.setVisible(false);
    // Désactiver la JList pour qu'elle ne soit pas cliquable
    jPanelDropdownBlack.setEnabled(false);
    }//GEN-LAST:event_DisableSettingMouseClicked

    private void jLabelMonCompteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMonCompteMouseEntered
        // TODO add your handling code here:
       // jLabelMonCompte.setBackground(Color.BLUE);
        //jLabelMonCompte.setForeground(Color.red);
        //jPanelDropdownBlack
        jLabelMonCompte.setVisible(false);
        jLabelMonCompte1.setVisible(true);
       
    }//GEN-LAST:event_jLabelMonCompteMouseEntered

    private void jLabelDéconnexionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDéconnexionMouseEntered
        // TODO add your handling code here:
        //jLabelDéconnexion.setForeground(Color.red);
        //jLabelDéconnexion.setBackground(Color.BLUE);
        jLabelDéconnexion.setVisible(false);
        jLabelDéconnexion1.setVisible(true);

       
    }//GEN-LAST:event_jLabelDéconnexionMouseEntered

    private void jLabelMonCompteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMonCompteMouseExited
        // TODO add your handling code here:
        //jLabelMonCompte.setForeground(Color.BLACK);
        jLabelMonCompte1.setVisible(false);
        jLabelMonCompte.setVisible(true);
        

    }//GEN-LAST:event_jLabelMonCompteMouseExited

    private void jLabelDéconnexionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDéconnexionMouseExited
        // TODO add your handling code here:
        //jLabelDéconnexion.setForeground(Color.BLACK);
        jLabelDéconnexion1.setVisible(false);
        jLabelDéconnexion.setVisible(true);
        
        
    }//GEN-LAST:event_jLabelDéconnexionMouseExited

    private void jPanelDropdownBlackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDropdownBlackMouseEntered
        // TODO add your handling code here:
        /*
        jPanelDropdown.setPreferredSize(new Dimension(200, 50));
        jPanelDropdown.setBackground(new Color(0, 0, 0, 0));
        */
    }//GEN-LAST:event_jPanelDropdownBlackMouseEntered

    private void jPanelDropdownBlackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDropdownBlackMouseExited
        // TODO add your handling code here:
        //102,255,51
        //jPanelDropdown.setBackground(new Color(102,255,51));
    }//GEN-LAST:event_jPanelDropdownBlackMouseExited

    private void jLabelMonCompte1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMonCompte1MouseEntered
        // TODO add your handling code here:
        jLabelMonCompte.setVisible(false);
        jLabelMonCompte1.setVisible(true);
    }//GEN-LAST:event_jLabelMonCompte1MouseEntered

    private void jLabelMonCompte1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMonCompte1MouseExited
        // TODO add your handling code here:
        jLabelMonCompte1.setVisible(false);
        jLabelMonCompte.setVisible(true);
  
    }//GEN-LAST:event_jLabelMonCompte1MouseExited

    private void jLabelDéconnexion1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDéconnexion1MouseEntered
        // TODO add your handling code here:
        jLabelDéconnexion.setVisible(false);
        jLabelDéconnexion1.setVisible(true);
        
    }//GEN-LAST:event_jLabelDéconnexion1MouseEntered

    private void jLabelDéconnexion1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDéconnexion1MouseExited
        // TODO add your handling code here:
        jLabelDéconnexion1.setVisible(false);
        jLabelDéconnexion.setVisible(true);
    }//GEN-LAST:event_jLabelDéconnexion1MouseExited

    private void TableauDeBordBlanc2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBlanc2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TableauDeBordBlanc2MouseEntered

    private void TableauDeBordBlanc2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBlanc2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_TableauDeBordBlanc2MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        chargerDonneesLivres(); // Appel de la méthode pour charger les données de la table "livres"
        Gestion_livres GestionLivres = new Gestion_livres();
        GestionLivres.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        //System.exit(0);        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void GestionUtilisateursBlancMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBlancMouseEntered
        // TODO add your handling code here:
        GestionUtilisateursBlanc.setVisible(false);
        GestionUtilisateursBleu.setVisible(true);
    }//GEN-LAST:event_GestionUtilisateursBlancMouseEntered

    private void GestionUtilisateursBlancMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBlancMouseExited
        // TODO add your handling code here:
        GestionUtilisateursBleu.setVisible(false);
        GestionUtilisateursBlanc.setVisible(true);
    }//GEN-LAST:event_GestionUtilisateursBlancMouseExited

    private void GestionLivresBlancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionLivresBlancMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GestionLivresBlancMouseClicked

    private void GestionLivresBlancMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionLivresBlancMouseEntered
        // TODO add your handling code here:
        GestionLivresBlanc.setVisible(false);
        GestionLivresBleu.setVisible(true);
    }//GEN-LAST:event_GestionLivresBlancMouseEntered

    private void GestionLivresBlancMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionLivresBlancMouseExited
        // TODO add your handling code here:
        GestionLivresBleu.setVisible(false);
        GestionLivresBlanc.setVisible(true);
    }//GEN-LAST:event_GestionLivresBlancMouseExited

    private void GestionEmpruntsBlancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionEmpruntsBlancMouseClicked
        // TODO add your handling code here:
        Gestion_emprunts Gestion_emprunts = new Gestion_emprunts();
        Gestion_emprunts.setVisible(true);

        dispose();
    }//GEN-LAST:event_GestionEmpruntsBlancMouseClicked

    private void GestionEmpruntsBlancMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionEmpruntsBlancMouseEntered
        // TODO add your handling code here:
        GestionEmpruntsBlanc.setVisible(false);
        GestionEmpruntsBleu.setVisible(true);
    }//GEN-LAST:event_GestionEmpruntsBlancMouseEntered

    private void GestionEmpruntsBlancMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionEmpruntsBlancMouseExited
        // TODO add your handling code here:
        GestionEmpruntsBleu.setVisible(false);
        GestionEmpruntsBlanc.setVisible(true);
    }//GEN-LAST:event_GestionEmpruntsBlancMouseExited

    private void TableauDeBordBlancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBlancMouseClicked
        // TODO add your handling code here:
        Tableau_de_bord tableau_de_bord = new Tableau_de_bord();
        tableau_de_bord.setVisible(true);
        dispose();
    }//GEN-LAST:event_TableauDeBordBlancMouseClicked

    private void TableauDeBordBlancMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBlancMouseEntered
        // TODO add your handling code here:
        TableauDeBordBlanc.setVisible(false);
        TableauDeBordBleu.setVisible(true);
    }//GEN-LAST:event_TableauDeBordBlancMouseEntered

    private void TableauDeBordBlancMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBlancMouseExited
        // TODO add your handling code here:
        TableauDeBordBleu.setVisible(false);
        TableauDeBordBlanc.setVisible(true);
    }//GEN-LAST:event_TableauDeBordBlancMouseExited

    private void TableauDeBordBleuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBleuMouseClicked
        // TODO add your handling code here:
        Tableau_de_bord tableau_de_bord = new Tableau_de_bord();
        tableau_de_bord.setVisible(true);
        dispose();
    }//GEN-LAST:event_TableauDeBordBleuMouseClicked

    private void TableauDeBordBleuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBleuMouseEntered
        // TODO add your handling code here:
        TableauDeBordBlanc.setVisible(false);
        TableauDeBordBleu.setVisible(true);
    }//GEN-LAST:event_TableauDeBordBleuMouseEntered

    private void TableauDeBordBleuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableauDeBordBleuMouseExited
        // TODO add your handling code here:
        TableauDeBordBleu.setVisible(false);
        TableauDeBordBlanc.setVisible(true);
    }//GEN-LAST:event_TableauDeBordBleuMouseExited

    private void GestionLivresBleuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionLivresBleuMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_GestionLivresBleuMouseClicked

    private void GestionLivresBleuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionLivresBleuMouseEntered
        // TODO add your handling code here:
        GestionLivresBlanc.setVisible(false);
        GestionLivresBleu.setVisible(true);
    }//GEN-LAST:event_GestionLivresBleuMouseEntered

    private void GestionLivresBleuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionLivresBleuMouseExited
        // TODO add your handling code here:
        GestionLivresBleu.setVisible(false);
        GestionLivresBlanc.setVisible(true);
    }//GEN-LAST:event_GestionLivresBleuMouseExited

    private void GestionUtilisateursBleuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBleuMouseEntered
        // TODO add your handling code here:
        GestionUtilisateursBlanc.setVisible(false);
        GestionUtilisateursBleu.setVisible(true);
    }//GEN-LAST:event_GestionUtilisateursBleuMouseEntered

    private void GestionUtilisateursBleuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBleuMouseExited
        // TODO add your handling code here:
        GestionUtilisateursBleu.setVisible(false);
        GestionUtilisateursBlanc.setVisible(true);
    }//GEN-LAST:event_GestionUtilisateursBleuMouseExited

    private void GestionEmpruntsBleuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionEmpruntsBleuMouseClicked
        // TODO add your handling code here:
        Gestion_emprunts Gestion_emprunts = new Gestion_emprunts();
        Gestion_emprunts.setVisible(true);

        dispose();
    }//GEN-LAST:event_GestionEmpruntsBleuMouseClicked

    private void GestionEmpruntsBleuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionEmpruntsBleuMouseEntered
        // TODO add your handling code here:
        GestionEmpruntsBlanc.setVisible(false);
        GestionEmpruntsBleu.setVisible(true);

    }//GEN-LAST:event_GestionEmpruntsBleuMouseEntered

    private void GestionEmpruntsBleuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionEmpruntsBleuMouseExited
        // TODO add your handling code here:
        GestionEmpruntsBleu.setVisible(false);
        GestionEmpruntsBlanc.setVisible(true);
    }//GEN-LAST:event_GestionEmpruntsBleuMouseExited

    private void GestionCotisationsBlancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionCotisationsBlancMouseClicked
        // TODO add your handling code here:
        Gestion_cotisations Gestion_cotisations = new Gestion_cotisations();
        Gestion_cotisations.setVisible(true);
        dispose();
    }//GEN-LAST:event_GestionCotisationsBlancMouseClicked

    private void GestionCotisationsBlancMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionCotisationsBlancMouseEntered
        // TODO add your handling code here:
        GestionCotisationsBlanc.setVisible(false);
        GestionCotisationsBleu.setVisible(true);
    }//GEN-LAST:event_GestionCotisationsBlancMouseEntered

    private void GestionCotisationsBlancMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionCotisationsBlancMouseExited
        // TODO add your handling code here:
        GestionCotisationsBleu.setVisible(false);
        GestionCotisationsBlanc.setVisible(true);
    }//GEN-LAST:event_GestionCotisationsBlancMouseExited

    private void GestionCotisationsBleuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionCotisationsBleuMouseClicked
        // TODO add your handling code here:
        Gestion_cotisations Gestion_cotisations = new Gestion_cotisations();
        Gestion_cotisations.setVisible(true);
        dispose();
    }//GEN-LAST:event_GestionCotisationsBleuMouseClicked

    private void GestionCotisationsBleuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionCotisationsBleuMouseEntered
        // TODO add your handling code here:
        GestionCotisationsBlanc.setVisible(false);
        GestionCotisationsBleu.setVisible(true);

    }//GEN-LAST:event_GestionCotisationsBleuMouseEntered

    private void GestionCotisationsBleuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionCotisationsBleuMouseExited
        // TODO add your handling code here:
        GestionCotisationsBleu.setVisible(false);
        GestionCotisationsBlanc.setVisible(true);
    }//GEN-LAST:event_GestionCotisationsBleuMouseExited

    private void GestionUtilisateursBlancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBlancMouseClicked
        // TODO add your handling code here:
        Gestion_utilisateurs Gestion_utilisateurs = new Gestion_utilisateurs();
        Gestion_utilisateurs.setVisible(true);
        dispose();
    }//GEN-LAST:event_GestionUtilisateursBlancMouseClicked

    private void GestionUtilisateursBleuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBleuMouseClicked
        // TODO add your handling code here:
        Gestion_utilisateurs Gestion_utilisateurs = new Gestion_utilisateurs();
        Gestion_utilisateurs.setVisible(true);
        dispose();
    }//GEN-LAST:event_GestionUtilisateursBleuMouseClicked


        
    
    
    
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
            java.util.logging.Logger.getLogger(Gestion_cotisations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_cotisations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_cotisations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_cotisations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_livres().setVisible(true);
            }
        });
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DisableSetting;
    private javax.swing.JLabel GestionCotisationsBlanc;
    private javax.swing.JLabel GestionCotisationsBleu;
    private javax.swing.JLabel GestionEmpruntsBlanc;
    private javax.swing.JLabel GestionEmpruntsBleu;
    private javax.swing.JLabel GestionLivresBlanc;
    private javax.swing.JLabel GestionLivresBleu;
    private javax.swing.JLabel GestionUtilisateursBlanc;
    private javax.swing.JLabel GestionUtilisateursBleu;
    private javax.swing.JLabel ShowSetting;
    private javax.swing.JLabel TableauDeBordBlanc;
    private javax.swing.JLabel TableauDeBordBlanc2;
    private javax.swing.JLabel TableauDeBordBleu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDéconnexion;
    private javax.swing.JLabel jLabelDéconnexion1;
    private javax.swing.JLabel jLabelMonCompte;
    private javax.swing.JLabel jLabelMonCompte1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel2Biblio;
    private javax.swing.JPanel jPanelDropdownBlack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_GestionLivres;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
