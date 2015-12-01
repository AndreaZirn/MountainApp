package ch.fhnw.oop2.mountains;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

import ch.fhnw.oop2.mountains.model.Mountain;
import ch.fhnw.oop2.mountains.model.MountainListModel;
import ch.fhnw.oop2.mountains.view.MountainEditDialogController;
import ch.fhnw.oop2.mountains.view.MountainOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MountainStarter extends Application {

    private static Stage primaryStage;
    private BorderPane rootLayout;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MountainApp");

        initRootLayout();

        showMountainOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MountainStarter.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the mountain overview inside the root layout.
     */
    public void showMountainOverview() {
        try {
            // Load mountain overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MountainStarter.class.getResource("view/MountainOverview.fxml"));
            AnchorPane mountainOverview = (AnchorPane) loader.load();

            // Set mountain overview into the center of root layout.
            rootLayout.setCenter(mountainOverview);

            // Give the controller access to the Model class.
            MountainOverviewController controller = loader.getController();
            MountainListModel model = new MountainListModel();
            controller.setMountainListModel(model);
            MountainStarter starter = this;
            controller.setMountainStarter(starter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified mountain. If the user
     * clicks OK, the changes are saved into the provided mountain object and true
     * is returned.
     *
     * @param mountain the mountain object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showMountainEditDialog(Mountain mountain) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MountainStarter.class.getResource("view/MountainEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Berg editieren");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the mountain into the controller.
            MountainEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMountain(mountain);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Returns the main stage.
     * @return
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }


}