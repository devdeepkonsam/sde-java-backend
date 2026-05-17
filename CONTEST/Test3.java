package CONTEST;


public class Test3{
    void main(){
        int number = 515;
        int x = 5;
        System.out.println(isValid(number, x));
    }


    boolean isValid(int number, int x){
        if(number>=0 && number<10){
            return false;
        }
        boolean isvalid = false;
        int digit = 0;
        while(number>0){
            digit = number%10;
            number = number/10;
            if(number<10){
                if(number==x){
                    return false;
                }
            }
            if(digit == x){
                isvalid = true;
            }
        }
        return isvalid;
    }



    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        int peakIndex = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                peakIndex = i;
                break;
            }
        }
        int[] jorvanelik = nums;
        long ascSum = 0;
        long descSum = 0;
        
        for (int i = 0; i <= peakIndex; i++) {
            ascSum += jorvanelik[i];
        }
        
        for (int i = peakIndex; i < n; i++) {
            descSum += jorvanelik[i];
        }
        
        if (ascSum > descSum) {
            return 0;
        } else if (descSum > ascSum) {
            return 1;
        } else {
            return -1;
        }
    }

}