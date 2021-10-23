package sample.GestionReservation.model;

public class Hotel {
    private  String id;
    private  String nom;
    private int etoile;
    private  String lieu;
    private String hebergement;
    private  String Path_image ;
    private  String Path_video ;
    private String chambre ;
    private double prix;


    public Hotel(String id, String nom, int etoile, String lieu, String hebergement, String path_image, String path_video, String chambre,double prix) {
        this.id = id;
        this.nom = nom;
        this.etoile = etoile;
        this.lieu = lieu;
        this.hebergement = hebergement;
        this.Path_image = path_image;
        this.Path_video = path_video;
        this.chambre = chambre;
        this.prix= prix;

    }


    public String getPath_image() {
        return Path_image;
    }

    public String getPath_video() {
        return Path_video;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getChambre() {
        return chambre;
    }

    public int getEtoile() {
        return etoile;
    }

    public String getLieu() {
        return lieu;
    }

    public String getHebergement() {
        return hebergement;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", etoile=" + etoile +
                ", lieu='" + lieu + '\'' +
                ", hebergement='" + hebergement + '\'' +
                ", Path_image='" + Path_image + '\'' +
                ", Path_video='" + Path_video + '\'' +
                ", chambre='" + chambre + '\'' +
                ", prix=" + prix +
                '}';
    }
}
