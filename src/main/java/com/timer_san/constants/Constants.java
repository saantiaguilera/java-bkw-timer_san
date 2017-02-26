package com.timer_san.constants;

import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.util.concurrent.TimeUnit;

/**
 * Created by saguilera on 2/25/17.
 */
public final class Constants {

    private Constants() throws IllegalAccessException {
        throw new IllegalAccessException("Why are you instantiating this?");
    }

    public static final long TIMER_START = 0;
    public static final long TIMER_DELAY = 0;
    public static final long TIMER_PERIOD = 1;
    public static final long TIMER_COUNT = 4;
    public static final TimeUnit TIMER_UNIT = TimeUnit.SECONDS;

    public static final int TIMER_KEY = GlobalKeyEvent.VK_NUMPAD0;

}
