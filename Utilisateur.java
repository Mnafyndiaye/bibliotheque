import java.util.ArrayList;

public class Utilisateur {
    private String nom;
    private int numId;
    private  boolean estAJourCotisation;
    private ArrayList<Livre> livresEmpruntes;

    //Constructeur
    public Utilisateur(String nom, int numId){
        this.nom = nom;
        this.numId= numId;
        this.estAJourCotisation = false;
        this.livresEmpruntes = new ArrayList<>();
    }

    //getteur et setteur
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public int getNumId(){
        return numId;
    }
    public void setNumId(int numId){
        this.numId = numId;
    }

    public  boolean isEstAjourCotisation(){
        return estAJourCotisation;
    }
    public  void setEstAjourCotisation(boolean estAjourCotisation) {
        this.estAJourCotisation = estAjourCotisation ;
    }

    public ArrayList<Livre>  getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public void emprunterLivre(Livre livre){
        if(estAJourCotisation){
            livresEmpruntes.add(livre);
            System.out.println("L'utilisateur" + nom + "a emprunté " + livre.getTitre() + ".");
        }else{
            System.out.println("L'utilisateur" + nom + "n'est pas à jour sur sa cotisation" );
        }
    }

    public void retournerLivre(Livre livre){
        livresEmpruntes.remove(livre);
        System.out.println("L'utilisateur " + nom + " a retourné le livre : " + livre.getTitre());
    }

    public void afficherLivresEmpruntes(Livre livre){
        if(livresEmpruntes.isEmpty()){
            System.out.println("Pas de livres empruntés par l'utilisateur " + nom);
        } else {
            for (Livre livre : livresEmpruntes) {
                System.out.print(livre);
            }
        }    
    }

    
}