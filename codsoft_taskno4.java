import java.util.*;

class Question {
    String text;
    String[] options;
    int correctOption;

    Question(String text, String[] options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    void display() {
        System.out.println("\n" + text);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    boolean isCorrect(int choice) {
        return choice == correctOption;
    }
}

class Quiz {
    List<Question> questions = new ArrayList<>();
    int score = 0;
    Scanner scanner = new Scanner(System.in);

    Quiz() {
        questions.add(new Question("Who was the first Prime Minister of India?", new String[]{"Jawaharlal Nehru", "Sardar Patel", "Indira Gandhi", "Mahatma Gandhi"}, 1));
        questions.add(new Question("Which is the national animal of India?", new String[]{"Lion", "Elephant", "Tiger", "Leopard"}, 3));
        questions.add(new Question("What is the capital of Maharashtra?", new String[]{"Pune", "Nagpur", "Mumbai", "Nashik"}, 3));
        questions.add(new Question("Which river is called the 'Ganga of the South'?", new String[]{"Krishna", "Godavari", "Narmada", "Kaveri"}, 2));
        questions.add(new Question("Who wrote the Indian national anthem?", new String[]{"Rabindranath Tagore", "Bankim Chandra Chattopadhyay", "Subramania Bharati", "Sarojini Naidu"}, 1));
    }

    void start() {
        for (Question q : questions) {
            q.display();
            int choice = getAnswerWithTimer(10);
            if (choice == -1) {
                System.out.println("Time up!");
            } else if (q.isCorrect(choice)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer.");
            }
        }
        System.out.println("\nQuiz Over! Your Score: " + score + "/" + questions.size());
    }

    int getAnswerWithTimer(int seconds) {
        Timer timer = new Timer();
        final int[] answer = {-1};

        Thread inputThread = new Thread(() -> {
            System.out.print("Your answer: ");
            if (scanner.hasNextInt()) {
                answer[0] = scanner.nextInt();
            }
        });

        inputThread.start();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                inputThread.interrupt();
            }
        }, seconds * 1000);

        try {
            inputThread.join();
        } catch (InterruptedException e) {
            return -1;
        } finally {
            timer.cancel();
        }

        return answer[0];
    }
}

public class codsoft_taskno4 {
    public static void main(String[] args) {
        new Quiz().start();
    }
}
