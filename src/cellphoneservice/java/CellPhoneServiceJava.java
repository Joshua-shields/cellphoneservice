package cellphoneservice.java;
import java.util.Scanner;


public class CellPhoneServiceJava {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Horizon Phones Plan Recommendation Tool!");

        int talkMinutes = promptForInt(input, "Enter your maximum monthly talk minutes: ");
        int textMessages = promptForInt(input, "Enter your maximum monthly text messages: ");
        int dataUsage = promptForInt(input, "Enter your maximum monthly data usage in gigabytes: ");

        recommendPlan(talkMinutes, textMessages, dataUsage);
    }

    private static int promptForInt(Scanner input, String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }

    public static void recommendPlan(int talkMinutes, int textMessages, int dataUsage) {
        String recommendedPlan;
        int planCost;

        if (dataUsage > 0) {
            recommendedPlan = (dataUsage < 3) ? "Plan E" : "Plan F";
            planCost = (dataUsage < 3) ? 790 : 870;
        } else {
            if (talkMinutes < 500) {
                recommendedPlan = (textMessages == 0) ? "Plan A" : "Plan B";
                planCost = (textMessages == 0) ? 490 : 550;
            } else {
                recommendedPlan = (textMessages < 100) ? "Plan C" : "Plan D";
                planCost = (textMessages < 100) ? 610 : 700;
            }
        }

        System.out.println("We recommend " + recommendedPlan + " for your needs. The monthly cost is R" + planCost + ".");
    }
}

