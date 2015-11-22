package ch.fhnw.oop2.mountains.view;


import ch.fhnw.oop2.mountains.model.Mountain;
import ch.fhnw.oop2.mountains.model.MountainListModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * Created by andreazirn on 17/11/15.
 */
public class MountainOverviewController {

    @FXML
    private TableView<Mountain> mountainTable;
    @FXML
    private TableColumn<Mountain, Integer> idColumn;
    @FXML
    private TableColumn<Mountain, String> nameColumn;
    @FXML
    private TableColumn<Mountain, String> hoeheColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label hoeheLabel;
    @FXML
    private Label dominanzLabel;
    @FXML
    private Label kmBisLabel;
    @FXML
    private Label SchartenhoeheLabel;
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
        //hoeheColumn.setCellValueFactory(cellData -> cellData.getValue().hoeheProperty().asObject());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mountainListModel
     */
    public void setMountainStarter(MountainListModel mountainListModel) {
        this.mountainListModel = mountainListModel;

        // Add observable list data to the table
        mountainTable.setItems(mountainListModel.getMountain());
    }
}

