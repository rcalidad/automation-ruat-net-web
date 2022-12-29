package main.actions;

public class GiveFormat {
    public static String ofTitle(String title){  //title: ModificarDatos -> MODIFICAR-DATOS
        char charsArray[] = title.toCharArray();
        String newTitle="";
        int j = 0;
        for (int i = 0; i < charsArray.length; i++){
            if (Character.isUpperCase(charsArray[i])){
                if (i != 0){
                    newTitle = newTitle + title.substring(j,i) + "-";
                    j = i;
                }
            }
        }
        newTitle = newTitle + title.substring(j,title.length());
        return newTitle.toUpperCase();
    }
    public static String ofReportName(String reportName){ //reportName: Modificar Datos -> MODIFICAR-DATOS
        String name = reportName.toUpperCase().trim();
        name.replace(" ", "-");
        return name;
    }
}
