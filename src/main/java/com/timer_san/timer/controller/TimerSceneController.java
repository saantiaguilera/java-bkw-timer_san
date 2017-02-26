package com.timer_san.timer.controller;

import com.timer_san.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.keyboard.event.GlobalKeyListener;

/**
 * Created by saguilera on 2/25/17.
 */
public class TimerSceneController {

    @FXML
    @NonNull
    private TextField countDownText;

    @Nullable
    private Disposable currentOperation;

    public TimerSceneController() {
        GlobalKeyboardHook hook = new GlobalKeyboardHook();
        hook.addKeyListener(new GlobalKeyListener() {
            @Override
            public void keyPressed(GlobalKeyEvent globalKeyEvent) {}

            @Override
            public void keyReleased(GlobalKeyEvent globalKeyEvent) {
                if (globalKeyEvent.getVirtualKeyCode() == Constants.TIMER_KEY) {
                    run();
                }
            }
        });
    }

    private void run() {
        if (currentOperation != null && !currentOperation.isDisposed())
            currentOperation.dispose();

        currentOperation = Observable.intervalRange(Constants.TIMER_START, Constants.TIMER_COUNT,
            Constants.TIMER_DELAY, Constants.TIMER_PERIOD, Constants.TIMER_UNIT)
                .observeOn(Schedulers.single())
                .subscribeOn(Schedulers.newThread())
                .subscribe(time -> {
                    countDownText.setText(String.valueOf(Constants.TIMER_COUNT - (time + 1)));
                });
    }

}
