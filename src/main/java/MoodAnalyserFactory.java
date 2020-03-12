import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    public static MoodAnalyzer moodAnalyzerObject()
    {
        try
        {
            Class<?> MoodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor<?> constructor = MoodAnalyzerClass.getConstructor();
            Object moodAnalyzerObject = constructor.newInstance();
            return  (MoodAnalyzer) moodAnalyzerObject;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
