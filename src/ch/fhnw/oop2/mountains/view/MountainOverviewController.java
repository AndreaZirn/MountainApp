package ch.fhnw.oop2.mountains.view;



import ch.fhnw.oop2.mountains.model.Mountain;
import ch.fhnw.oop2.mountains.model.MountainListModel;
import javafx.fxml.FXML;
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
        mountainTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->
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

    /**
     * Fills all text fields to show details about the mountain.
     * If the specified mountain is null, all text fields are cleared.
     *
     * @param mountain the mountain or null
     */
    private void showMountainDetails(Mountain mountain) {
        if (mountain != null) {
            // Fill the labels with info from the mountain object.
         //   idLabel.setText(String.valueOf(mountain.getId()));
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
         //   idLabel.setText("");
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


}

