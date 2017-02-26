package com.timer_san;

import com.timer_san.timer.scene.TimerSceneManager;
import io.reactivex.annotations.NonNull;
import javafx.application.Application;
import javafx.stage.Stage;
import lc.kra.system.keyboard.GlobalKeyboardHook;

/**
 * Created by saguilera on 2/25/17.
 */
public class EntryPoint extends Application {

    @NonNull
    private static EntryPoint instance;
    @NonNull
    private GlobalKeyboardHook systemHook;

    public static void main(String[] args) {
        launch(args);
    }

    public static EntryPoint getInstance() {
        return instance;
    }

    public void start(Stage stage) throws Exception {
        instance = this;
        systemHook = new GlobalKeyboardHook();

        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setTitle("Bkw Timer-San Ｏ(≧▽≦)Ｏ");

        stage.setScene(new TimerSceneManager().scene());
        stage.show();

        systemHook.shutdownHook();
    }

    public GlobalKeyboardHook getSystemHook() {
        return systemHook;
    }

}
