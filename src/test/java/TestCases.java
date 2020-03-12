import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.junit.Assert;
import org.junit.Test;

public class TestCases
{
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalysisException
    {
        MoodAnalyzer moodAnalyser = new MoodAnalyzer("I am in Sad Mood");
        Assert.assertEquals("Sad",moodAnalyser.analyseMood());
    }
    @Test
    public void givenMessage_WhenIncludeIAmInAnyMood_ShouldReturnHappy() throws MoodAnalysisException
    {
        MoodAnalyzer moodAnalyser = new MoodAnalyzer("I am in Any Mood");
        Assert.assertEquals("Happy",moodAnalyser.analyseMood());
    }
    @Test
    public void  givenMessage_WhenNull_ShouldThrowExcepton() throws MoodAnalysisException
    {
        MoodAnalyzer moodAnalyser = new MoodAnalyzer(null);
        Assert.assertEquals("Happy",moodAnalyser.analyseMood());
    }
    @Test
    public void givenMessage_WhenNull_ThenShouldReturnCustomException()
    {
        try
        {
            MoodAnalyzer moodAnalyser = new MoodAnalyzer(null);
            moodAnalyser.analyseMood();
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NULL_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void givenEmptyMessage_ShouldReturn_EmptyMoodException()
    {
        try
        {
            MoodAnalyzer moodAnalyser = new MoodAnalyzer("");
            moodAnalyser.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.EMPTY_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void givenObject_WhenEquals_ShouldReturnTrue() throws MoodAnalysisException
    {
        MoodAnalyzer moodAnalyser = new MoodAnalyzer();
        MoodAnalyzer moodAnalyserObject = MoodAnalyserFactory.moodAnalyzerObject();
        boolean result=moodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }
    @Test
    public void givenClassName_WhenWrong_ShouldThrowException()
    {
        try
        {
            MoodAnalyserFactory.moodAnalyzerObject();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_CLASS,e.userDefinedObject);
        }
    }
    @Test
    public void givenMethodName_WhenWrong_ShouldThrowException()
    {
        try
        {
            MoodAnalyserFactory.moodAnalyzerObject();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }
}
