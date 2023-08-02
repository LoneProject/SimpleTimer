package org.lone64.simpletimer.util.runnable;

import org.lone64.simpletimer.STimer;
import org.lone64.simpletimer.runnable.RunnableManager;

public class Runnable {

    public static RunnableManager getManager() {
        return STimer.getManager();
    }

}
