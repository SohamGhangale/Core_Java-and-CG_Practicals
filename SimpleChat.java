public class SimpleChat {
    public static void main(String[] args) throws InterruptedException {
        // Create two chat users with messages
        ChatUser user1 = new ChatUser("Soham", new String[]{"Hi", "How are you?", "Bye!"});
        ChatUser user2 = new ChatUser("Shivam", new String[]{"Hello Soham", "I am fine!", "OK See you soon Bye!"});

        // Start both chat threads
        user1.start();
        user2.start();

        System.out.println("Soham alive? " + user1.isAlive());
        Thread.sleep(1000);

        // Pause Shivam
        user2.pauseChat();
        System.out.println("Shivam paused...");
        Thread.sleep(1000);

        // Resume Shivam
        user2.resumeChat();
        System.out.println("Shivam resumed...");
        Thread.sleep(1000);

        // Stop Soham
        user1.stopChat();
        System.out.println("Soham stopped...");

        // Wait for both threads to finish
        user1.join();
        user2.join();

        System.out.println("Soham alive after join? " + user1.isAlive());
        System.out.println("Chat ended.");
    }
}

class ChatUser extends Thread {
    private String[] messages;
    private volatile boolean running = true;
    private volatile boolean paused = false;

    ChatUser(String name, String[] messages) {
        super(name);
        this.messages = messages;
    }

    // Pause the chat
    public void pauseChat() {
        paused = true;
    }

    // Resume the chat
    public synchronized void resumeChat() {
        paused = false;
        notify();
    }

    // Stop the chat
    public void stopChat() {
        running = false;
    }

    public void run() {
        for (int i = 0; i < messages.length && running; i++) {
            synchronized (this) {
                while (paused) {
                    try {
                        wait(); // wait until resumeChat() is called
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(getName() + " says: " + messages[i]);

            try {
                Thread.sleep(1000); // delay between messages
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

