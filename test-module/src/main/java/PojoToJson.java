import java.io.*;
import java.lang.reflect.Field;
import java.util.stream.IntStream;

/**
 * Created by David on 01/05/2016.
 */
public class PojoToJson {

    private String pathToJson;
    private int tabLevel;


    public PojoToJson(String pathToJson) {
        this.tabLevel = 0;
        this.pathToJson = pathToJson;
    }

    private String createJsonStringFromPojo(Object object) {
        Class<?> pojoClass = object.getClass();
        Field[] declaredFields = pojoClass.getDeclaredFields();

        final String[] outputString = {"{"};

        IntStream.range(0, declaredFields.length).forEach(index-> {
            Field field = declaredFields[index];

            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            try {
                if (fieldType.isPrimitive() || fieldType.isAssignableFrom(Number.class) || fieldType.equals(String.class)) {
                    String commaSeparator = (index != 0) ? ",\n" : "\n";
                    outputString[0] += commaSeparator + createTabulators(tabLevel + 1) + "\"" + field.getName() + "\":" + " " + getStringValue(field.get(object).toString());

                }else{

                    outputString[0] += ",\n" + createTabulators(tabLevel + 1) + "\"" + field.getName() + "\":";
                    tabLevel++;
                    Object innerObject = field.get(object);
                    outputString[0] += (innerObject != null) ? createJsonStringFromPojo(innerObject) : null;
                    tabLevel--;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return outputString[0] + "\n" + createTabulators(tabLevel)  + "}";
    }

    public void createJsonFile(Object object){

        File file = new File(pathToJson);
        String outputString = createJsonStringFromPojo(object);
        try (OutputStream outputStream = new FileOutputStream(file)) {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.append(outputString);
            outputStreamWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createTabulators(int count){
        String outputString = "";
        for(int i = 0; i < count; i++){
            outputString += "\t";
        }
        return outputString;
    }

    private String getStringValue(String value) {
        return (value.matches("[-+]?(\\d*[.])?\\d+")) ? value : "\"" + value + "\"";
    }

}
