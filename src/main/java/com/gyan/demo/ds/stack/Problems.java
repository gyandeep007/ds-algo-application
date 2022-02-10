package com.gyan.demo.ds.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problems {

    public static boolean matchParenthesis(String input){
        Set<Character> parenthesisSet = new HashSet<>();
        HashMap<Character,Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put(')','(');
        parenthesisMap.put('[',']');
        parenthesisMap.put('}','}');
        parenthesisSet.addAll(parenthesisMap.values());

        Stack<Character> parenStack = new Stack<>();
        try {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (parenthesisSet.contains(ch)) {
                    parenStack.push(ch);
                }
                if(parenthesisMap.containsKey(ch)){
                    char lastParam = parenStack.pop();
                    if(lastParam != parenthesisMap.get(ch))
                        return false;

                }
            }
            return parenStack.isEmpty();
        }catch (Exception e){

        }
      return false;
    }
}
