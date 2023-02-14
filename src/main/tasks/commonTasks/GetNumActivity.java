package main.tasks.commonTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GetNumActivity {
    public static String ofAText(String text){
        String example = text;
        String[] string = example.split(" ");
        List<String> lstNumbers = new ArrayList<>();
        for(String word : string){
            if(Pattern.matches("[0-9]+", word)){
                lstNumbers.add(word);
            }
        }
        if(lstNumbers.size() > 0){
            return lstNumbers.get(0);
        }
        return "";
    }
}
