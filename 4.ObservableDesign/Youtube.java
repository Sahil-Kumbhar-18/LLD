import java.util.ArrayList;
import java.util.List;

interface User {
    void update(String channelName, String videoTitle);
}

class Subscriber implements User {
    private String name;
    public Subscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println(name +" received notification: " +channelName +" uploaded" + videoTitle + " ");
    }
}

interface Channel {
    void subscribe(User user);
    void unsubscribe(User user);
    void notifySubscribers();
}
class YouTubeChannel implements Channel {
    private String channelName;
    private String latestVideo;
    private List<User> subscribers = new ArrayList<>();
    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }
    @Override
    public void subscribe(User user) {
        if (!subscribers.contains(user)) {
            subscribers.add(user);
            System.out.println("User subscribed.");
        } else {
            System.out.println("Already subscribed.");
        }
    }

    @Override
    public void unsubscribe(User user) {
        if (subscribers.remove(user)) {
            System.out.println("User unsubscribed.");
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public void notifySubscribers() {

        for (User user : subscribers) {
            user.update(channelName, latestVideo);
        }
    }

    public void uploadVideo(String title) {
        latestVideo = title;
        System.out.println("\nNew Video Uploaded : " + title);
        notifySubscribers();
    }
}

public class Youtube {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("SK Tech Hub");
        User sahil = new Subscriber("Sahil");
        User shreya = new Subscriber("Shreya");
        User rohan = new Subscriber("Rohan");

        channel.subscribe(sahil);
        channel.subscribe(shreya);
        channel.subscribe(rohan);

        channel.uploadVideo("Observer Design Pattern in Java");

        channel.unsubscribe(shreya);

        channel.uploadVideo("Strategy Design Pattern");
    }
}