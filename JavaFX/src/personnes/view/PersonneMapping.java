package personnes.view;

import personnes.MainClass;
import personnes.model.Personne;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonneMapping {
	@FXML
    private TableView<Personne> personneTable;
    @FXML
    private TableColumn<Personne, String> nomColonne;
    @FXML
    private TableColumn<Personne, String> prenomColonne;
    @FXML
    private Label nomValeur;
    @FXML
    private Label prenomValeur;
    @FXML
    private Label dateValeur;
    @FXML
    private Label sexeValeur;
    
    //Objet servant de r�f�rence � notre classe principale
    //afin de pouvoir r�cup�rer la liste de nos objets.
    private MainClass main;

    //Un constructeur par d�faut
    public PersonneMapping() { }

    //M�thode qui initialise notre interface graphique
    //avec nos donn�es m�tier
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        nomColonne.setCellValueFactory(cellData -> cellData.getValue().getNom());
        prenomColonne.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
    }

    //M�thode qui sera utilis�e dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
        // On lie notre liste observable au composant TableView
        personneTable.setItems(main.getListDePersonne());
    }
}
