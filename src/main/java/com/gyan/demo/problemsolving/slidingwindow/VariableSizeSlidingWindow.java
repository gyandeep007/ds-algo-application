package com.gyan.demo.problemsolving.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class VariableSizeSlidingWindow {

    //maximum subarray of sum k
    public static int solve1(int[] arr, int sum) {
        int i = 0, j = 0;
        int n = arr.length;
        int currentSum = 0;
        int maxSize = Integer.MIN_VALUE;

        while (j < n) {
            currentSum += arr[j];

            if (currentSum < sum) {
                j++;
                continue;
            } else if (currentSum == sum) {
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else if (currentSum > sum) {
                while (currentSum > sum) {
                    currentSum -= arr[i];
                    i++;
                }
                if (currentSum == sum) {
                    maxSize = Math.max(maxSize, j - i + 1);

                }
                j++;
            }
        }
        return maxSize;
    }

    //longest substring with K unique character
    public static int solve2(String input,int k){
        int i=0,j=0;
        int n = input.length();

        Map<Character,Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        while (j < n){

            if(!map.containsKey(input.charAt(i)))
                map.put(input.charAt(j),1);
            else{
                map.put(input.charAt(j),map.get(input.charAt(i))+1);
            }

            if(map.size() < k){
                j++;
                continue;
            }else if(map.size() == k){
                maxLength = Math.max(maxLength,j-i+1);
                j++;
            }else if(map.size() > k){
                while (map.size() > k){
                    char item = input.charAt(i);
                    if(map.containsKey(item)){
                        int count = map.get(item);
                        count = count-1;
                        if(count == 0) {
                            map.remove(item);
                            i++;
                            continue;
                        }
                        map.put(item,count);
                        i++;
                    }
                }
                if(map.size() == k){
                    maxLength = Math.max(maxLength,j-i+1);
                }
                j++;
            }
        }
        return maxLength;
    }

    //longest substring with All unique character
    // all unique character means in any window all character should be unique
    public static int solve3(String input){
        int i=0,j=0;
        int n = input.length();
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        while (j < n){
            if(!map.containsKey(input.charAt(j)))
                map.put(input.charAt(j),1);
            else
                map.put(input.charAt(j),map.get(input.charAt(j))+1);

            if(map.size() == j-i+1){
                maxLength = Math.max(maxLength,j-i+1);
                j++;

            }else if(j-i+1 > map.size()){
                while (j-i+1 > map.size()){
                    if(map.containsKey(input.charAt(i))){
                        int count = map.get(input.charAt(i));
                        if(count == 1){
                            map.remove(input.charAt(i));
                            i++;
                            continue;
                        }

                        map.put(input.charAt(i),count-1);
                        i++;
                    }
                }
                if(j-i+1 == map.size())
                    maxLength = Math.max(maxLength,j-i+1);

                j++;
            }

        }
        return maxLength;
    }

    //minimum window substring
    public static int solve4(String s,String t){
        int i=0,j=0;
        int n = s.length();
        int minLength = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for (int k = 0; k <t.length() ; k++) {
            if(!map.containsKey(t.charAt(k)))
                map.put(t.charAt(k),1);
            else
                map.put(t.charAt(k),map.get(t.charAt(k))+1);

        }
        int count = map.size();
        while (j < n){
           if(map.containsKey(s.charAt(j))){
               int currentCount = map.get(s.charAt(j));
               currentCount = currentCount-1;
               if(currentCount == 0){
                   count--;
               }
               map.put(s.charAt(j),currentCount);
           }

           if(count > 1){
               j++;
               continue;
           }else if(count == 0){
              minLength = Math.min(minLength,j-i+1);
               while (count == 0){
                   if(map.containsKey(s.charAt(i))){
                       int updatedCount = map.get(s.charAt(i));
                       updatedCount = updatedCount+1;
                       if(updatedCount == 1){
                           count++;
                       }
                       map.put(s.charAt(i),updatedCount);
                       i++;
                   }
               }
           }
        }
        return minLength;
    }

    public static   String solve5(String s,String t){
        int i=0,j=0;
        int n = s.length();
        int minLength = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for (int k = 0; k <t.length() ; k++) {
            if(!map.containsKey(t.charAt(k)))
                map.put(t.charAt(k),1);
            else
                map.put(t.charAt(k),map.get(t.charAt(k))+1);

        }
        String result="";
        int count = map.size();
        while (j < n){
            if(map.containsKey(s.charAt(j))){
                int currentCount = map.get(s.charAt(j));
                currentCount = currentCount-1;
                if(currentCount == 0){
                    count--;
                }
                map.put(s.charAt(j),currentCount);
            }

            if(count > 0){
                j++;
                continue;
            }else if(count == 0){
            //    minLength = Math.min(minLength,j-i+1);
                if(j-i+1 < minLength){
                    minLength = j-i+1;
                    result = s.substring(i,j+1);
                }
                while (count == 0){
                    if(map.containsKey(s.charAt(i))){
                        int updatedCount = map.get(s.charAt(i));
                        updatedCount = updatedCount+1;
                        if(j-i+1 < minLength){
                            minLength = j-i+1;
                            result = s.substring(i,j+1);
                        }
                        if(updatedCount == 1){
                            count++;
                        }
                        map.put(s.charAt(i),updatedCount);

                    }
                    i++;
                }

                j++;
            }
        }
        return result;
    }
}
