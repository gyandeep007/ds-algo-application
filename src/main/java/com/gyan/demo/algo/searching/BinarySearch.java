package com.gyan.demo.algo.searching;

public class BinarySearch {

    //iterative way
    public static int solve1(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == target) {
                System.out.println("element found at index " + mid);
                return mid;
            }else if(arr[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    //recursive way
    public static int solve2(int[] arr,int start,int end,int target){

        if(start > end)
            return -1;

        int mid = (start + end)/2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target)
            return solve2(arr,mid+1,end,target);
        else
            return solve2(arr,start,mid-1,target);
    }

    //binary search on reverse sorted array
    public static int solve3(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target){
                end = mid-1;;
            }else
                start = mid+1;
        }

        return -1;
    }

    //first occurrence of an element
    public static int solve4(int[] arr,int target){
        int start = 0;
        int end  = arr.length-1;
        int ans = -1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == target){
                ans = mid;
                end = mid-1;
            }else if(arr[mid] < target){
                start = mid+1;
            }else
                end = mid-1;

        }
        return ans;
    }
    //last occurrence of an element
    public static int solve5(int[] arr,int target){
        int start = 0;
        int end  = arr.length-1;
        int ans = -1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == target){
                ans = mid;
                start = mid+1;
            }else if(arr[mid] < target){
                start = mid+1;
            }else
                end = mid-1;

        }
        return ans;
    }

    //count of an element in a sorted array
    public static int solve6(int[] arr,int target){
        int i1 = solve4(arr,target);
        int i2 = solve5(arr,target);
        return i2-i1+1;
    }

    //count how many times a sorted array is rotated
    public static int solve7(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] < arr[(mid+1)%n] && arr[mid] < arr[(n+mid-1)%n]){
               ans = mid;
               break;
            }else if(arr[start] <= arr[mid])
                start = mid+1;
            else if(arr[mid] <= arr[end])
                end = mid-1;
        }
        return ans == -1?0:n-ans;
    }
    //find floor of an element
    public static int solve8(int[] arr,int element){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == element){
                ans = arr[mid];
                break;
            }else if(arr[mid] < element){
                ans = arr[mid];
                start = mid+1;
            }else{
                end = mid-1;
            }

        }
        return ans;
    }

    //find floor of an element
    public static int solve9(int[] arr,int element){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == element){
                ans = arr[mid];
                break;
            }else if(arr[mid] < element){
                start = mid+1;
            }else{
                ans = arr[mid];
                end = mid-1;
            }

        }
        return ans;
    }

}
