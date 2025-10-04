package com.ei.mindsparkneo.model;

import java.util.List;
import java.util.Objects;

/**
 * A concrete implementation of a Multiple Choice Question.
 */
public class MultipleChoiceQuestion implements Question {
    private final int id;
    private final String prompt;
    private final List<String> options;
    private final String correctAnswer;

    public MultipleChoiceQuestion(int id, String prompt, List<String> options, String correctAnswer) {
        this.id = id;
        this.prompt = Objects.requireNonNull(prompt);
        this.options = Objects.requireNonNull(options);
        this.correctAnswer = Objects.requireNonNull(correctAnswer);
    }

    @Override
    public int getQuestionId() {
        return id;
    }

    @Override
    public String getPrompt() {
        return prompt;
    }

    @Override
    public void display() {
        System.out.println("Question " + id + ": " + prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.println("  " + (char)('A' + i) + ") " + options.get(i));
        }
    }

    @Override
    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}


