
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class TableActionsCellEditor_Btn_Emprunt_Utilisateur extends DefaultCellEditor {
    
    private TableActionEvent_Utilisateurs event;
    
    public TableActionsCellEditor_Btn_Emprunt_Utilisateur(TableActionEvent_Utilisateurs event) {
        super(new JCheckBox());
        
         this.event = event;
    }
    
        @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       
       ButtonEmprunter actionEmprunt = new ButtonEmprunter();
       actionEmprunt.initEvent(event, row);
       actionEmprunt.setBackground(table.getSelectionBackground());

        return actionEmprunt;
    }
}
    

