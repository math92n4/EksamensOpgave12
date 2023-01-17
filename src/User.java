import java.util.Random;
import java.util.regex.Pattern;

public class User {

    private String fullName;
    private String userID;
    private final String regex = "[a-z]{4}[0-9]{4}";
    private final Pattern pattern = Pattern.compile(regex);
    private Random random = new Random();

    public User(String fullName) {
        this.fullName = fullName;
        this.userID = generateUserID();
    }

    public User(String fullName,String userID) {
        this.fullName = fullName;
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserID() {
        return userID;
    }

    public boolean validUserID() {
        return pattern.matcher(userID).matches();
    }

    public String generateUserID() {
        String[] split = this.fullName.split(" ");
        String first = split[0].toLowerCase().substring(0,2);
        String second = split[1].toLowerCase().substring(0,2);
        int number = random.nextInt(1000,10000);
        return first + second + number;
    }

    public static void main(String[] args) {

        User user1 = new User("Mathias Wulff","abcd1234");
        User user2 = new User("Mads Wulff");
        System.out.println(user2.getUserID());

        System.out.println(user1.validUserID());


    }


}