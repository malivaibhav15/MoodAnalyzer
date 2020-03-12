import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.junit.Assert;
import org.junit.Test;

public class TestCases
{
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalysisException {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer("I am in Sad Mood");
        Assert.assertEquals("Sad",MoodAnalyser.analyseMood());
    }
    @Test
    public void givenMessage_WhenIncludeIAmInAnyMood_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer("I am in Any Mood");
        Assert.assertEquals("Happy",MoodAnalyser.analyseMood());
    }
    @Test
    public void  GivenMessage_WhenNull_ShouldThrowExcepton() throws MoodAnalysisException {
        MoodAnalyzer MoodAnalyser = new MoodAnalyzer(null);
        Assert.assertEquals("Happy",MoodAnalyser.analyseMood());
    }
    @Test
    public void givenMessage_WhenNull_ThenShouldReturnCustomException() {
        try {
            MoodAnalyzer MoodAnalyser = new MoodAnalyzer(null);
            MoodAnalyser.analyseMood();
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NULL_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void GivenEmptyMessage_ShouldReturn_EmptyMoodException()
    {
        try{
            MoodAnalyzer MoodAnalyser = new MoodAnalyzer("");
            MoodAnalyser.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.EMPTY_EXCEPTION,e.userDefinedObject);
        }
    }
}
