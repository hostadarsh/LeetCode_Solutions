class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[1] = nums[1];

        int i1 = 0;
        int i2 = 1;

        for(int i = 2; i < n; i++ ){
            if(arr1[i1] > arr2[i2]){
                i1++;
                arr1[i1] = nums[i];
            }
            else{
                i2++;
                arr2[i2] = nums[i];
            }
        }

        int[] result = new int[n];

        int a = 0;
        for(int j = 0; j <= i1; j++){
            result[a++] = arr1[j];
        }

        for(int j = 1; j <= i2; j++){
            result[a++] = arr2[j];
        }

        return result;
        
    }
}