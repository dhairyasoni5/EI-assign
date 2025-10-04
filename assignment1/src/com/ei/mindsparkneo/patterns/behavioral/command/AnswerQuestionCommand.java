package com.ei.mindsparkneo.patterns.behavioral.command;

import com.ei.mindsparkneo.model.Question;
import com.ei.mindsparkneo.model.StudentProgress;

import java.util.Objects;

/**
 * A concrete Command that encapsulates the action of answering a question.
 * It holds all information needed to execute and unexecute the action.
 */
public class AnswerQuestionCommand implements Command {
    private final StudentProgress studentProgress; // The "Receiver"
    private final Question question;
    private final String answer;
    private boolean wasCorrect;
    private boolean wasExecuted = false;

    public AnswerQuestionCommand(StudentProgress studentProgress, Question question, String answer) {
        this.studentProgress = Objects.requireNonNull(studentProgress);
        this.question = Objects.requireNonNull(question);
        this.answer = Objects.requireNonNull(answer);
    }

    @Override
    public void execute() {
        wasCorrect = question.checkAnswer(answer);
        studentProgress.recordAnswer(wasCorrect);
        wasExecuted = true;
        System.out.println("Answer submitted. Result: " + (wasCorrect ? "Correct" : "Incorrect"));
    }

    @Override
    public void unexecute() {
        if (wasExecuted) {
            // This is a simplified undo. A real app might need more complex state management.
            System.out.println("Undoing the last answer for question " + question.getQuestionId());
            // In a real system, you would reverse the score change in StudentProgress.
            wasExecuted = false;
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}


