package designpatternsdemo.mediator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        
        ChatRoom chatRoom = new ChatRoom();
        
        User alex = new User("Alex", chatRoom);
        User kamal = new User("Kamal", chatRoom);
        User achini = new User("Achini", chatRoom);
        
        chatRoom.register(alex);
        chatRoom.register(kamal);
        chatRoom.register(achini);
        
        alex.messageTo("kamal", "Hi");
        kamal.messageTo("achini", "Hey, how ya doin?");
        achini.messageTo("kamal", "doin good, sup?");
                
    }
}

interface ChatMediator {
    void sendMessage(String from, String to, String message);
    void register(Colleague colleague);
}

class ChatRoom implements ChatMediator{
    
    private final List<Colleague> colleages = new ArrayList<>();
    
    @Override
    public void sendMessage(String from, String to, String message) {
        for (Colleague colleage : colleages) {
            if (colleage.getname().equalsIgnoreCase(to)) {
                colleage.receiveMessage(from, message);
            }
        }
    }
    
    @Override
    public void register(Colleague colleague){
        colleages.add(colleague);
    }    
}

interface Colleague{
    String getname();
    void messageTo(String to, String message);
    void receiveMessage(String from, String message);
}

class User implements Colleague{
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
    
    @Override
    public String getname() {
       return name;
    }

    @Override
    public void messageTo(String to, String message) {
        mediator.sendMessage(getname(), to, message);
    }

    @Override
    public void receiveMessage(String from, String message) {
        System.out.println(from + " > " + getname() + ": " + message);
    }
    
}





