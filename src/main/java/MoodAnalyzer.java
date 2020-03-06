public class MoodAnalyzer
{
    public static void main(String[] args) {
        System.out.println("Welcome to mood analyzer problem");
    }
    public String analyseMood(String message)
    {
        if(message.contains("Sad"))
            return "Sad";
        else
            return "Happy";
    }

}
