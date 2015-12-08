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
public class RootLayoutController {

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
    private MountainOverviewController mountainOverviewController;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public RootLayoutController() {
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

    public void setMountainOverviewController(MountainOverviewController mountainOverviewController){
        this.mountainOverviewController = mountainOverviewController;
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
                mountainOverviewController.showMountainDetails(selectedMountain);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MountainStarter.getPrimaryStage());
            alert.setTitle("Keine Auswahl");
            alert.setHeaderText("Es wurde kein Berg ausgew�hlt");
            alert.setContentText("Bitte w�hle einen Berg aus.");

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteMountain() {
        int selectedIndex = mountainTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            //TODO: Sicherheitsmeldung vor dem L�schen
            mountainTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MountainStarter.getPrimaryStage());
            alert.setTitle("Fehlende Auswahl");
            alert.setHeaderText("Es wurde kein Berg ausgew�hlt");
            alert.setContentText("Um einen Berg zu l�schen, muss dieser zuerst in der Liste ausgew�hlt werden");

            alert.showAndWait();
        }
    }
}
























//zu Testzwecken auskommentiert; NICHT relevant
/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 *
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 *//*

public class RootLayoutController {

    // Reference to the MountainListModel class
    private MountainListModel mountainListModel;

    // Reference to the starter class
    private MountainStarter mountainStarter;

    /**
     * Is called by the starter class to give a reference back to itself.
     *
     * @param MountainListModel
     *//*
    public void MountainListModel(MountainListModel mountainListModel) {
        this.mountainListModel = mountainListModel;
    }

    /**
     * Creates an empty mountain.
     *//*
    @FXML
    private void handleNew() {
       mountainStarter.getMountain().clear();
        mountainStarter.setMountainFilePath(null);
    }
    /**
     * Opens a FileChooser to let the user select an address book to load.
     *//*
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mountainStarter.getPrimaryStage());

        if (file != null) {
            mountainStarter.loadMountainFromFile(file);
        }
    }

    /**
     * Saves the file to the mountain file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     *//*
    @FXML
    private void handleSave() {
        File mountainFile = mountainStarter.getMountainFilePath();
        if (mountainFile != null) {
            mountainStarter.saveMountainToFile(mountainFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     *//*
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mountainStarter.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mountainStarter.saveMountainToFile(file);
        }
    }

    /**
     * Opens an about dialog.
     *//*
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");

        alert.showAndWait();
    }

    /**
     * Closes the application.
     *//*
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}*/