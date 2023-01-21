import java.util.Scanner;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> rocket = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int countId = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < countId; j++) {
            String arr = scanner.nextLine();
            int s0 = 0;
            int s1 = 0;
            int s2 = 0;
            int id = 0;
            int i = 0;
            for (String parts : arr.split(" ")) {
                if (i == 0) {
                    s0 = Integer.parseInt(parts);
                    s0 =  (s0 * 24) * 60;
                }
                if (i == 1) {
                    s1 = Integer.parseInt(parts) * 60;
                }
                if (i == 2) {
                    s2 = Integer.parseInt(parts);
                }
                if (i == 3) {
                    id = Integer.parseInt(parts);
                }
                if (i == 4) {
                    if(Objects.equals(parts, "A")) {
                        if (rocket.containsKey(id)) {
                            rocket.put(id, (rocket.get(id) - (s0 + s1 + s2)));
                        } else {
                            rocket.put(id, (s0 + s1 + s2)*(-1));
                        }
                    }
                    if(Objects.equals(parts, "S") || Objects.equals(parts, "C")) {
                        if (rocket.containsKey(id)) {
                            rocket.put(id, (rocket.get(id) + (s0 + s1 + s2)));
                        } else {
                            rocket.put(id, (s0 + s1 + s2));
                        }
                    }
                }
                i++;
            }
        }
        rocket.forEach((k, v)->System.out.print(v + " "));
    }
}