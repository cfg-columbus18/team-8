package com.example.deepakwarrier.growth;

public class GrowthDatabase {

    private String saveFilePath = "testfile.sav";

    private int activityPoints = 10;


    // constructor
    public GrowthDatabase(String filepath){
        saveFilePath = filepath;

        load(saveFilePath);
    }

    // load from save file
    public void load(String filepath){

    }

    // save to file
    public void save(String filepath){

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
