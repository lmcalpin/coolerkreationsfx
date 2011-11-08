package com.metatrope;

import static com.metatrope.utils.MathUtil.randomInt;

import com.metatrope.CoolerKreations.Screens;
import com.metatrope.utils.MathUtil;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Generate the art.
 * 
 * @author Lawrence McAlpin
 * 
 */
public class ArtScreen implements Screen {
    private Group root;
    private Scene scene;
    private Lighting l;
    
    public ArtScreen() {
        this.root = new Group();
        this.scene = new Scene(root, Color.BLACK);
        // if the user hits Escape, return to the user Input screen
        this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    Screens.INPUT.switchTo();
                }
            }
        });
        
        // global effects
        // set up effects
        Distant light = new Distant();
        light.setAzimuth(-135.0f);

        l = new Lighting();
        l.setLight(light);
        l.setSurfaceScale(5.0f);
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public void onDisplay() {
        // make sure we start with a blank canvas
        this.root.getChildren().clear();
        
        generateArt();
    }

    public void generateArt() {
        // set up circles
        Group circles = new Group();
        int numberOfCircles = randomInt(40, 70);
        for (int i = 0; i < numberOfCircles; i++) {
            Circle circle = createCircle();
            circles.getChildren().add(circle);
            circles.setEffect(createEffect());
        }
        circles.setBlendMode(BlendMode.ADD);
        root.getChildren().add(circles);

        // identify the theme
        Text theme = new Text();
        theme.setX(25.0);
        theme.setY(25.0);
        theme.setFont(Font.font("Verdana", 24.0));
        theme.setFill(Color.WHITE);
        theme.setText(CoolerKreations.APP.options.theme);
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(4.0f);
        ds.setOffsetX(4.0f);
        ds.setColor(Color.CORAL);
        
        theme.setEffect(ds);
        
        root.getChildren().add(theme);
        root.setBlendMode(BlendMode.ADD);
        
        // animation
        Timeline timeline = new Timeline();
        for (Node circle : circles.getChildren()) {
            timeline.getKeyFrames().addAll(
                    new KeyFrame(new Duration(randomInt(0, 2000)),
                            new KeyValue(circle.translateXProperty(), randomInt(0, 5)),
                            new KeyValue(circle.translateYProperty(), randomInt(0, 5))),
                    new KeyFrame(new Duration(randomInt(10000, 15000)),
                            new KeyValue(circle.translateXProperty(), randomInt(0, 800), Interpolator.EASE_OUT),
                            new KeyValue(circle.translateYProperty(), randomInt(0, 600), Interpolator.EASE_OUT)));
        }
        timeline.play();
    }

    private Effect createEffect() {
        BoxBlur blur = new BoxBlur(randomInt(0, 3), randomInt(0, 3), randomInt(0, 6));
        blur.setInput(l);
        return blur;
    }

    private Circle createCircle() {
        Color innerColorModel = CoolerKreations.APP.options.randomColor();
        double opacity = (double)MathUtil.randomInt(1, 100)/100;
        Color realInnerColor = new Color(innerColorModel.getRed(), innerColorModel.getGreen(), innerColorModel.getBlue(), opacity * innerColorModel.getOpacity());
        Color strokeColor = CoolerKreations.APP.options.randomColor();
        Circle circle = new Circle(randomInt(25, 155), realInnerColor);
        circle.setStrokeType(StrokeType.OUTSIDE);
        circle.setStroke(strokeColor);
        circle.setStrokeWidth(randomInt(3, 15));
        return circle;
    }
}
