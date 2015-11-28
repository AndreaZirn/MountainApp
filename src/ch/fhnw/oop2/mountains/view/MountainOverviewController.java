package ch.fhnw.oop2.mountains.view;


import ch.fhnw.oop2.mountains.MountainStarter;
import ch.fhnw.oop2.mountains.model.Mountain;
import ch.fhnw.oop2.mountains.model.MountainListModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class MountainOverviewController {

    @FXML
    private TableView<Mountain> mountainTable;
    @FXML
    private TableColumn<Mountain, Integer> idColumn;
    @FXML
    private TableColumn<Mountain, String> nameColumn;
    @FXML
    private TableColumn<Mountain, Double> hoeheColumn;

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label hoeheLabel;
    @FXML
    private Label dominanzLabel;
    @FXML
    private Label kmBisLabel;
    @FXML
    private Label mBisLabel;
    @FXML
    private Label schartenhoeheLabel;
    @FXML
    private Label typLabel;
    @FXML
    private Label regionLabel;
    @FXML
    private Label kantonLabel;
    @FXML
    private Label gebietLabel;
    @FXML
    private Label bildunterschriftLabel;


    // Reference to the mountain list model
    private MountainListModel mountainListModel;
    private MountainStarter mountainStarter;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MountainOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the mountain table with the three columns.
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        hoeheColumn.setCellValueFactory(cellData -> cellData.getValue().hoeheProperty().asObject());

        //Clear mountain details
        showMountainDetails(null);

        //Listen for selection changes and show the mountain details when changed
        mountainTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                showMountainDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mountainListModel
     */
    public void setMountainListModel(MountainListModel mountainListModel) {
        this.mountainListModel = mountainListModel;

        // Add observable list data to the table
        mountainTable.setItems(mountainListModel.getMountain());
    }

   public void setMountainStarter(MountainStarter mountainStarter) {
        this.mountainStarter = mountainStarter;
    }


    /**
     * Fills all text fields to show details about the mountain.
     * If the specified mountain is null, all text fields are cleared.
     *
     * @param mountain the mountain or null
     */
    public void showMountainDetails(Mountain mountain) {
        if (mountain != null) {
            // Fill the labels with info from the mountain object.
            nameLabel.setText(mountain.getName());
            hoeheLabel.setText(String.valueOf(mountain.getHoehe()));
            dominanzLabel.setText(Integer.toString((int) mountain.getDominanz()));
            kmBisLabel.setText(mountain.getKmBis());
            mBisLabel.setText(mountain.getmBis());
            schartenhoeheLabel.setText(String.valueOf(mountain.getSchartenhoehe()));
            typLabel.setText(mountain.getTyp());
            regionLabel.setText(mountain.getRegion());
            kantonLabel.setText(mountain.getKanton());
            gebietLabel.setText(mountain.getGebiet());
            bildunterschriftLabel.setText(mountain.getBildunterschrift());
        } else {
            // Mountain is null, remove all the text.
            nameLabel.setText("");
            hoeheLabel.setText("");
            dominanzLabel.setText("");
            kmBisLabel.setText("");
            mBisLabel.setText("");
            schartenhoeheLabel.setText("");
            typLabel.setText("");
            regionLabel.setText("");
            kantonLabel.setText("");
            gebietLabel.setText("");
            bildunterschriftLabel.setText("");
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteMountain() {
        int selectedIndex = mountainTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            //TODO: Sicherheitsmeldung vor dem Löschen
            mountainTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MountainStarter.getPrimaryStage());
            alert.setTitle("Fehlende Auswahl");
            alert.setHeaderText("Es wurde kein Berg ausgewählt");
            alert.setContentText("Um einen Berg zu löschen, muss dieser zuerst in der Liste ausgewählt werden");

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new mountain.
     */
    @FXML
    private void handleNewMountain() {
        Mountain tempMountain = new Mountain();
        boolean okClicked = mountainStarter.showMountainEditDialog(tempMountain);
        if (okClicked) {
            mountainListModel.getMountain().add(tempMountain);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected mountain.
     */
    @FXML
    private void handleEditMountain() {
        Mountain selectedMountain = mountainTable.getSelectionModel().getSelectedItem();
        if (selectedMountain != null) {
            boolean okClicked = mountainStarter.showMountainEditDialog(selectedMountain);
            if (okClicked) {
                showMountainDetails(selectedMountain);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MountainStarter.getPrimaryStage());
            alert.setTitle("Keine Auswahl");
            alert.setHeaderText("Es wurde kein Berg ausgewählt");
            alert.setContentText("Bitte wähle einen Berg aus.");

            alert.showAndWait();
        }
    }
}