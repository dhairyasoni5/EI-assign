package com.ei.mindsparkneo.external;

/**
 * Simulates a third-party/legacy API. Note its incompatible method names
 * and data structures (the "Adaptee").
 */
public class UniversityVideoAPI {
    public String fetchVideoByTopic(String topic) {
        // Simulates fetching a video stream URL
        return "https://university.edu/api/v1/streams/calculus-intro.mp4";
    }

    public String getTranscriptText(String topic) {
        return "This is a transcript for the video about " + topic + ".";
    }
}


