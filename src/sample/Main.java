package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {
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
      /*  txt.setOnMouseClicked(event -> {
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
        VBox vbox2 = new VBox(20);
        RadioButton rbtnMale = new RadioButton("Male");
        RadioButton rbtnFemale = new RadioButton("Female");
        ToggleGroup tg = new ToggleGroup();
        rbtnMale.setToggleGroup(tg);
        rbtnFemale.setToggleGroup(tg);
        GridPane gridPane = new GridPane();
        Label lblGender = new Label("Gender:");
        gridPane.addColumn(2, lblGender, rbtnMale, rbtnFemale);
        //Rectangle rect = new Rectangle(0, 0, 100, 100);
        //rect.setStyle("-fx-background-color: transparent;");
        Tooltip t = new Tooltip("A tool tip");
        Tooltip.install(btn, t);
        t.setStyle("-fx-background-color: red;");
        //rbtnFemale.setTooltip(t);
        // gridPane.add(rbtnMale,2,2);
        //gridPane.add(rbtnFemale,2,3);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        String data[] = {"Select", "Java", "Python", "Go"};
        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(data));
        comboBox.getSelectionModel().selectFirst();
        ListView<String> listView= new ListView<>(FXCollections.observableArrayList(data));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setPrefWidth(3);
        ScrollBar scrollBar=new ScrollBar();
        scrollBar.setMax(10);
        scrollBar.setMin(0);
        TilePane tilePane=new TilePane();
        tilePane.getChildren().add(scrollBar);
        pane.setBottom(tilePane);
        tilePane.setAlignment(Pos.CENTER);
        //comboBox.setItems(FXCollections.observableArrayList(data));
        gridPane.add(comboBox, 2, 4);
        gridPane.add(listView, 2, 5);
        //vbox2.getChildren().addAll(rbtnMale,rbtnFemale);
        //vbox2.setPadding(new Insets(10,30,10,30));
        pane.setLeft(gridPane);
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(3);
        textArea.setPrefRowCount(3);
        pane.setCenter(textArea);
        pane.setPadding(new Insets(20, 20, 20, 20));
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox2.setPadding(new Insets(20, 20, 20, 20));
        hb.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        btn.setOnAction(new Controller(txt, cb1, cb2));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 600, 375));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
