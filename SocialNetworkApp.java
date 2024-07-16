import java.util.*;

class User  {
    String name;
    String password;
    Set<User> friends;
    
    User(String name, String password){
        this.name=name;
        this.password=password;
        this.friends=new HashSet<>();
    }

    void addFriend(User friend){
        friends.add(friend);
    }
}

class UserGraph{
    Map<String, User> users;

    UserGraph(){
        users=new HashMap<>();
    }

    boolean registerUser(String name,String password){
        if (users.containsKey(name)) {
            return false;
        }

        users.put(name, new User(name, password));
        return true;
    }

    User loginUser(String name, String password){
        User user=users.get(name);
        if(user!=null && user.password.equals(password)){
            return user;
        }
        return null;
    }

    boolean addFriend(String name1,String name2){
        User user1=users.get(name1);
        User user2=users.get(name2);
        if(user1!=null && user2!=null && !user1.equals(user2)){
            user1.addFriend(user2);
            user2.addFriend(user1);
            return true;
        }
        return false;
    }

    Set<User> findMiutualFriends(String name1,String name2){
        User user1=users.get(name1);
        User user2=users.get(name2);
        if(user1!=null && user2!=null){
            Set<User> mutualFriends=new HashSet<>(user1.friends);
            mutualFriends.retainAll(user2.friends);
            return mutualFriends;
        }
        return Collections.emptySet();
    }
}


public class SocialNetworkApp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserGraph userGraph = new UserGraph();

        while (true) { 
            System.out.println("1.Regiser");
            System.out.println("2.Login");
            System.out.println("3.AddFriend");
            System.out.println("4.FindMutualFriends");
            System.out.println("5.Exit");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter password : ");
                    String password = scanner.nextLine();
                    
                    if()
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}

