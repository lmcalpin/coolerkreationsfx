package com.metatrope;

import com.metatrope.model.UserSelections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entrypoint for the JavaFX application.
 * 
 * @author Lawrence McAlpin
 */
public class CoolerKreations extends Application {
    public static CoolerKreations APP;
    
    public UserSelections options = new UserSelections();

    private Stage stage;
    
    public enum Screens {
        INPUT(new InputScreen()),
        ART(new ArtScreen());
        
        public Screen screen;
        public Scene scene;
        private Screens(Screen screen) {
            this.screen = screen;
            this.scene = screen.getScene();
        }
        public void switchTo() {
            CoolerKreations.APP.stage.setScene(this.scene);
            this.screen.onDisplay();
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        APP = this;
        this.stage = stage;
        
        int widthX = 800;
        int widthY = 600;
        
        stage.setWidth(widthX);
        stage.setHeight(widthY);
        stage.setScene(Screens.INPUT.scene);
        stage.setTitle("CoolerKreationsFX");
        
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }
}
