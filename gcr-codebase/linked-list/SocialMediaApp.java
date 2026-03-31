import java.util.Scanner;

// friend list node
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// user node
class UserNode {
    int userId, age;
    String name;
    FriendNode friends;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

// Social Network Linked List
class SocialNetwork {
    private UserNode head;

    // add user
    void addUser(UserNode user) {
        user.next = head;
        head = user;
    }

    // find user by ID
    UserNode findUser(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // add friend connection
    void addFriend(int u1, int u2) {
        UserNode user1 = findUser(u1);
        UserNode user2 = findUser(u2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found");
            return;
        }

        user1.friends = addFriendNode(user1.friends, u2);
        user2.friends = addFriendNode(user2.friends, u1);

        System.out.println("Friend connection added");
    }

    FriendNode addFriendNode(FriendNode head, int id) {
        FriendNode node = new FriendNode(id);
        node.next = head;
        return node;
    }

    // remove friend connection
    void removeFriend(int u1, int u2) {
        UserNode user1 = findUser(u1);
        UserNode user2 = findUser(u2);

        if (user1 == null || user2 == null)
            return;

        user1.friends = removeFriendNode(user1.friends, u2);
        user2.friends = removeFriendNode(user2.friends, u1);

        System.out.println("Friend connection removed");
    }

    FriendNode removeFriendNode(FriendNode head, int id) {
        if (head == null) return null;

        if (head.friendId == id)
            return head.next;

        FriendNode temp = head;
        while (temp.next != null && temp.next.friendId != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;

        return head;
    }

    // display friends of a user
    void displayFriends(int id) {
        UserNode user = findUser(id);
        if (user == null) return;

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friends;
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // mutual friends
    void mutualFriends(int u1, int u2) {
        UserNode user1 = findUser(u1);
        UserNode user2 = findUser(u2);

        if (user1 == null || user2 == null)
            return;

        System.out.print("Mutual Friends: ");
        FriendNode f1 = user1.friends;

        while (f1 != null) {
            FriendNode f2 = user2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId)
                    System.out.print(f1.friendId + " ");
                f2 = f2.next;
            }
            f1 = f1.next;
        }
        System.out.println();
    }

    // search user
    void search(String key) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(key) ||
                String.valueOf(temp.userId).equals(key)) {
                System.out.println(temp.userId + " | " + temp.name + " | " + temp.age);
            }
            temp = temp.next;
        }
    }

    //method for counting friends
    void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork sn = new SocialNetwork();

        // sample users
        sn.addUser(new UserNode(1, "Alice", 20));
        sn.addUser(new UserNode(2, "Bob", 21));
        sn.addUser(new UserNode(3, "Charlie", 22));

        while (true) {
            System.out.println(
                "\n1.Add Friend 2.Remove Friend 3.Mutual Friends 4.Display Friends" +
                " 5.Search User 6.Count Friends 7.Exit"
            );
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    sn.addFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    sn.removeFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    sn.mutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    sn.displayFriends(sc.nextInt());
                    break;
                case 5:
                    sn.search(sc.next());
                    break;
                case 6:
                    sn.countFriends();
                    break;
                case 7:
                    sc.close(); 
                    return;
            }
        }
    }
}
