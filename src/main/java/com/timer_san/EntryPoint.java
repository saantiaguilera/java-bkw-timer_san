package com.timer_san;

import com.timer_san.timer.scene.TimerSceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by saguilera on 2/25/17.
 */
public class EntryPoint extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setTitle("Bkw Timer-San Ｏ(≧▽≦)Ｏ");

        stage.setScene(new TimerSceneManager().scene());
        stage.show();
    }

}
