package com.metatrope;

import static com.metatrope.utils.MathUtil.randomInt;

import com.metatrope.utils.CheckedExceptionsAreStupidException;
import com.metatrope.utils.MathUtil;

import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * Take input to use when generating the art.
 * 
 * @author Lawrence McAlpin
 * 
 */
public class InputScreen implements Screen {
    private Group root;
    private Group backgroundSwirlyStuff;
    private VBox inputForm;
    private Scene scene;

    public InputScreen() {
        this.root = new Group();
        
        // the UI we use to get the user customizations (initially just the tag to search for,
        // and eventually more) is encapsulated in an FXML file which we load and attach
        // to the scene.
        try {
            this.inputForm = FXMLLoader.load(getClass().getResource("input.fxml"));
            this.inputForm.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        } catch (IOException e) {
            throw new CheckedExceptionsAreStupidException(e);
        }
        
        // the UI will be displayed over a background with rotating circle things
        this.backgroundSwirlyStuff = createBackground();

        // construct scene
        this.root.getChildren().add(backgroundSwirlyStuff);
        this.root.getChildren().add(inputForm);
        this.scene = new Scene(root, Color.BLACK);
    }

    public Scene getScene() {
        return scene;
    }

    public void onDisplay() {

    }

    private Group createBackground() {
        Effect circleEffect = createEffect();

        // set up circles
        Group layers = new Group();
        String[] colorHex = new String[] { "ffff00", "ffff30", "ff3f3f" };
        for (int layerNumber = 0; layerNumber < 3; layerNumber++) {
            Group layer = new Group();
            int numberOfCircles = randomInt(5, 15);
            for (int i = 0; i < numberOfCircles; i++) {
                Circle circle = createCircle(colorHex[layerNumber]);
                // this is where the circles will initially appear (x, y coords)
                circle.setTranslateX(randomInt(0, 800));
                circle.setTranslateY(randomInt(0, 600));
                layer.getChildren().add(circle);
                layer.setEffect(circleEffect);
            }
            layers.getChildren().add(layer);
        }

        // animation - for each layer, rotate it in a full circle, repeating indefinitely 
        for (Node layer : layers.getChildren()) {
            Timeline animation = new Timeline();
            animation.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(layer.rotateProperty(), 0d)),
                    new KeyFrame(Duration.seconds(15.0),
                            new KeyValue(layer.rotateProperty(), 360d)));
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        }

        return layers;
    }

    private Effect createEffect() {
        // set up effects
        Distant light = new Distant();
        light.setAzimuth(-35.0f);

        Lighting l = new Lighting();
        l.setLight(light);
        l.setSurfaceScale(15.0f);

        Bloom bloom = new Bloom();
        bloom.setThreshold(2.0);
        bloom.setInput(l);

        BoxBlur blur = new BoxBlur(4 + randomInt(0, 5), 4 + randomInt(0, 5), 4 + randomInt(0, 6));
        blur.setInput(bloom);

        Effect circleEffect = blur;
        return circleEffect;
    }

    private Circle createCircle(String colorHex) {
        double opacity = (double) MathUtil.randomInt(1, 100) / 100;
        Color color = Color.web(colorHex, opacity);
        Circle circle = new Circle(randomInt(15, 175), color);
        return circle;
    }
}
