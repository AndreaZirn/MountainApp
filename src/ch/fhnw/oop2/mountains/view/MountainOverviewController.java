package ch.fhnw.oop2.mountains.view;


import ch.fhnw.oop2.mountains.MountainStarter;
import ch.fhnw.oop2.mountains.model.Mountain;
import ch.fhnw.oop2.mountains.model.MountainListModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


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
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField hoeheField;
    @FXML
    private TextField dominanzField;
    @FXML
    private TextField kmBisField;
    @FXML
    private TextField mBisField;
    @FXML
    private TextField schartenhoeheField;
    @FXML
    private TextField typField;
    @FXML
    private TextField regionField;
    @FXML
    private TextField kantonField;
    @FXML
    private TextField gebietField;
    @FXML
    private TextField bildunterschriftField;


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
     * Is called by the mountainListModel class to give a reference back to itself.
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
            nameField.setText(mountain.getName());
            hoeheField.setText(String.valueOf(mountain.getHoehe()));
            dominanzField.setText(Integer.toString((int) mountain.getDominanz()));
            kmBisField.setText(mountain.getKmBis());
            mBisField.setText(mountain.getmBis());
            schartenhoeheField.setText(String.valueOf(mountain.getSchartenhoehe()));
            typField.setText(mountain.getTyp());
            regionField.setText(mountain.getRegion());
            kantonField.setText(mountain.getKanton());
            gebietField.setText(mountain.getGebiet());
            bildunterschriftField.setText(mountain.getBildunterschrift());

            //Editing and Binding
            // TODO: Fehlermeldung wenn der falsche Wert eingegeben wird
            nameField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.length() < 5) mountain.nameProperty().setValue(newValue);
            });
            hoeheField.textProperty().addListener((observable, oldValue, newValue) ->
                mountain.hoeheProperty().setValue(Double.parseDouble(newValue)));
            dominanzField.textProperty().addListener((observable, oldValue, newValue) ->
                mountain.dominanzProperty().setValue(Double.parseDouble(newValue)));
            kmBisField.textProperty().addListener((observable, oldValue, newValue) ->
                mountain.kmBisProperty().setValue(newValue));
            mBisField.textProperty().addListener((observable, oldValue, newValue) ->
                mountain.mBisProperty().setValue(newValue));
            schartenhoeheField.textProperty().addListener((observable, oldValue, newValue) ->
                mountain.schartenhoeheProperty().setValue(Double.parseDouble(newValue)));
            typField.textProperty().addListener((observable, oldValue, newValue) ->
                mountain.typProperty().setValue(newValue));
            regionField.textProperty().addListener((observable, oldValue, newValue) ->
                    mountain.regionProperty().setValue(newValue));
            kantonField.textProperty().addListener((observable, oldValue, newValue) ->
                    mountain.kantonProperty().setValue(newValue));
            gebietField.textProperty().addListener((observable, oldValue, newValue) ->
                    mountain.gebietProperty().setValue(newValue));
            bildunterschriftField.textProperty().addListener((observable, oldValue, newValue) ->
                    mountain.bildunterschriftProperty().setValue(newValue));

        } else {
            // Mountain is null, remove all the text.
            nameField.setText("");
            hoeheField.setText("");
            dominanzField.setText("");
            kmBisField.setText("");
            mBisField.setText("");
            schartenhoeheField.setText("");
            typField.setText("");
            regionField.setText("");
            kantonField.setText("");
            gebietField.setText("");
            bildunterschriftField.setText("");
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new mountain.
     */
    /*@FXML
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
  /*  @FXML
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


    /**
     * Called when the user clicks on the delete button.
     */
   /* @FXML
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
*/
}

