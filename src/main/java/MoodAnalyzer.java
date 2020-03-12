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
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length()==0)
                throw new MoodAnalysisException("Mood should not be empty",MoodAnalysisException.UserDefinedDataType.EMPTY_EXCEPTION);
            else if (message.contains("Sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException npe)
        {
            throw new MoodAnalysisException("Mood should not be null",MoodAnalysisException.UserDefinedDataType.NULL_EXCEPTION);
        }
    }

}