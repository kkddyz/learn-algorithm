package leetcode.剑指offer.第三天字符串;

/**
 * @author kkddyz
 * @date 2021/11/23
 * @description
 */
public class ReplaceSpace {
    /**
     * 字符串在java中是不可以修改的
     */
    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();
        // 获取字符数组
        char[] chars = s.toCharArray();


        for (char aChar : chars) {
            // 如果是空格，就
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace s = new ReplaceSpace();
        System.out.println(s.replaceSpace("we are happy"));
    }
}