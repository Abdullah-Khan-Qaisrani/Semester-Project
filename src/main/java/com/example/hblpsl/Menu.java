package com.example.hblpsl;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Menu {

//    public static void main(String[] args) {
//        launch();
//    }


    public Scene start(Stage stage, Scene scene) throws Exception {


        StackPane stackPane = new StackPane();
        Image image = new Image(getClass().getResource("/Images/page3.png").toExternalForm());
        ImageView imageView =  new ImageView(image);
        imageView.setPreserveRatio(false);
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        //scene.getStylesheets().add(getClass().getResource("/css/menu.css").toExternalForm());



        Label label =  new Label();
        label.setVisible(false);


        Button teamButton = new Button("Teams");
        teamButton.setId("teamButton");
        teamButton.setMinWidth(170);
        teamButton.setMinHeight(50);
        teamButton.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;-fx-background-color: GREEN;-fx-text-fill: WHITE;-fx-background-radius: 15px;");
        teamButton.setOnAction(e ->{
            try {
                TeamsDesign teamsDesign = new TeamsDesign();
                Stage currentStage = (Stage) teamButton.getScene().getWindow();
                currentStage.setTitle("Teams of PSL...!!!");

                Scene teamScene = new Scene(new StackPane(), 1000, 800);
                currentStage.setScene(teamsDesign.createTeamScene(currentStage,teamScene));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        });



        Button matchButton = new Button("Matches Scedule");
        matchButton.setId("matchButton");
        matchButton.setMinWidth(170);
        matchButton.setMinHeight(50);
        matchButton.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;-fx-background-color: GREEN;-fx-text-fill: WHITE;-fx-background-radius: 15px;");
        matchButton.setOnAction(e -> {
           try {
               Tournament tournament = new Tournament();
               Stage currentStage = (Stage) matchButton.getScene().getWindow();
               currentStage.setTitle("Matches of PSL...!!!");

               Scene matchScene = new Scene(new StackPane(),1000,800);
               currentStage.setScene(tournament.createSchedule(currentStage,matchScene));

           } catch (Exception e1) {
               e1.printStackTrace();
           }
        });



        Button pointButton = new Button("Points Table");
        pointButton.setId("pointButton");
        pointButton.setMinWidth(170);
        pointButton.setMinHeight(50);
        pointButton.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;-fx-background-color: GREEN;-fx-text-fill: WHITE;-fx-background-radius: 15px;");

        pointButton.setOnAction(e -> {
            try{
                PointsTableDesign pointsTableDesign = new PointsTableDesign();
                Stage currentStage5 = (Stage) pointButton.getScene().getWindow();
                currentStage5.setTitle("Points Table of PSL...!!!");

                Scene pointsTableScene = new Scene(new StackPane(),1000,800);
                currentStage5.setScene(pointsTableDesign.createPointsTableScene(currentStage5,pointsTableScene));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        HBox hBox1 = new HBox(10);
        hBox1.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); -fx-padding: 15px;");
        hBox1.setMaxWidth(700);
        hBox1.setMaxHeight(70);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(20);
        hBox1.getChildren().addAll(teamButton,matchButton,pointButton,label);



        String videoPath = getClass().getResource("/Videos/psl.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(500);
        mediaView.setFitHeight(300);

        Button playButton = new Button("Play");
        playButton.setOnAction(e -> mediaPlayer.play());
        playButton.setMinWidth(60);
        playButton.setMinHeight(25);
        playButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> mediaPlayer.pause());
        pauseButton.setMinWidth(60);
        pauseButton.setMinHeight(25);
        pauseButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");


        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(playButton,pauseButton);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        VBox videoControls = new VBox(-30, mediaView, hBox);
        videoControls.setAlignment(Pos.CENTER);

        VBox mainBox = new VBox(10);
        mainBox.getChildren().addAll(hBox1,videoControls);
        mainBox.setSpacing(160);
        mainBox.setAlignment(Pos.CENTER);


        stackPane.getChildren().addAll(imageView,mainBox);

        return new Scene(stackPane,1000,800);
    }


}
