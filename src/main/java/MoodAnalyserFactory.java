import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    public static MoodAnalyzer moodAnalyzerObject() throws MoodAnalysisException {
        try
        {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor<?> constructor = moodAnalyzerClass.getConstructor();
            Object moodAnalyzerObject = constructor.newInstance();
            return  (MoodAnalyzer) moodAnalyzerObject;
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException("Class not found",MoodAnalysisException.UserDefinedDataType.NO_SUCH_CLASS);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
