package com.ei.mindsparkneo.patterns.structural.decorator;

import com.ei.mindsparkneo.model.Question;

/**
 * A concrete decorator that adds "explanation" functionality.
 */
public class ExplanationDecorator extends QuestionDecorator {
    private final String explanation;

    public ExplanationDecorator(Question question, String explanation) {
        super(question);
        this.explanation = explanation;
    }

    @Override
    public boolean checkAnswer(String answer) {
        // Show explanation after checking the answer
        boolean result = super.checkAnswer(answer);
        showExplanation();
        return result;
    }
    
    public void showExplanation() {
        System.out.println("Explanation: " + explanation);
    }
}


