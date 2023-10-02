package com.velotio.spacexplorer.utils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;


public class CountdownTimer {
    private static final long COUNTDOWN_DURATION = TimeUnit.HOURS.toMillis(24); // 24 hours in milliseconds
    private long remainingTime = COUNTDOWN_DURATION;
    private Timer timer;

    private PublishSubject<String> countdownSubject = PublishSubject.create();


    public CountdownTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new CountdownTask(), 0, 1000); // Update every 1 second
    }

    public Flowable<String> getCountdownFlowable() {
        return countdownSubject.toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io());
    }

    private class CountdownTask extends TimerTask {
        @Override
        public void run() {
            if (remainingTime > 0) {
                remainingTime -= 1000; // Decrease by 1 second
                long days = TimeUnit.MILLISECONDS.toDays(remainingTime);
                long hours = TimeUnit.MILLISECONDS.toHours(remainingTime) % 24;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(remainingTime) % 60;
                long seconds = TimeUnit.MILLISECONDS.toSeconds(remainingTime) % 60;
                countdownSubject.onNext(String.format("T-%02d:%02d:%02d:%02d:%02d", days, hours, minutes, seconds, remainingTime % 1000 / 10));
            } else {
                System.out.println("Countdown completed!");
                timer.cancel();
            }
        }
    }
}