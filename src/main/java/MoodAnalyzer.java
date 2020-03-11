public class MoodAnalyzer
{
    private String message;
    public static void main(String[] args)
    {
        System.out.println("Welcome to mood analyzer problem");
    }
    public MoodAnalyzer()
    {
    }
    public MoodAnalyzer(String message)
    {
        this.message = message;
    }
    public String analyseMood() {
        try {
            if (message.contains("Sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException npe) {
            return "Happy";
        }
    }
}