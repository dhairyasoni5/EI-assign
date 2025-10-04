package com.ei.mindsparkneo.patterns.behavioral.observer;

/**
 * Another concrete "Observer" that simulates sending an email to a parent.
 */
public class ParentNotificationService implements Observer {
    @Override
    public void update(String studentName, String update) {
        System.out.println("[PARENT NOTIFICATION] Sending email: Your child, '" + studentName + "', " + update);
    }
}


