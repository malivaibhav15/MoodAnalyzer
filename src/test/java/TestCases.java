import org.junit.Assert;
import org.junit.Test;

public class TestCases
{
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad()
    {
        MoodAnalyzer MoodAnalyser=new MoodAnalyzer("I am in Sad Mood");
        Assert.assertEquals("Sad",MoodAnalyser.analyseMood());
    }
    @Test
    public void givenMessage_WhenIncludeIAmInAnyMood_ShouldReturnHappy()
    {
        MoodAnalyzer MoodAnalyser=new MoodAnalyzer("I am in Any Mood");
        Assert.assertEquals("Happy",MoodAnalyser.analyseMood());
    }
}
