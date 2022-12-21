package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

public class Controller implements EventHandler<ActionEvent> {
    String str, str2 = null;
    TextField txt;
    CheckBox cb1, cb2;
    Alert al = new Alert(Alert.AlertType.INFORMATION);

    Controller(TextField txt, CheckBox cb1, CheckBox cb2) {
        this.txt = txt;
        this.cb1 = cb1;
        this.cb2 = cb2;
    }

    @Override
    public void handle(ActionEvent event) {


        str = txt.getText();
        str = txt.getText();
        if (cb1.isSelected() && cb2.isSelected())
            str2 = cb1.getText() + " and " + cb2.getText();
        else if (cb1.isSelected())
            str2 = cb1.getText();
        else if (cb2.isSelected())
            str2 = cb2.getText();

        ConnectionDB connectionDB=new ConnectionDB();
        connectionDB.conMethod();


        //queryHandler();
        //Alert a = new Alert(Alert.AlertType.WARNING, "this is out class handler11" + str + str2);
        //a.show();
    }

    private void queryHandler() {
        try {
            String query = "Insert into stud(NAME,COURSE) VALUES('" + str + "','" + str2 + "')";
            DBConnection db = new DBConnection();
            Connection connection = db.connMethod();
            Statement statement = connection.createStatement();
            boolean status = statement.execute(query);
            if (!status) {
                al.setContentText("successfuly inserted");
                al.showAndWait();
            } else {
                al.setContentText("Not successfuly inserted");
                al.showAndWait();
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }

}

