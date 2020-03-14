import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
    public static Object invokeMethod(Object moodAnalyserObject, String analyzer) throws MoodAnalysisException
    {
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
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedDataType.NO_SUCH_METHOD);
        }
        return null;
    }
    public static void setFieldValue(Object moodObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Class className = moodObject.getClass();
            Field field = className.getDeclaredField(fieldName);
            field.set(moodObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(e.getMessage(),MoodAnalysisException.UserDefinedDataType.NO_SUCH_FIELD);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(e.getMessage(),MoodAnalysisException.UserDefinedDataType.NO_ACCESS);
        }

    }

}
