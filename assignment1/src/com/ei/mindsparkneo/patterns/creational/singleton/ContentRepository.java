package com.ei.mindsparkneo.patterns.creational.singleton;

import com.ei.mindsparkneo.exception.ContentNotFoundException;
import com.ei.mindsparkneo.model.MultipleChoiceQuestion;
import com.ei.mindsparkneo.model.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Singleton Pattern: Ensures a single, globally accessible repository for all
 * learning content. This prevents redundant data loading and ensures consistency.
 */
public class ContentRepository {
    private static final Logger LOGGER = Logger.getLogger(ContentRepository.class.getName());
    private static ContentRepository instance;

    private final Map<Integer, Question> questionBank;

    // Private constructor to prevent instantiation from outside.
    private ContentRepository() {
        questionBank = new HashMap<>();
        loadInitialContent();
    }

    /**
     * Provides the global access point to the Singleton instance.
     * Uses lazy initialization and is thread-safe.
     */
    public static synchronized ContentRepository getInstance() {
        if (instance == null) {
            instance = new ContentRepository();
        }
        return instance;
    }

    private void loadInitialContent() {
        LOGGER.info("Loading initial content into repository...");
        // Dummy content for simulation
        Question q1 = new MultipleChoiceQuestion(101, "What is 2 + 2?", Arrays.asList("3", "4", "5"), "B");
        Question q2 = new MultipleChoiceQuestion(102, "What is the capital of France?", Arrays.asList("London", "Berlin", "Paris"), "C");
        questionBank.put(q1.getQuestionId(), q1);
        questionBank.put(q2.getQuestionId(), q2);
        LOGGER.info("Content loading complete.");
    }

    public Question getQuestionById(int id) {
        if (!questionBank.containsKey(id)) {
            throw new ContentNotFoundException("Question with ID " + id + " not found.");
        }
        return questionBank.get(id);
    }
}


