package com.ei.mindsparkneo.patterns.creational.factory;

import com.ei.mindsparkneo.model.MultipleChoiceQuestion;
import com.ei.mindsparkneo.model.Question;

import java.util.List;
import java.util.Objects;

/**
 * Factory Method Pattern: Decouples the client (e.g., a quiz engine)
 * from the concrete question classes. It simplifies the process of adding new
 * question types in the future without changing the client code.
 */
public class QuestionFactory {
    public static Question createQuestion(QuestionType type, int id, String prompt, List<String> options, String answer) {
        Objects.requireNonNull(type, "Question type cannot be null");

        switch (type) {
            case MULTIPLE_CHOICE:
                return new MultipleChoiceQuestion(id, prompt, options, answer);
            // case FILL_IN_BLANK:
            // return new FillInTheBlankQuestion(...);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }
}


