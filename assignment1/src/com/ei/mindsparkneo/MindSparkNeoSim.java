package com.ei.mindsparkneo;

import com.ei.mindsparkneo.external.UniversityVideoAPI;
import com.ei.mindsparkneo.model.LearningModule;
import com.ei.mindsparkneo.model.Question;
import com.ei.mindsparkneo.model.StudentProgress;
import com.ei.mindsparkneo.patterns.behavioral.command.AnswerQuestionCommand;
import com.ei.mindsparkneo.patterns.behavioral.command.Command;
import com.ei.mindsparkneo.patterns.behavioral.command.LearningSessionManager;
import com.ei.mindsparkneo.patterns.behavioral.observer.ParentNotificationService;
import com.ei.mindsparkneo.patterns.behavioral.observer.TeacherDashboard;
import com.ei.mindsparkneo.patterns.creational.singleton.ContentRepository;
import com.ei.mindsparkneo.patterns.structural.adapter.UniversityVideoAdapter;
import com.ei.mindsparkneo.patterns.structural.decorator.ExplanationDecorator;
import com.ei.mindsparkneo.patterns.structural.decorator.HintDecorator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MindSparkNeoSim {
    private static final Logger LOGGER = Logger.getLogger(MindSparkNeoSim.class.getName());
    
    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
        System.out.println("--- Welcome to the MindSpark Neo Learning Platform Simulator ---");

        // --- 1. Creational: Singleton & Factory (Setup) ---
        System.out.println("\n## DEMO: Creational Patterns ##");
        // Using the Singleton to get the content repository
        ContentRepository repo = ContentRepository.getInstance();
        Question q1 = repo.getQuestionById(101);
        System.out.println("Successfully fetched Question 101 using Singleton Repository.");
        // We are not demonstrating the factory directly here, but it's used by the repo.
        
        System.out.println("\n-------------------------------------------------------------");

        // --- 2. Behavioural: Observer (Setup) ---
        System.out.println("\n## DEMO: Behavioural Pattern - Observer ##");
        StudentProgress progress = new StudentProgress("Arya");
        TeacherDashboard teacherDashboard = new TeacherDashboard();
        ParentNotificationService parentNotifier = new ParentNotificationService();
        
        // Registering observers to the subject
        progress.registerObserver(teacherDashboard);
        progress.registerObserver(parentNotifier);
        System.out.println("Teacher Dashboard and Parent Notifier are now observing Arya's progress.");

        System.out.println("\n-------------------------------------------------------------");
        
        // --- 3. Behavioural: Command (Setup & Execution) ---
        System.out.println("\n## DEMO: Behavioural Pattern - Command ##");
        LearningSessionManager sessionManager = new LearningSessionManager();

        System.out.println("\nArya is attempting Question 101...");
        q1.display();
        
        // Encapsulating the action in a Command object
        Command answerCommand = new AnswerQuestionCommand(progress, q1, "B");
        
        // The invoker executes the command. This will trigger the Observer notifications.
        sessionManager.executeCommand(answerCommand);

        System.out.println("\n--- Let's try undoing the action ---");
        sessionManager.undoLastCommand();

        System.out.println("\n-------------------------------------------------------------");

        // --- 4. Structural: Decorator ---
        System.out.println("\n## DEMO: Structural Pattern - Decorator ##");
        Question q2 = repo.getQuestionById(102);
        System.out.println("Original Question 102:");
        q2.display();

        System.out.println("\nNow, let's decorate the question with a hint and an explanation...");
        
        // Wrapping the same question object with decorators to add functionality
        HintDecorator hintedQ2 = new HintDecorator(q2, "It's a famous city in Europe known for art.");
        ExplanationDecorator fullyDecoratedQ2 = new ExplanationDecorator(hintedQ2, "'Paris' is the capital and most populous city of France.");
        
        fullyDecoratedQ2.display(); // Notice the "[Hint Available]" text from the HintDecorator
        hintedQ2.showHint(); // Calling the method added by the decorator
        
        System.out.println("\nAnswering the decorated question (Incorrectly to see explanation)...");
        // This will trigger the explanation decorator's logic
        fullyDecoratedQ2.checkAnswer("A");

        System.out.println("\n-------------------------------------------------------------");
        
        // --- 5. Structural: Adapter ---
        System.out.println("\n## DEMO: Structural Pattern - Adapter ##");
        System.out.println("Integrating content from an incompatible, third-party API...");
        
        UniversityVideoAPI externalAPI = new UniversityVideoAPI();
        // The adapter makes the external API compatible with our LearningModule interface
        LearningModule adaptedVideo = new UniversityVideoAdapter(externalAPI, "Calculus");
        
        // The system can now use the adapted content without knowing any implementation details
        adaptedVideo.display();

        System.out.println("\n--- Simulation Complete ---");
    }
}


