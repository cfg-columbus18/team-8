package com.example.deepakwarrier.growth;

import android.util.Log;

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

    private File saveFile;

    private JSONObject jsonObject;

    // constructor
    public GrowthDatabase(File internalFile){
        saveFile = internalFile;

        load();
    }

    // load from save file
    public void load(){
        Log.d("DB", "Loading...");

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

                Log.d("DB", "Loaded");

                allText = sb.toString();

            } catch (FileNotFoundException e) {
                Log.d("DB", "File not found!");
                e.printStackTrace();
            } catch (IOException e) {
                Log.d("DB", "IOException!");
                e.printStackTrace();
            }

            // allText should be updated now

            try {
                Log.d("DB", "Building JSON...");
                // build a JSON object
                jsonObject = new JSONObject(allText);
                if (!jsonObject.getString("status").equals("OK"))
                    return;

            } catch (JSONException e) {
                Log.d("DB", "JSONException");
                e.printStackTrace();
            }

        }else{ // otherwise, create a default save
            createDefaultStartState();
        }
    }

    // save to file
    public void save(){
        Log.d("DB", "Saving...");

        String toSave = jsonObject.toString();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

            Log.d("DB", "Writing...");
            bw.write(toSave);

        } catch (FileNotFoundException e) {
            Log.d("DB", "File not Found!");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("DB", "IOException!");
            e.printStackTrace();
        }
    }

    // create a default starter state
    private void createDefaultStartState(){
        Log.d("DB", "Creating Default Start state");

        try {
            jsonObject = new JSONObject("\n" +
                    "{\n" +
                    "    \"activityPoints\": 10\n" +
                    "}");
        } catch (JSONException e) {
            Log.d("DB", "JSONException");
            e.printStackTrace();
        }

        save();
    }

    // returns current state of forest growth
    public int getCurrentForestGrowth(){
        Log.d("DB", "Getting forest growth");

        int result = -1;
        try {
            result = jsonObject.getInt("activityPoints") / 2;
        } catch (JSONException e) {
            Log.d("DB", "JSONException");
            e.printStackTrace();
        }

        return result;
    }

    public void setUserName(String name){
        Log.d("DB", "Setting UserName");

        try {
            jsonObject.put("name", name);
        } catch (JSONException e) {
            Log.d("DB", "JSONException");
            e.printStackTrace();
        }

        save();
    }

    public String getUserName(){
        Log.d("DB", "Getting UserName");

        try {
            String name = jsonObject.getString("name");

            return name;
        } catch (JSONException e) {
            Log.d("DB", "JSONException");
            e.printStackTrace();
        }

        return null;
    }
}
