/**
 * @description This class consists exclusively of static methods that operate with strings which represents a directory or a file. Its purpose is maintains a specific order of
 * results generated with each execution of the generators.
 * @date 07/10/2022
 * @author Sol Maria Condori Ticona
 * */
package main.helpers.fileUtility;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.awaitility.Awaitility.*;
import static java.util.concurrent.TimeUnit.*;

public class FileBuilder {

    private  static final String path = System.getProperty("user.home").replace('\\', '/') + "/Downloads/";
    public static String pathFile;

    public static void newDirectory(String operation, String subsystem){
        String name = subsystem.concat("-").concat(getDate()).concat("-").concat(getTime()).concat("-").concat(operation);
        String directoryName = path.concat(name.toUpperCase());
        File directory = new File(directoryName);
        if (!directory.exists()){
            if (directory.mkdirs()){
                pathFile = directoryName;
            }
        }
    }
    public static void renameReport(String currentFileName, String operation, String debtDetail, String identifier, String subsystem, int numberCase){
        String fileName = String.valueOf(numberCase).concat("-").concat(subsystem).concat("-").concat(operation).concat("-").concat(identifier).concat("-").concat(debtDetail);
        try{
            File oldReport = new File(pathFile.concat("/").concat(currentFileName));
            File newReport = new File(pathFile.concat("/").concat(fileName).concat(".pdf"));
            oldReport.renameTo(newReport);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getDate(){
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
    public static String getTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("hhmmss"));
    }
    public static boolean waitUntilDownload(String fileName, String pathDownload){
        File fileDownloaded = new File(pathDownload.concat(fileName));
        //await().atMost(1, MINUTES).ignoreExceptions().until(() -> fileDownloaded.exists());
        with().pollInterval(100, MILLISECONDS).await().atMost(1, MINUTES).ignoreExceptions().until(() -> fileDownloaded.exists());
        return true;
    }
    public static String getPathTemporalDirectory(){
        File temp_directory = new File(path.concat("temp_test"));
        if(!temp_directory.exists()){
            temp_directory.mkdirs();
        }
        return path.concat("temp_test");
    }
    public static boolean moveFile(String fileName){
        String pathTemporalDirectory = getPathTemporalDirectory().concat("/");
        boolean sw = false;
        if(waitUntilDownload(fileName, pathTemporalDirectory)){
            File currentFile = new File(pathTemporalDirectory.concat(fileName));
            if (currentFile.renameTo(new File(pathFile.concat("/").concat(fileName)))){
                currentFile.delete();
                sw = true;
            }
        }
        return sw;
    }
    public static boolean moveAndRenameFile(String originalFilename, String operation, String debtDetail, String identifier, String subsystem, int numberCase){
        String pathTemporalDirectory = getPathTemporalDirectory().concat("/");
        String newFilename = String.valueOf(numberCase).concat("-").concat(subsystem).concat("-").concat(operation).concat("-").concat(identifier).concat("-").concat(debtDetail);
        if(waitUntilDownload(originalFilename, pathTemporalDirectory)) {
            File currentFile = new File(pathTemporalDirectory.concat(originalFilename));
            File newFile = new File(pathFile.concat("/").concat(newFilename));
            if (currentFile.exists()){
                try{
                    InputStream in = new FileInputStream(currentFile);
                    OutputStream out = new FileOutputStream(newFile);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = in.read(buffer)) > 0){
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    return currentFile.delete();
                }catch (IOException ioException){
                    ioException.printStackTrace();
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
    public static void deleteTemporalDirectory(){
        moveFile("Index.html");
        File tempDirectory = new File(getPathTemporalDirectory());
        tempDirectory.delete();
    }

}
