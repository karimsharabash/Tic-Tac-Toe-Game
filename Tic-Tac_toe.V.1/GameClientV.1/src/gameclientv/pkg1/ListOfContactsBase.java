package gameclientv.pkg1;

//import com.gluonhq.charm.glisten.layout.Layer;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListOfContactsBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView Back_pane;
    protected final ImageView imageView0;
    protected final VBox vBox;
    protected final Rectangle rectangle;
    protected final Label label;
    // protected final Layer layer;
    protected final Label score_pane;
    protected final Label ScoreContLable;
    protected final ImageView play_btn;

    public ListOfContactsBase(GameClientV1 client, Stage primaryStage) {

        imageView = new ImageView();
        Back_pane = new ImageView();
        imageView0 = new ImageView();
        vBox = new VBox();
        rectangle = new Rectangle();
        label = new Label();
//        layer = new Layer();
        score_pane = new Label();
        ScoreContLable = new Label();
        play_btn = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(400.0);
        imageView.setFitWidth(617.0);
        imageView.setLayoutX(-14.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("taqwa.jpeg").toExternalForm()));

        Back_pane.setFitHeight(46.0);
        Back_pane.setFitWidth(73.0);
        Back_pane.setLayoutX(14.0);
        Back_pane.setLayoutY(14.0);
        Back_pane.setPickOnBounds(true);
        Back_pane.setPreserveRatio(true);
        Back_pane.setImage(new Image(getClass().getResource("img/back.png").toExternalForm()));
        Back_pane.setCursor(Cursor.HAND);

        imageView0.setFitHeight(325.0);
        imageView0.setFitWidth(154.0);
        imageView0.setLayoutX(419.0);
        imageView0.setLayoutY(69.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("img/contact.jpg").toExternalForm()));

        vBox.setLayoutX(416.0);
        vBox.setLayoutY(69.0);
        vBox.setPrefHeight(300.0);
        vBox.setPrefWidth(154.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#75797900"));
        rectangle.setHeight(300.0);
        rectangle.setLayoutX(416.0);
        rectangle.setLayoutY(69.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStrokeWidth(3.0);
        rectangle.setWidth(154.0);

        label.setLayoutX(425.0);
        label.setLayoutY(77.0);
        label.setPrefHeight(32.0);
        label.setPrefWidth(129.0);
        label.setText("Online Players");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fffdfd"));
        label.setFont(new Font("Arial", 18.0));

        //  layer.setLayoutX(122.0);
        // layer.setLayoutY(179.0);
        score_pane.setLayoutX(80.0);
        score_pane.setLayoutY(109.0);
        score_pane.setPrefHeight(46.0);
        score_pane.setPrefWidth(85.0);
        score_pane.setText("Score");
        score_pane.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        score_pane.setFont(new Font(25.0));

        ScoreContLable.setLayoutX(165.0);
        ScoreContLable.setLayoutY(116.0);
        ScoreContLable.setPrefHeight(32.0);
        ScoreContLable.setPrefWidth(55.0);

        play_btn.setFitHeight(150.0);
        play_btn.setFitWidth(200.0);
        play_btn.setLayoutX(37.0);
        play_btn.setLayoutY(190.0);
        play_btn.setPickOnBounds(true);
        play_btn.setPreserveRatio(true);
        play_btn.setImage(new Image(getClass().getResource("img/play.gif").toExternalForm()));
        play_btn.setCursor(Cursor.HAND);
        
        getChildren().add(imageView);
        getChildren().add(Back_pane);
        getChildren().add(imageView0);
        getChildren().add(vBox);
        getChildren().add(rectangle);
        getChildren().add(label);
        //  getChildren().add(layer);
        getChildren().add(score_pane);
        getChildren().add(ScoreContLable);
        getChildren().add(play_btn);

        Back_pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                LoginNamePageBase second = new LoginNamePageBase(client, primaryStage);
                Scene scene = new Scene(second, 660, 400);
                primaryStage.setScene(scene);

            }
        });
        play_btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                GameOnlineAbs second = new GameOnlineAbs(client, primaryStage);
                Scene scene = new Scene(second, 750, 550);
                primaryStage.setScene(scene);

            }
        });
        
        for(String op : Select_Login_SignupBase.onlinePlayer)
          System.out.println(op);

    }
}
