package com.gyan.demo.problemsolving.slidingwindow;


import java.util.*;

public class FixedSizeSlidingWindow {

    //max sum of subarray of size k
    // brute force
    public static int solve1(int[] arr,int k){
        int n   = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <=n-k ; i++) {
            int current = 0;
            for (int j = i; j <k+i ; j++) {
                current += arr[j];
            }

            if(current > max)
                max = current;
        }
        return max;
    }
    // applying fixed size sliding window
    public static int solve3(int[] arr,int k){
        int n = arr.length;
        int i=0,j=0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (j < n){
            sum+=arr[j];

            if(j-i+1 < k){
                j++;
                continue;
            }else if(j-i+1 == k){
                max = Math.max(max,sum);
                sum-=arr[i];
                i++;
                j++;
            }

        }
        return max;
    }

    //first negative number in every window of size k
    public static List<Integer> solve4(int[] arr,int k){
        int n = arr.length;
        int i=0,j=0;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        while (j < n){
            if(arr[j] < 0)
                queue.add(arr[j]);

            if(j-i+1 < k){
                j++;
                continue;
            }else if(j-i+1 == k){
                list.add(queue.isEmpty()?0:queue.peek());

                if(!queue.isEmpty() && arr[i] == queue.peek()){
                    queue.poll();
                }
                i++;
                j++;
            }
        }
        return list;
    }

    //count occurrence of anagrams
    public static int solve5(String input,String ptr){
        int i=0,j=0;
        int n = input.length();
        int maxCount = 0;
        Map<Character,Integer> table = new HashMap<>();
        for (int k = 0; k <ptr.length() ; k++) {
            char item = ptr.charAt(k);
            if(!table.containsKey(item))
                table.put(item,1);
            else {
               table.put(item,table.get(item)+1);
            }
        }
        int count = table.size();
        int k = ptr.length();
        while (j < n){
            if(table.containsKey(input.charAt(j))){
                int updatedCount = table.get(input.charAt(j));
                updatedCount = updatedCount-1;
                if(updatedCount == 0)
                    count--;

                table.put(input.charAt(j),updatedCount);
            }

            if(j-i+1 < k){
               j++;
               continue;
            }else if(j-i+1 == k){
                if(count == 0)
                    maxCount++;

                if(table.containsKey(input.charAt(i))){
                    int updatedCount = table.get(input.charAt(i));
                      if(updatedCount == 0)
                          count++;
                      table.put(input.charAt(i),updatedCount+1);
                }
                i++;
                j++;
            }
        }
        return maxCount;
    }
    //maximum of all subarray of size k
    public static List<Integer> solve6(int[] arr,int k){
        int i=0,j=0;
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> maxList = new ArrayList<>();

        while (j < n){
            if(queue.isEmpty()){
                queue.add(arr[j]);
            }else {
                while (!queue.isEmpty() && queue.peek() <= arr[j])
                    queue.poll();
                queue.add(arr[j]);
            }

            if(j-i+1 < k){
                j++;
                continue;
            }else if(j-i+1 == k){
                maxList.add(queue.peek());

                if(queue.peek() == arr[i])
                    queue.poll();

                i++;
                j++;
            }
        }
        return maxList;
    }
    //given value of r find the max of each subarray of size 2*r+1
    public static int[] solve2(int[] arr,int r){
        int n = arr.length;
        int i=0;
        int j=0;
        int k=0;
        int[] b = new int[n];
        r = r> n ?n:r;
        Queue<Integer> queue = new ArrayDeque<>();
        while (j < n){


            if(queue.isEmpty()) {
                queue.add(arr[j]);
            }else {
                while (!queue.isEmpty() && queue.peek() <= arr[j])
                    queue.poll();

                queue.add(arr[j]);
            }

            if(j-k+1 < r+1) {
                j++;
                continue;
            }else if(j-k+1 == r+1){
                b[k++] = queue.peek();
                j++;
            } if(k-i+1 > r+1){
                if(!queue.isEmpty() && queue.peek() == arr[i]){
                    queue.poll();
                }
                i++;
            }
        }

        while(k<j) {
            b[k++] = queue.peek();

        }

        return b;
    }
}
