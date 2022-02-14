package leetcode.剑指Offer专项练习.day5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/2/14
 * @description
 */
public class Test4 {
    /**
     * 每次扩展一位，等到条件成立，然后收缩，最后变基
     *
     * @param source 长的字符串
     * @param target 短的字符串
     * @return
     */
    public String minWindow(String source, String target) {

        if (target.length() > source.length()) {
            return "";
        }

        // 维护滑动窗口
        int left = 0, right = 0;
        // 维护最小字串
        int subLeft = -1, subRight = -1;

        // 初始化need,need表示当前窗口还需要的元素数量，如果是负数，说明该元素多余
        Map<Character, Integer> need = new HashMap<>();

        // 通过needCnt表示所需元素总量，避免遍历字典
        int needCnt = 0;


        for (int i = 0; i < target.length(); i++) {
            int count = need.getOrDefault(target.charAt(i), 0) + 1;
            need.put(target.charAt(i), count);
            needCnt++;
        }


        // 每次扩展一位，如果窗口已经包含所有元素，收缩left,更新字串
        for (; right < source.length(); right++) {

            // 每当遇到一个所需元素needCnt--，该元素在map中对应值大于0
            // 如果遇到的是非必须元素，此时还不存在，所以需要getOrDefault得到默认的0
            if (need.getOrDefault(source.charAt(right), 0) > 0) {
                needCnt--;
            }

            // 让source.charAt(right)对应的need数量减一,如果need中所有元素都不大于0，即不需要任何元素，此时可以收缩
            need.put(source.charAt(right), need.getOrDefault(source.charAt(right), 0) - 1);


            // 当need==0,此时可以收缩,收缩时,need中多余元素值<0,需要元素值=0
            if (needCnt == 0) {
                // 如果遇到的元素是多余的，移除该元素(直到遇到非多余元素)
                while (need.get(source.charAt(left)) < 0) {
                    // 修改need值
                    need.put(source.charAt(left), need.get(source.charAt(left)) + 1);
                    left++;
                }

                // 更新 subString

                // 1. 还没有被赋值过  2. 当前subString更短
                if ((subLeft == -1 && subRight == -1) || (right - left) < (subRight - subLeft)) {
                    subLeft = left;
                    subRight = right;
                }

                // 变基 : left++ ，使得条件不成立
                // 由于丢弃一个有用元素，需要修改needCnt和对应的need
                need.put(source.charAt(left), 1);
                left++;
                needCnt = 1;
            }

        }


        if (subLeft == -1 && subRight == -1) {
            return "";
        }

        // Arrays.toString 会转换成[A,B,C]的形式
        return new String(Arrays.copyOfRange(source.toCharArray(), subLeft, subRight + 1));


    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(test4.minWindow(source, target));

    }
}

