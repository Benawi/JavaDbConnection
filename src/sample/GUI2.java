


package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GUI2 extends Application {
    public TextField txt;
    CheckBox cb1, cb2;
    Button btn;
    String str, str2 = ", you did not select any course";

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane pane = new BorderPane();
        Label lbl = new Label("fxLabel");
        txt = new TextField();
        btn = new Button("Submit");
        HBox hb = new HBox(20);
        hb.getChildren().addAll(lbl, txt, btn);
        hb.setAlignment(Pos.BASELINE_CENTER);
        pane.setTop(hb);
        /*txt.setOnMouseClicked(event -> {
            txt.setText("why you click me");
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Again why you click me");
            a.show();

        });*/
        VBox vbox = new VBox(20);
        Label lbl3 = new Label("Please choose one or more ");
        cb1 = new CheckBox("Java");
        cb2 = new CheckBox("python");
        vbox.getChildren().addAll(lbl3, cb1, cb2);
        pane.setRight(vbox);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                //Main m = new Main();
                //if (event.getSource()==m.btn)
                str = txt.getText();
                str = txt.getText();
                if (cb1.isSelected() && cb2.isSelected())
                    str2 = cb1.getText() + " and " + cb2.getText();
                else if (cb1.isSelected())
                    str2 = cb1.getText();
                else if (cb2.isSelected())
                    str2 = cb2.getText();
                Alert a = new Alert(Alert.AlertType.WARNING, str + str2);
                a.show();
            }
        };
        Tooltip tooltip = new Tooltip("tool tip text");
        tooltip.setStyle("-fx-background-color:red;-fx-font-size:20;");
        Tooltip.install(btn, tooltip);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        RadioButton rbtnMale = new RadioButton("Male");
        RadioButton rbtnFemale = new RadioButton("Female");
        rbtnFemale.getText();
        ToggleGroup group = new ToggleGroup();
        rbtnFemale.setToggleGroup(group);
        rbtnMale.setToggleGroup(group);
        //rbtnFemale.setPadding(new Insets(15,20,20,15));
        String[] data = {"Please select", "Java", "Python", "Fortran"};
        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(data));
        comboBox.getSelectionModel().selectFirst();
        ListView listView = new ListView();
        listView.setItems(FXCollections.observableArrayList(data));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        gridPane.setAlignment(Pos.BASELINE_CENTER);
        gridPane.add(comboBox, 2, 3);
        gridPane.add(listView, 2, 4);
        gridPane.addColumn(2, rbtnMale, rbtnFemale);

        pane.setLeft(gridPane);
        txt.setTooltip(tooltip);
        btn.setOnAction(new Controller(txt, cb1, cb2));
        //btn.setOnAction(event);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 600, 375));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
