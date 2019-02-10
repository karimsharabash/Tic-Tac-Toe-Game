package gameclientv.pkg1;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListOfContactsBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final Lighting lighting;
    protected final Label label;
    protected final ImageView Back_pane;
    protected final ImageView imageView0;
    protected final Pane Play_pane;

    public ListOfContactsBase(GameClientV1 client,Stage primaryStage) {

        imageView = new ImageView();
        tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        lighting = new Lighting();
        label = new Label();
        Back_pane = new ImageView();
        imageView0 = new ImageView();
        Play_pane = new Pane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(400.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(-1.0);
        imageView.setLayoutY(1.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("taqwa.jpeg").toExternalForm()));

        tableView.setEditable(true);
        tableView.setFixedCellSize(1.0);
        tableView.setLayoutX(180.0);
        tableView.setLayoutY(65.0);
        tableView.setNodeOrientation(javafx.geometry.NodeOrientation.LEFT_TO_RIGHT);
        tableView.setOpacity(0.97);
        tableView.setPrefHeight(305.0);
        tableView.setPrefWidth(204.0);

        tableColumn.setPrefWidth(75.0);
        tableColumn.setText("Player");

        tableColumn0.setPrefWidth(75.0);
        tableColumn0.setText("Score");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setCursor(Cursor.HAND);
        tableView.setEffect(lighting);

        label.setLayoutX(155.0);
        label.setLayoutY(-8.0);
        label.setPrefHeight(84.0);
        label.setPrefWidth(272.0);
        label.setText("Choose a player to compete with...");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#f5ecec"));
        label.setFont(new Font("Bell MT Italic", 20.0));

        Back_pane.setFitHeight(46.0);
        Back_pane.setFitWidth(73.0);
        Back_pane.setLayoutX(14.0);
        Back_pane.setLayoutY(14.0);
        Back_pane.setPickOnBounds(true);
        Back_pane.setPreserveRatio(true);
        Back_pane.setImage(new Image(getClass().getResource("img/back.png").toExternalForm()));
        Back_pane.setCursor(Cursor.HAND);

        imageView0.setFitHeight(71.0);
        imageView0.setFitWidth(118.0);
        imageView0.setLayoutX(431.0);
        imageView0.setLayoutY(196.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("img/play.gif").toExternalForm()));

        Play_pane.setLayoutX(432.0);
        Play_pane.setLayoutY(200.0);
        Play_pane.setPrefHeight(42.0);
        Play_pane.setPrefWidth(126.0);
        Play_pane.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        getChildren().add(tableView);
        getChildren().add(label);
        getChildren().add(Back_pane);
        getChildren().add(imageView0);
        getChildren().add(Play_pane);

        Back_pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                LoginNamePageBase second = new LoginNamePageBase(client,primaryStage);
                Scene scene = new Scene(second,660,400);
                primaryStage.setScene(scene);

            }
        });
          Play_pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                GameOnlineAbs second = new GameOnlineAbs(client,primaryStage);
                Scene scene = new Scene(second,660,400);
                primaryStage.setScene(scene);

            }
        });
         for(String op : Select_Login_SignupBase.onlinePlayer)
          System.out.println(op);
    }
}
