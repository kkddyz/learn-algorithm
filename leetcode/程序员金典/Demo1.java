package leetcode.程序员金典;

import java.util.Objects;

/**
 * @author kkddyz
 * @date 2022/4/10
 * @description
 */
public class Demo1 {

    public boolean oneEditAway(String first, String second) {

        int diffLen = first.length() - second.length();
        int maxLen = Math.max(first.length(), second.length());
        int diffLenAbs = Math.abs(diffLen);


        // 分类套论 1. 长度相同  2. 长度差1 检查插入 3.差大于1
        if (diffLenAbs == 0) {

            int diffCnt = 0;// 统计diff字符个数

            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diffCnt++;
                    // diffCnt大于1
                    if (diffCnt > 1) {
                        return false;
                    }
                }
            }
            // 循环结束diffCnt <= 1
            return true;
        } else if (diffLenAbs == 1) {
            // 寻找冲突位置,由于长度不同,一定会存在冲突
            for (int i = 0; i < maxLen; i++) {
                // 遇到diff 判断subStr是否相等
                if (!Objects.equals(charAt(first, i), charAt(second, i))) {
                    return isSameSubStr(diffLen, first, second, i);
                }
            }
        }

        // 长度差超过1
        return false;
    }


    /**
     * @param diffLen -1 first短,second长; 1 first长,second短
     * @param i       shortStr从i开始,longStr从i+1开始比较
     * @return first, second的字串是否相等
     */
    private boolean isSameSubStr(int diffLen, String first, String second, int i) {

        // 根据diffLen判断谁短，谁长
        String shortStr, longStr;
        if (diffLen < 0) {
            shortStr = first;
            longStr = second;
        } else {
            shortStr = second;
            longStr = first;
        }

        // 寻找冲突
        for (; i < shortStr.length(); i++) {
            if (shortStr.charAt(i) != longStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取的下标越界，返回null
     * 注意：字符没有空值'',因此表示字符为空只能返回null,返回值类型设置为Character,而不是char
     */
    private Character charAt(String str, int index) {
        return index >= str.length() ? null : str.charAt(index);
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();


        System.out.println(demo1.oneEditAway("mart", "karma"));


    }
}
