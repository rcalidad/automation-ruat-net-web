package main.tasks.commonTasks;

public class GetExtension {
    public static String ofUsername(String userName){
        String town = userName.split("\\.")[1];
        return town;
    }
}
