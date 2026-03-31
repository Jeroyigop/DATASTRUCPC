import java.util.*;
import java.io.*;

class Question {
    String question;
    List<String> choices;
    String answer;

    public Question(String question, List<String> choices, String answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    public void display() {
        System.out.println("\n" + question);
        for (String choice : choices) {
            System.out.println(choice);
        }
        System.out.println("[Type A, B, C or 'exit' to stop]");
    }
}

public class QuizGame {

   
    public static List<Question> loadQuestions(String filename) {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String questionText = line;
                List<String> choices = new ArrayList<>();

               
                for (int i = 0; i < 3; i++) {
                    String choiceLine = br.readLine();
                    if (choiceLine == null) break;
                    choices.add(choiceLine);
                }

             
                String answerLine = br.readLine();
                if (answerLine == null || !answerLine.contains(":")) continue;

                String answer = answerLine.split(":")[1].trim().toUpperCase();

                questions.add(new Question(questionText, choices, answer));

                br.readLine(); 
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return questions;
    }

 
    public static void startQuiz(List<Question> questions, Scanner scanner) {

        if (questions.isEmpty()) {
            System.out.println("No questions loaded!");
            return;
        }

        Collections.shuffle(questions);

        int score = 0;
        int totalAnswered = 0;

        System.out.println("\n=== QUIZ START ===");

        for (Question q : questions) {

            q.display();

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toUpperCase();

            if (userAnswer.equals("EXIT")) {
                System.out.println("\nYou exited the quiz.");
                break;
            }

            if (!userAnswer.equals("A") && !userAnswer.equals("B") && !userAnswer.equals("C")) {
                System.out.println("Invalid input! Use A, B, or C only.");
                continue;
            }

            totalAnswered++;

            if (userAnswer.equals(q.answer)) {
                System.out.println("✔ Correct!");
                score++;
            } else {
                System.out.println("✘ Wrong! Correct answer: " + q.answer);
            }
        }

        System.out.println("\n=== RESULT ===");
        System.out.println("Score: " + score + "/" + totalAnswered);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Start Quiz");
            System.out.println("2. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
          
                    List<Question> questions = loadQuestions("questions.txt");
                    startQuiz(questions, scanner);
                    break;

                case "2":
                    System.out.println("Malaya kan!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}