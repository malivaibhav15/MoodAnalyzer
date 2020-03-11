import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.junit.Assert;
import org.junit.Test;

public class TestCases
{
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad()
    {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer("I am in Sad Mood");
        Assert.assertEquals("Sad",MoodAnalyser.analyseMood());
    }
    @Test
    public void givenMessage_WhenIncludeIAmInAnyMood_ShouldReturnHappy()
    {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer("I am in Any Mood");
        Assert.assertEquals("Happy",MoodAnalyser.analyseMood());
    }
    @Test
    public void  GivenMessage_WhenNull_ShouldThrowExcepton()
    {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer(null);
        Assert.assertEquals("Happy",MoodAnalyser.analyseMood());
    }
}
