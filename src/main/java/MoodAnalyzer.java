import java.util.Objects;

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
    public String analyseMood() throws MoodAnalysisException
    {
        try
        {
            if (message.length()==0)
                throw new MoodAnalysisException("Mood should not be empty",MoodAnalysisException.UserDefinedDataType.EMPTY_EXCEPTION);
            else if (message.contains("Sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e)
        {
            throw new MoodAnalysisException("Mood should not be null",MoodAnalysisException.UserDefinedDataType.NULL_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(message);
    }
}