import org.junit.Assert;
import org.junit.Test;

public class TestCases
{
    MoodAnalyzer MoodAnalyser = new MoodAnalyzer();
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad()
    {
        String mood=MoodAnalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("Sad",mood);
    }
    @Test
    public void givenMessage_WhenIncludeIAmInAnyMood_ShouldReturnHappy()
    {
        String mood=MoodAnalyser.analyseMood(("I am In Any Mood"));
        Assert.assertEquals("Happy",mood);
    }
}
