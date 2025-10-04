package com.ei.mindsparkneo.model;

import com.ei.mindsparkneo.patterns.behavioral.observer.Observer;
import com.ei.mindsparkneo.patterns.behavioral.observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Acts as the "Subject" in the Observer pattern. When its state changes (e.g.,
 * a student answers a question), it notifies all registered observers.
 */
public class StudentProgress implements Subject {
    private static final Logger LOGGER = Logger.getLogger(StudentProgress.class.getName());

    private final List<Observer> observers;
    private final String studentName;
    private int score = 0;
    private String lastUpdate;

    public StudentProgress(String studentName) {
        this.studentName = Objects.requireNonNull(studentName);
        this.observers = new ArrayList<>();
    }
    
    public void recordAnswer(boolean isCorrect) {
        if (isCorrect) {
            score++;
            lastUpdate = "answered a question correctly! Current score: " + score;
        } else {
            lastUpdate = "answered a question incorrectly. Current score: " + score;
        }
        LOGGER.info("State changed for " + studentName + ". Notifying observers.");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(studentName, lastUpdate);
        }
    }
}


