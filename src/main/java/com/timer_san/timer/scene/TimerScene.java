package com.timer_san.timer.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Managers should always be used for comunicating with internals of the specific scene.
 * Bear in mind the scene is weak, so always retrieve it when its created (and it shouldnt be done
 * again)
 *
 * Created by saguilera on 2/25/17.
 */
public class TimerScene extends Scene {

    private static final String LAYOUT_PATH = "/res/timer/scene_timer.fxml";

    public TimerScene() throws IOException {
        super(FXMLLoader.load(TimerScene.class.getResource(LAYOUT_PATH)));
    }

}
