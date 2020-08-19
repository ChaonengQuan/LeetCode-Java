package com.myDomain;

import java.util.*;

public class KeysAndRooms {

    //Algorithm
    //Take all the keys

    public static void main(String args[]) {
        KeysAndRooms myInstance = new KeysAndRooms();
        List<List<Integer>> rooms = new LinkedList<List<Integer>>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<Integer>());
        System.out.println(myInstance.canVisitAllRooms(rooms));
    }


    //Algorithm
    //Take all the keys


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> roomQueue = new LinkedList<Integer>();
        boolean[] roomVisited = new boolean[rooms.size()];

        roomQueue.add(0); //start with the first room
        roomVisited[0] = true;

        while(!roomQueue.isEmpty()){
            Integer currRoom = roomQueue.poll();  //current the room number

            for(Integer key : rooms.get(currRoom)){ //for each key in (all keys in the room)
                if( roomVisited[key] == false){
                    roomVisited[key] = true;
                    roomQueue.offer(key);
                }
            }

        }


        for(int i = 0; i < rooms.size(); i++){
            if(false == roomVisited[i])
                return false;
        }

        return true;
    }



}
