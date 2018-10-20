package com.example.deepakwarrier.growth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GrowthDatabase {

    private String saveFilePath;
    private File saveFile;

    private JSONObject jsonObject;

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

            String allText = null; // bad style

            // read in text to string
            try(BufferedReader br = new BufferedReader(new FileReader(saveFile))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }

                allText = sb.toString();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // allText should be updated now

            try {
                // build a JSON object
                jsonObject = new JSONObject(allText);
                if (!jsonObject.getString("status").equals("OK"))
                    return;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }else{ // otherwise, create a default save
            createDefaultStartState();
            save();
        }
    }

    // save to file
    public void save(){
        //TODO save

        String toSave = jsonObject.toString();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

            bw.write(toSave);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // create a default starter state
    private void createDefaultStartState(){

        try {
            jsonObject = new JSONObject("\n" +
                    "{\n" +
                    "    \"activityPoints\": 10\n" +
                    "}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        save();
    }

    // returns safeFilePath
    public String getSaveFilePath(){
        return saveFilePath;
    }

    // returns current state of forest growth
    public int getCurrentForestGrowth(){
        int result = 0;
        try {
            result = jsonObject.getInt("activityPoints") / 2;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
