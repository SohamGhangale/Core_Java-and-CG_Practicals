class MobilePhone {
    void parent() {
        System.out.println("\nEmergency Calls Only! Please check your network.");
    }
}

class BasicPhone extends MobilePhone {
    void makeCall() {
        System.out.println("Calling...");
    }

    void pickCall() {
        System.out.println("Picking up the call...");
    }
}

class Smartphone extends BasicPhone {
    void takePhoto() {
        System.out.println("Taking photo in Soham's IQOO Z9 on 50 MP");
    }

    void recordVideo() {
        System.out.println("Recording video in Soham's IQOO Z9");
    }

    void playGame() {
        System.out.println("Welcome to CLAS OF CLANS");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Smartphone myPhone = new Smartphone();

        myPhone.parent();
        myPhone.makeCall();
        myPhone.pickCall();
        myPhone.recordVideo();
        myPhone.takePhoto();
        myPhone.playGame();
    }
}
