package main.tasks.commonTasks;

public class VerifyYear {
    public static boolean isIntoYearsRange(String year, String initialYear, String finalYear) {
        int startYear = initialYear.equals("") ? 0 : Integer.parseInt(initialYear);
        int endYear = finalYear.equals("") ? 0 : Integer.parseInt(finalYear);
        String yearAux = year;
        if (year.contains("/")){
            String[] parts = year.split("/");
            yearAux = parts[parts.length - 1];
        }
        if(!yearAux.equals("")){
            if(Integer.parseInt(yearAux) >= startYear && Integer.parseInt(yearAux) <= endYear){
                return true;
            }
        }
        return false;
    }
}
