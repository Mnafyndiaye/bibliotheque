/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public interface TableActionEvent_Livres {
    // Méthode appelée lors de la modification d'une ligne
    void onEdit(int row);
    
    // Méthode appelée lors de la suppression d'une ligne
    void onDelete(int row);
    
    // Méthode appelée lors de l'affichage d'une ligne
    void onView(int row);
}
