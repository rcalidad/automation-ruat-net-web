/**
 * @description This class consists exclusively of static methods that operate on data available in an Excel file.
 * @author RUAT
 * */

package main.helpers.dataUtility;

import main.helpers.common.CommonComponent;
import main.helpers.common.Constants;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ExcelData {
    /**
     * @description Se utilizó Java Reflection para inicializar los atributos de los page Objects con los datos establecidos en el archivo de datos.
     * @param
     */
    public static void load(int row_i, Object objExcel, Object objTask){
        Field fieldClass;
        Object objectExcel;
        Object fieldsExcel;
        Method methodGetKeys;
        Method methodGetValues;
        String attributeName;
        ArrayList< String > valuesList;
        try{
            objectExcel = objExcel;
            try {
                methodGetKeys = objectExcel.getClass ( ).getMethod ( "getClaves" );
                try {
                    fieldsExcel = methodGetKeys.invoke ( objectExcel );
                    for ( String fieldExcel_i: ( ArrayList < String > ) fieldsExcel )
                    {
                        fieldClass = null;
                        if( !fieldExcel_i.equals( "VOLVER" ) && !fieldExcel_i.equals( "USUARIO" ) )
                        {
                            attributeName = CommonComponent.removeAccents( fieldExcel_i.toLowerCase ( ) );
                            attributeName = CommonComponent.attributeNameFormat( attributeName );
                            if( isAttribute( objTask.getClass().getSuperclass(), attributeName ) )
                            {
                                fieldClass = objTask.getClass().getSuperclass ( ).getDeclaredField ( attributeName );
                            }
                            else if( isAttribute( objTask.getClass(), attributeName ) )
                            {
                                fieldClass = objTask.getClass().getDeclaredField (attributeName);
                            } else if (isAttribute(objTask.getClass().getSuperclass().getSuperclass(), attributeName)) {
                                fieldClass = objTask.getClass().getSuperclass().getSuperclass().getDeclaredField(attributeName);
                            }
                            methodGetValues = objectExcel.getClass ( ).getMethod ( "getParametro", String.class );
                            valuesList    = ( ArrayList < String > ) methodGetValues.invoke ( objectExcel, fieldExcel_i );
                            fieldClass.setAccessible(true);
                            if ( fieldClass.getType ( ).toString ( ).equals( "int" ) )
                            {
                                fieldClass.set ( objTask,  Integer.parseInt( valuesList.get ( row_i ) ) );
                            }
                            else
                            {
                                fieldClass.set ( objTask,  valuesList.get ( row_i ) );
                            }
                        }
                    }
                }catch (InvocationTargetException invocationTargetException){
                    invocationTargetException.printStackTrace ( );
                } catch (NoSuchFieldException noSuchFieldException) {
                    noSuchFieldException.printStackTrace();
                }
            }catch (NoSuchMethodException noSuchMethodException){
                noSuchMethodException.printStackTrace ( );
            }
        }catch (IllegalArgumentException | IllegalAccessException illegalOperationException){
            illegalOperationException.printStackTrace ( );
        }
    }
    public static boolean isAttribute(Class < ? > aClass, String string ){
        Field[] declaredFields = aClass.getDeclaredFields ( );
        for (Field field : declaredFields)
        {
            if (field.getName ( ).equals ( string ) )
                return true;
        }
        return false;
    }
    public static String getUrl(String excelFilePath){
        AccessExcel urlConfigurationFile = new AccessExcel(excelFilePath, Constants.ENVIRONMENT_DATA_SHEET);
        return urlConfigurationFile.getParametro(Constants.ENVIRONMENT_DATA_SHEET).get(0);
    }
    public static String getUser(String excelFilePath, AccessExcel accessExcel, int row_i){
        String user = getValue(accessExcel, row_i, Constants.USUARIO_PARAMETER).toUpperCase();
        String town = getValue(accessExcel, row_i, Constants.MUNICIPIO_PARAMETER);
        if (!town.equals("NACIONAL")){
            AccessExcel helpData = new AccessExcel(excelFilePath, Constants.AUXILIARY_DATA_SHEET);
            ArrayList<String> townsNames = helpData.getParametro(Constants.MUNICIPIO_PARAMETER);
            String shortName = getValue(helpData, townsNames.indexOf(town), Constants.ABREVIACION_MUNICIPIO_PARAMETER);
            user = user.concat(".").concat(shortName);
            user = user.toUpperCase();
        }
        return user;
    }
    public static String getPassword(String user){
        return user.substring(0,1).concat(Constants.DEFAULT_PART_OF_PASSWORD);
    }
    public static String getValue(AccessExcel accessExcel, int row_i, String field){
        String value = accessExcel.getParametro(field).get(row_i);
        return value.trim();
    }
    public static String getBeforeTown(AccessExcel accessExcel, int row_i){
        return row_i > 0 ? accessExcel.getParametro(Constants.MUNICIPIO_PARAMETER).get(row_i - 1): "";
    }
}
