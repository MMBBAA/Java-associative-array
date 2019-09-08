/*
create an array that contains a leaderboard with a name key, and a ranking key.
 - provide a method that will rank the leaderboard from highest to lowest
 - provide a method that will show the best ranked player
 - provide a method that will show the lowest ranked player
 */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        ValueComparator bvc = new ValueComparator(list);
        TreeMap<String, Integer> order_list = new TreeMap<String, Integer>(bvc);

        list.put("Casillas", 1);
        list.put("Luis", 3);
        list.put("Antonio", 4);
        list.put("Fernando", 6);
        list.put("Eduardo", 5);
        list.put("Alejandro", 2);
        list.put("Maria", 8);
        list.put("Luisa", 10);
        list.put("Juan", 9);
        list.put("Pedro", 7);

        //menu&Scanner to choose options
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            try {
                System.out.println("Leaderboard");
                System.out.println("===================");
                System.out.println("1. Show leaderboard");
                System.out.println("2. Show leaderboard from higher to lower player");
                System.out.println("3. Show the highest player.");
                System.out.println("4. Show the lowest player.");
                System.out.println("5. Exit");
                option = sc.nextInt();
                if ((option > 5)||(option<=0)) {
                    System.out.println("please, introduce a number between 1 and 5");
                } else {

                    switch (option) {
                        case 1:
                            System.out.println("leaderboard: " + list);
                            break;
                        case 2:
                            ShowLeaderboard(list, order_list);
                            break;
                        case 3:
                            ShowHighestPlayer(list, order_list);
                            break;
                        case 4:
                            ShowLowestPlayer(list, order_list);
                            break;
                        case 5:
                            System.out.println("end");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please,introduce a number from 1 to 5");
                option = 0;
                sc.nextLine();
            }
        } while (option != 5);
    }

    /**
     * ShowLeaderboard, not return, show the leaderboard from higher to lowest,
     * receive a HashMap and a TreeMap
     *
     * @param listp
     */
    public static void ShowLeaderboard(HashMap list, TreeMap order_list) {
        order_list.putAll(list);
        System.out.println("leaderboard from highest to lowest: " + order_list);
    }

    /**
     * ShowHighestPlayer, not return, show the higher player, receive a HashMap
     * and a TreeMap
     *
     * @param listp
     */
    public static void ShowHighestPlayer(HashMap list, TreeMap order_list) {
        order_list.putAll(list);
        System.out.println("the best ranked player: " + order_list.firstEntry());
    }

    /**
     * ShowLowestPlayer, not return, show the lowest player, receive a HashMap
     * and a TreeMap
     */
    public static void ShowLowestPlayer(HashMap list, TreeMap order_list) {
        order_list.putAll(list);
        System.out.println("the lowest ranked player: " + order_list.lastEntry());
    }
}
