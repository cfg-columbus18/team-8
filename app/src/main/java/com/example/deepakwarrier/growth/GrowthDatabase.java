package com.example.deepakwarrier.growth;

import java.io.File;

public class GrowthDatabase {

    private String saveFilePath;
    private File saveFile;

    private int activityPoints;


    // constructor
    public GrowthDatabase(String filepath){
        saveFilePath = filepath;
        saveFile = new File(saveFilePath);

        load();
    }

    // load from save file
    public void load(){

        // if there already is a save file, load
        if(saveFile.exists() && !saveFile.isDirectory()) {
            //TODO load
        }else{ // otherwise, create a default save
            createDefaultStartState();
            save();
        }
    }

    // save to file
    public void save(){
        //TODO save
    }

    // create a default starter state
    private void createDefaultStartState(){
        activityPoints = 10;
    }

    // returns safeFilePath
    public String getSaveFilePath(){
        return saveFilePath;
    }

    // returns current state of forest growth
    public int getCurrentForestGrowth(){
        int result = activityPoints / 2;

        return result;
    }
}
