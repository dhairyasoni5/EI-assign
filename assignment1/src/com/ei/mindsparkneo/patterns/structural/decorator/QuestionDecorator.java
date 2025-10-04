package com.ei.mindsparkneo.patterns.structural.decorator;

import com.ei.mindsparkneo.model.Question;

import java.util.Objects;

/**
 * The base abstract decorator class. It implements the Question interface and
 * holds a reference to a Question object, allowing it to wrap other questions.
 */
public abstract class QuestionDecorator implements Question {
    protected Question wrappedQuestion;

    public QuestionDecorator(Question question) {
        this.wrappedQuestion = Objects.requireNonNull(question);
    }

    @Override
    public void display() {
        wrappedQuestion.display();
    }

    @Override
    public boolean checkAnswer(String answer) {
        return wrappedQuestion.checkAnswer(answer);
    }

    @Override
    public int getQuestionId() {
        return wrappedQuestion.getQuestionId();
    }

    @Override
    public String getPrompt() {
        return wrappedQuestion.getPrompt();
    }
}


