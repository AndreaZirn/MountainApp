package ch.fhnw.oop2.mountains.view;
import java.io.File;

import ch.fhnw.oop2.mountains.MountainStarter;
import ch.fhnw.oop2.mountains.model.MountainListModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

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
     * Creates an empty address book.
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