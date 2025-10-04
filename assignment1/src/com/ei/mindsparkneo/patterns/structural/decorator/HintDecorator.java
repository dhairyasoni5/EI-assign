package com.ei.mindsparkneo.patterns.structural.decorator;

import com.ei.mindsparkneo.model.Question;

/**
 * A concrete decorator that adds "hint" functionality to any question.
 */
public class HintDecorator extends QuestionDecorator {
    private final String hint;

    public HintDecorator(Question question, String hint) {
        super(question);
        this.hint = hint;
    }

    @Override
    public void display() {
        super.display(); // Display the original question first
        System.out.println("[Hint Available]");
    }
    
    public void showHint() {
        System.out.println("Hint: " + hint);
    }
}


