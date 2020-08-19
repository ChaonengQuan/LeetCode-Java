package com.myDomain;

import java.util.Stack;

public class BaseballGame {


    public int calPoints(String[] ops) {

        Stack<Integer> history = new Stack<Integer>();
        int sum = 0;
        Integer currRound;
        Integer lastRound;

        for (String op : ops) {
            switch (op) {
                case "+":
                    if (history.size() > 1) {
                        //plus two previous round
                        lastRound = history.pop();
                        Integer lastLastRound = history.peek();
                        currRound = lastRound + lastLastRound;
                        history.push(lastRound);
                        history.push(currRound);
                        sum += currRound;
                    }
                    break;
                case "D":
                    //edge case handle
                    if (history.size() > 0) {
                        //double last round points
                        lastRound = history.peek();
                        currRound = lastRound * 2;
                        sum += currRound;
                        history.push(currRound);
                    }
                    break;
                case "C":
                    if (history.size() > 0) {
                        currRound = history.pop();
                        sum -= currRound;
                    }
                    break;
                default:
                    currRound = Integer.valueOf(op);
                    sum += currRound;
                    history.push(currRound);
            }
        }

        return sum;
    }


}
