
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public final class Tableau_de_bord extends javax.swing.JFrame {

    /**
     * Creates new form Gestion_cotisations
     */
    
    Container container;
    
    public Tableau_de_bord() {
        initComponents();
        

        
        
        jLabel5.setLocation(0, 8000);
        
        //this.setTitle("Page connexion");
        this.setTitle("Tableau de bord");
        
        
        //Etat : Activer pour l'instant
 
    // Désactiver la visibilité de la JList
    jPanelDropdownBlack.setVisible(true);
    // Désactiver la JList pour qu'elle ne soit pas cliquable
    jPanelDropdownBlack.setEnabled(true);

        
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
//setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        //jPanel33.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
// Créer une bordure pour simuler l'ombrage avec des coins arrondis
Border border = BorderFactory.createCompoundBorder(
    new LineBorder(Color.LIGHT_GRAY, 7, true), // Utiliser LineBorder avec coins arrondis
    BorderFactory.createEmptyBorder(5, 5, 5, 5) // Marge intérieure pour l'ombrage
);

// Appliquer la bordure au JPanel

jPanel34.setBorder(border);
jPanel35.setBorder(border);
jPanel37.setBorder(border);
jPanel36.setBorder(border);

//jPanel33.setBounds(90, 50, 150, 150); // Spécifier la position et la taille du JPanel

//jLabel_Tabl_Utili.setLayout(new BorderLayout());
//jPanel37.add(jLabel_Tabl_Utili, BorderLayout.CENTER);





        // Définition de la position du JLabel
        //jPanel2Biblio.add(TableauDeBordBlanc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));
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
        
      
       

//jPanel3_Tabl_Books = new RoundedPanel(50, Color.RED);
//JPANEL jPanelDropdownBlack45 = new RoundedPanel(20);

        jLabel5.setLocation(0, 8000);
        
        //this.setTitle("Page connexion");
        this.setTitle("Tableau de bord");
        
        // Etat : Activer pour l'instant
        // Désactiver la visibilité de la JList
        jPanelDropdownBlack.setVisible(true);
        // Désactiver la JList pour qu'elle ne soit pas cliquable
        jPanelDropdownBlack.setEnabled(true);

        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);  
    
    
            
mettreAJourNombreUtilisateurs(jLabel_Tabl_Utili);
mettreAJourNombreLivres(jLabel_Tabl_Livr);
mettreAJourNombreEmprunts(jLabel_Tabl_Emprunt);
mettreAJourNombreCotisations(jLabel_Tabl_Cotisation);


    
    }
    
    public void mettreAJourNombreUtilisateurs(JLabel label) {
        
            PreparedStatement ps;
            ResultSet rs;
    try {
        // Utiliser votre instance de connexion pour créer une requête SQL
        String query = "SELECT COUNT(*) FROM utilisateurs";

        
        ps = MyConnection.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        if (rs.next()) {
            int nombreUtilisateurs = rs.getInt(1);
            label.setText(" " + nombreUtilisateurs);
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        //ex.printStackTrace();
         Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    //Nombres d'utilisateur de la plateforme
    public void mettreAJourNombreLivres(JLabel label) {
    PreparedStatement ps;
    ResultSet rs;
    try {
        String query = "SELECT COUNT(*) FROM livres";
        ps = MyConnection.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        if (rs.next()) {
            int nombreLivres = rs.getInt(1);
            label.setText("" + nombreLivres);
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    //Nombres d'emprunts au niveau de la plateforme
    public void mettreAJourNombreEmprunts(JLabel label) {
    PreparedStatement ps;
    ResultSet rs;
    try {
        String query = "SELECT COUNT(*) FROM emprunts";
        ps = MyConnection.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        if (rs.next()) {
            int nombreEmprunts = rs.getInt(1);
            label.setText("" + nombreEmprunts);
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    //Nombres de cotisation au niveau de la plateforme
    public void mettreAJourNombreCotisations(JLabel label) {
    PreparedStatement ps;
    ResultSet rs;
    try {
        String query = "SELECT COUNT(*) FROM cotisations";
        ps = MyConnection.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        if (rs.next()) {
            int nombreCoisations = rs.getInt(1);
            label.setText("" + nombreCoisations);
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
    }
}



    
       
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TableauDeBordBlanc2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ShowSetting = new javax.swing.JLabel();
        DisableSetting = new javax.swing.JLabel();
        jPanelDropdownBlack = new javax.swing.JPanel();
        jLabelMonCompte = new javax.swing.JLabel();
        jLabelDéconnexion = new javax.swing.JLabel();
        jLabelMonCompte1 = new javax.swing.JLabel();
        jLabelDéconnexion1 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_Tabl_Emprunt = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Tabl_Livr = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel_Tabl_Utili = new javax.swing.JLabel();
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
        jPanel36 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel_Tabl_Cotisation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 51));

        TableauDeBordBlanc2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        TableauDeBordBlanc2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_speed_35px_4.png"))); // NOI18N
        TableauDeBordBlanc2.setText("Tableau de bord");
        TableauDeBordBlanc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableauDeBordBlanc2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TableauDeBordBlanc2MouseExited(evt);
            }
        });

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
                .addContainerGap(1171, Short.MAX_VALUE)
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

        jPanelDropdownBlack.setBackground(new java.awt.Color(255, 255, 255));
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMonCompteMouseClicked(evt);
            }
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

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel8.setText("Emprunts");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_sell_filled_65px.png"))); // NOI18N

        jLabel_Tabl_Emprunt.setFont(new java.awt.Font("Segoe UI", 0, 68)); // NOI18N
        jLabel_Tabl_Emprunt.setText("35");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel_Tabl_Emprunt))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel_Tabl_Emprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Livres");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_65px.png"))); // NOI18N

        jLabel_Tabl_Livr.setFont(new java.awt.Font("Segoe UI", 0, 68)); // NOI18N
        jLabel_Tabl_Livr.setText("35");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Tabl_Livr)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Tabl_Livr, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addGap(17, 17, 17))
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel4.setText("Utilisateurs");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_groups_65px.png"))); // NOI18N

        jLabel_Tabl_Utili.setFont(new java.awt.Font("Segoe UI", 0, 68)); // NOI18N
        jLabel_Tabl_Utili.setText("35");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Tabl_Utili))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Tabl_Utili, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23))
        );

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

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel10.setText("Cotisations");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_coins_65px.png"))); // NOI18N

        jLabel_Tabl_Cotisation.setFont(new java.awt.Font("Segoe UI", 0, 68)); // NOI18N
        jLabel_Tabl_Cotisation.setText("35");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel_Tabl_Cotisation))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Tabl_Cotisation)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2Biblio, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TableauDeBordBlanc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDropdownBlack, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TableauDeBordBlanc2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanelDropdownBlack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2Biblio, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE))
                .addContainerGap())
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

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        //System.exit(0);        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void GestionUtilisateursBlancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBlancMouseClicked
        // TODO add your handling code here:
        Gestion_utilisateurs Gestion_utilisateurs = new Gestion_utilisateurs();
        Gestion_utilisateurs.setVisible(true);
        dispose();
    }//GEN-LAST:event_GestionUtilisateursBlancMouseClicked

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
        Gestion_livres Gestion_livres = new Gestion_livres();
        Gestion_livres.setVisible(true);

        dispose();
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
        Gestion_livres Gestion_livres = new Gestion_livres();
        Gestion_livres.setVisible(true);

        dispose();
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

    private void GestionUtilisateursBleuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionUtilisateursBleuMouseClicked
        // TODO add your handling code here:
        Gestion_utilisateurs Gestion_utilisateurs = new Gestion_utilisateurs();
        Gestion_utilisateurs.setVisible(true);
        dispose();
    }//GEN-LAST:event_GestionUtilisateursBleuMouseClicked

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

    private void jLabelMonCompteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMonCompteMouseClicked
        // TODO add your handling code here:
                dispose();
        //System.exit(0);
    }//GEN-LAST:event_jLabelMonCompteMouseClicked

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
            @Override
            public void run() {
                new Tableau_de_bord().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDéconnexion;
    private javax.swing.JLabel jLabelDéconnexion1;
    private javax.swing.JLabel jLabelMonCompte;
    private javax.swing.JLabel jLabelMonCompte1;
    private javax.swing.JLabel jLabel_Tabl_Cotisation;
    private javax.swing.JLabel jLabel_Tabl_Emprunt;
    private javax.swing.JLabel jLabel_Tabl_Livr;
    private javax.swing.JLabel jLabel_Tabl_Utili;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel2Biblio;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanelDropdownBlack;
    // End of variables declaration//GEN-END:variables




}

