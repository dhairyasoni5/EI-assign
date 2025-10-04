package com.ei.mindsparkneo.patterns.structural.adapter;

import com.ei.mindsparkneo.external.UniversityVideoAPI;
import com.ei.mindsparkneo.model.LearningModule;

import java.util.Objects;

/**
 * Adapter Pattern: This class "adapts" the UniversityVideoAPI to our
 * platform's LearningModule interface, allowing them to work together seamlessly.
 */
public class UniversityVideoAdapter implements LearningModule {
    private final UniversityVideoAPI externalAPI;
    private final String topic;

    public UniversityVideoAdapter(UniversityVideoAPI externalAPI, String topic) {
        this.externalAPI = Objects.requireNonNull(externalAPI);
        this.topic = Objects.requireNonNull(topic);
    }

    @Override
    public void display() {
        System.out.println("--- Integrated Video Content ---");
        System.out.println("Topic: " + topic);
        
        // Calling the adaptee's methods and translating the output
        String videoUrl = externalAPI.fetchVideoByTopic(topic);
        String transcript = externalAPI.getTranscriptText(topic);
        
        System.out.println("Video URL: " + videoUrl);
        System.out.println("Transcript: " + transcript);
        System.out.println("---------------------------------");
    }
}


