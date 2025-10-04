package com.ei.mindsparkneo.model;

/**
 * An interface representing a question, extending the base LearningModule.
 * It adds behavior specific to questions, like checking an answer.
 */
public interface Question extends LearningModule {
    int getQuestionId();
    String getPrompt();
    boolean checkAnswer(String answer);
}


