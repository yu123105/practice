package edu.mit.algorithm;

/**
 * Created by YuRuijie on 2016/3/8.
 */
public class Sort {
    /**
     * 插入算法 O(n^2)
     * @param input 47382 -> 24738 -> 23478
     * @return 23478
     */
    public static int[] insertSort(int[] input){
        if(input==null||input.length<=1){
            return input;
        }
        int swap = 0;
        for(int firstIndex=1; firstIndex<input.length; firstIndex++){
            for(int lastIndex=firstIndex; lastIndex>0; lastIndex-- ){
                //if input[i]<input[i-1] swap
                if(input[lastIndex]<input[lastIndex-1]){
                    swap = input[lastIndex];
                    input[lastIndex] = input[lastIndex-1];
                    input[lastIndex-1] = swap;
                }else{
                    break;
                }
            }
        }
        return input;
    }


    /**
     * O(nlgn)lgn->二叉树高度
     * @param input {47382}
     * @return 23478
     */
    private static int[] mergeSort(int[] input) {
        if(input.length==1){
            return input;
        }else{
            int[] first;
            int[] last;
            if(input.length%2==0){
                first = sliceArray(input, 0, input.length/2-1);
                last = sliceArray(input, input.length/2, input.length-1);
            }else{
                first = sliceArray(input, 0, (input.length-1)/2);
                last = sliceArray(input, (input.length-1)/2+1, input.length-1);
            }
            first = mergeSort(first);
            last = mergeSort(last);
            int[] output = merge(first, last);
            return output;
        }
    }

    /**
     *
     * @param first 已排序的数组1
     * @param last  已排序的数组2
     * @return 合并2个已排序好的数组
     */
    private static int[] merge(int[] first, int[] last) {
        int[] output = new int[first.length+last.length];
        for(int index=0,firstIndex=0, lastIndex=0; index<output.length; index++){
            if(firstIndex>=first.length){
                output[index] = last[lastIndex];
                lastIndex++;
            }else if(lastIndex>=last.length){
                output[index] = first[firstIndex];
                firstIndex++;
            }else if(first[firstIndex]>last[lastIndex]){
                output[index] = last[lastIndex];
                lastIndex++;
            }else if(last[lastIndex]>first[firstIndex]){
                output[index] = first[firstIndex];
                firstIndex++;
            }
        }
        return output;
    }

    /**
     *
     * @param input slice array
     * @param start index
     * @param end index
     * @return [start,end]
     */
    private static int[] sliceArray(int[] input, int start, int end){
        if(start<0||end>input.length-1||end<start){
            return input;
        }
        int[]output = new int[end-start+1];
        for(int i=0;i+start<=end; i++){
            output[i] = input[i+start];
        }
        return output;
    }

    public static void main(String[] args){
        int[] input = {4,7,3,8,2};
        input = mergeSort(input);
        System.err.println(input);
    }
}
