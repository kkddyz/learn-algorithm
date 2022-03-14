package leetcode.other;

/**
 * @author kkddyz
 * @date 2022/3/10
 * @description
 */
public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] answer = new int[2];
        answer[0] = arr[0];
        answer[1] = arr[1];

        // arr[i]作为被除数 arr[j]作为除数
        for (int i = 0; i < arr.length; i++){
            for (int j = arr.length - 1; j >= 0; j--){
                if (--k == 0){
                    answer[0] = arr[i];
                    answer[1] = arr[j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction s = new KthSmallestPrimeFraction();
        s.kthSmallestPrimeFraction(new int[]{1,2,3,5},3);
    }
}
