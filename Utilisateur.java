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

    public 
}