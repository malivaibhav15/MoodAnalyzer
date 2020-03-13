import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory
{
    public static Constructor getConstructor(String className,Class ... paramters) throws MoodAnalysisException
    {
        try
        {
            Class moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(paramters);
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException("class not found",MoodAnalysisException.UserDefinedDataType.NO_SUCH_CLASS);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedDataType.NO_SUCH_METHOD);
        }
    }
    public static MoodAnalyzer createMoodAnalyser(Constructor constructor, Object ... message)throws MoodAnalysisException {
        try
        {
            return (MoodAnalyzer) constructor.newInstance(message);
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
    public static Object invokeMethod(Object moodAnalyserObject, String analyzer) {
        try {
            Class objectClass = moodAnalyserObject.getClass();
            Method moodMethod = objectClass.getMethod(analyzer);
            Object result = moodMethod.invoke(moodAnalyserObject);
            return result;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
