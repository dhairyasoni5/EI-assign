package com.ei.mindsparkneo.patterns.behavioral.observer;

/**
 * A concrete "Observer" that displays updates on a teacher's dashboard.
 */
public class TeacherDashboard implements Observer {
    @Override
    public void update(String studentName, String update) {
        System.out.println("[TEACHER DASHBOARD] Alert: Student '" + studentName + "' " + update);
    }
}


