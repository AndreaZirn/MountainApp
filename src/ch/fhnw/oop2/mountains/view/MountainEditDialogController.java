package ch.fhnw.oop2.mountains.view;

import ch.fhnw.oop2.mountains.model.Mountain;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class MountainEditDialogController {

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


    private Stage dialogStage;
    private Mountain mountain;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param mountain
     */
    public void setMountain(Mountain mountain) {
        this.mountain = mountain;

        nameField.setText(mountain.getName());
        hoeheField.setText(String.valueOf(mountain.getHoehe()));
        dominanzField.setText(String.valueOf(mountain.getDominanz()));
        kmBisField.setText(mountain.getKmBis());
        mBisField.setText(mountain.getmBis());
        schartenhoeheField.setText(String.valueOf(mountain.getSchartenhoehe()));
        typField.setText(mountain.getTyp());
        regionField.setText(mountain.getRegion());
        kantonField.setText(mountain.getKanton());
        gebietField.setText(mountain.getGebiet());
        bildunterschriftField.setText(mountain.getBildunterschrift());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            mountain.setName(nameField.getText());
            mountain.setHoehe(Double.parseDouble(hoeheField.getText()));
            mountain.setDominanz(Double.parseDouble(dominanzField.getText()));
            mountain.setKmBis(kmBisField.getText());
            mountain.setmBis(mBisField.getText());
            mountain.setSchartenhoehe(Double.parseDouble(schartenhoeheField.getText()));
            mountain.setTyp(typField.getText());
            mountain.setRegion(mountain.getRegion());
            mountain.setKanton(mountain.getKanton());
            mountain.setGebiet(mountain.getGebiet());
            mountain.setBildunterschrift(mountain.getBildunterschrift());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "Kein gültiger Name!\n";
        }
        if (hoeheField.getText() == null || hoeheField.getText().length() == 0) {
            errorMessage += "Keine gültige Höhe!\n";
        } else {
            // try to parse the Hoehe code into a double.
            try {
                Double.parseDouble(hoeheField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Kein gültiger Wert. Geben Sie eine Zahl ein!\n";
            }
        }
        if (dominanzField.getText() == null || dominanzField.getText().length() == 0) {
            errorMessage += "Keine gültige Dominanz!\n";
        } else {
            // try to parse the Dominanz code into a double.
            try {
                Double.parseDouble(dominanzField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Kein gültiger Wert. Geben Sie eine Zahl ein!\n";
            }
        }
        if (schartenhoeheField.getText() == null || schartenhoeheField.getText().length() == 0) {
            errorMessage += "Keine gültige Schartenhöhe!\n";
        } else {
            // try to parse the schartenhoehe code into a double.
            try {
                Double.parseDouble(schartenhoeheField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Kein gültiger Wert. Geben Sie eine Zahl ein!\n";
            }
        }
        if (kmBisField.getText() == null || kmBisField.getText().length() == 0) {
            errorMessage += "Kein gültiger Wert!\n";
        }

        if (mBisField.getText() == null || mBisField.getText().length() == 0) {
            errorMessage += "Kein gültiger Wert!\n";
        }
        if (typField.getText() == null || typField.getText().length() == 0) {
            errorMessage += "Kein gültiger Wert!\n";
        }
        if (regionField.getText() == null || regionField.getText().length() == 0) {
            errorMessage += "Kein gültiger Wert!\n";
        }
        if (kantonField.getText() == null || kantonField.getText().length() == 0) {
            errorMessage += "Kein gültiger Wert!\n";
        }
        if (gebietField.getText() == null || gebietField.getText().length() == 0) {
            errorMessage += "Kein gültiger Wert!\n";
        }
        if (bildunterschriftField.getText() == null || bildunterschriftField.getText().length() == 0) {
            errorMessage += "Kein gültiger Wert!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
