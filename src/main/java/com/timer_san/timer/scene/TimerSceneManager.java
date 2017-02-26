package com.timer_san.timer.scene;

import com.timer_san.timer.controller.TimerSceneController;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Managers should always be used for comunicating with internals of the specific scene.
 * Bear in mind the scene is weak, so always retrieve it when its created (and it shouldnt be done
 * again)
 *
 * Created by saguilera on 2/25/17.
 */
public class TimerSceneManager {

    private static final String LAYOUT_PATH = "/res/timer/scene_timer.fxml";

    private @NonNull TimerSceneController controller;
    private @Nullable WeakReference<Scene> scene;

    public TimerSceneManager() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(LAYOUT_PATH));
        scene = new WeakReference<>(new Scene(loader.load()));
        controller = loader.getController();
    }

    public @Nullable Scene scene() {
        return scene.get();
    }

}
