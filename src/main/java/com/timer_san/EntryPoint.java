package com.timer_san;

import com.timer_san.constants.ResourceValue;
import com.timer_san.timer.scene.TimerScene;
import io.reactivex.annotations.NonNull;
import javafx.application.Application;
import javafx.stage.Stage;
import lc.kra.system.keyboard.GlobalKeyboardHook;

/**
 * Created by saguilera on 2/25/17.
 */
public class EntryPoint extends Application {

    private static EntryPoint instance;
    private GlobalKeyboardHook systemHook;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        instance = this;
        systemHook = new GlobalKeyboardHook();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                getSystemHook().shutdownHook();
            }
        });

        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setTitle(ResourceValue.APP_NAME);

        stage.setScene(new TimerScene());
        stage.show();
    }

    public static @NonNull GlobalKeyboardHook getSystemHook() {
        return instance.systemHook;
    }

}
