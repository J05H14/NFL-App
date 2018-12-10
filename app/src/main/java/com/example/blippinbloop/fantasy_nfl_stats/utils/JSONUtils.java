package com.example.blippinbloop.fantasy_nfl_stats.utils;

import com.example.blippinbloop.fantasy_nfl_stats.Player;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONUtils {
    public static List<Player> parsePlayers(String jsonResult){
        List<Player> playerList = new ArrayList<>();
        try{
            JSONObject mainJSONObject = new JSONObject(jsonResult);
            JSONArray players = mainJSONObject.getJSONArray(("players"));

            for(int i = 0; i < players.length(); i++){
                JSONObject player = players.getJSONObject(i);
                if(player.getString("currentRosterStatus").equals("ROSTER")){
                    JSONObject jsonTeam = player.getJSONObject("currentTeam");

                    String fname = player.getString("firstName");
                    String lname = player.getString("lastName");
                    String pos = player.getString("primaryPosition");
                    String team = jsonTeam.getString("abbreviation");

                    playerList.add(new Player(team, fname, lname, pos));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return playerList;
    }
}
