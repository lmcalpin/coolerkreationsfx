package com.metatrope.controller;

import com.metatrope.CoolerKreations;
import com.metatrope.CoolerKreations.Screens;
import com.metatrope.kuler.Kuler;
import com.metatrope.kuler.theme.Swatch;
import com.metatrope.kuler.theme.ThemeItem;
import com.metatrope.model.UserSelections;
import com.metatrope.utils.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller implements Initializable {
    private static final ExecutorService THREADPOOL = Executors.newFixedThreadPool(1, new ThreadFactory() {
        public Thread newThread(Runnable r) {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setDaemon(true);
            return thread;
        }
    });
    
    @FXML
    private TextField tag;

    @FXML
    private Label status;
    
    @FXML
    private Button button;

    @FXML
    public void search(ActionEvent event) {
        tag.setDisable(true);
        button.setDisable(true);
        status.setText("Searching...");
        Task<Void> task = new Task<Void>() {
            public Void call() {
                try {
                    List<ThemeItem> themes = Kuler.findThemesForTag(tag.getText());
                    if (themes.size() == 0) {
                        status.setText("No results found");
                        cancel();
                        return null;
                    }
                    UserSelections options = CoolerKreations.APP.options;
                    ThemeItem theme = themes.get(MathUtil.randomInt(0, themes.size() - 1));
                    options.colors = new Color[theme.getThemeSwatches().getSwatches().size()];
                    options.theme = theme.getThemeTitle();
                    int i = 0;
                    for (Swatch swatch : theme.getThemeSwatches().getSwatches()) {
                        options.colors[i++] = Color.web(swatch.getSwatchHexColor());
                    }
                } catch (Throwable t) {
                    status.setText("An error occurred...");
                    t.printStackTrace();
                    // rethrow
                    throw new CheckedExceptionsAreStupidException(t);
                }
                return null;
            }
        };
        // when we are done, change the current screen to a blank canvas on which we will
        // generate the art
        task.stateProperty().addListener(new ChangeListener<Object>() {
            @Override public void changed(ObservableValue<?> ov, Object old, Object noo) {
                if (noo == Task.State.SUCCEEDED) {
                    status.setText("");
                    CoolerKreations.APP.getStage().setScene(Screens.ART.scene);
                    Screens.ART.switchTo();
                }
                if (noo == Task.State.SUCCEEDED || noo == Task.State.CANCELLED || noo == Task.State.FAILED) {
                    tag.setDisable(false);
                    button.setDisable(false);
                }
            }
        });
        THREADPOOL.execute(task);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
