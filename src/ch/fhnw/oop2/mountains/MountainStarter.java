package ch.fhnw.oop2.mountains;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

import ch.fhnw.oop2.mountains.view.MountainOverviewController;
import ch.fhnw.oop2.mountains.model.MountainListModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MountainStarter extends Application {

    private Stage primaryStage;
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

            // Give the controller access to the main app.
            MountainOverviewController controller = loader.getController();
            MountainListModel model = new MountainListModel();
            controller.setMountainListModel(model);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }


}