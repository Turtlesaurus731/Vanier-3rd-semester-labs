/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


/**
 *
 * @author patrick huy the tran
 */
public class SlideShowController implements Initializable{

    @FXML
    private ImageView carSlideImageView;

    @FXML
    private VBox rootSlideShow;
    
    private MediaPlayer mediaPlayer;
    
    private final String[] carImages = {
      "/car01.png",  
      "/car02.png",  
      "/car03.png",  
      "/car04.png"  
    };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playAudio();
        cycleImage();
    }
    
    /**
     * Loads and loops audio track indefinitely 
     */
    private void playAudio() {
        URL resources = getClass().getResource("/guitar.wav");
        if (resources != null) {
            Media media = new Media(resources.toExternalForm());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } else {
            System.out.println("file not found");
        }
    }
    
    /**
     * Plays a SequentialTransition that pauses for 3 seconds between car images
     * After the final image and pause, it stops the audio and switches scene
     */
    private void cycleImage() {
        SequentialTransition sequentialTransition = new SequentialTransition();
        
        // loop trhough every carImage, pause then change image in imageView
        for (int i = 0; i < carImages.length; i++) {
            final int idx = i;
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e ->{
                Image image = new Image(carImages[idx]);
                carSlideImageView.setImage(image);
            });
            sequentialTransition.getChildren().add(pause);
        }
        
        // add extra 3 second pause to see car04 better
        sequentialTransition.getChildren().add(
                new PauseTransition(Duration.seconds(3)
                ));
        
        sequentialTransition.setOnFinished(e -> {
            try {
                mediaPlayer.stop();
                App.setRoot("CarRaceFXML");
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        });
        sequentialTransition.play();
    } 
}
