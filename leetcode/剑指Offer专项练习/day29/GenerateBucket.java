package leetcode.剑指Offer专项练习.day29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/23
 * @description
 */
public class GenerateBucket {

    private String leftBracket = "(";
    private String rightBracket = ")";

    private List<String> ans = new ArrayList<>();

    private int n;

    // 只需要保证右括号数量不超过没有配对的左括号
    public List<String> generateParenthesis(int n) {
        this.n = n;

        recurse(new StringBuilder(), 0, 0);
        return ans;
    }

    // sb是当前选择的括号
    public void recurse(StringBuilder sb, int left, int right) {


        // 排序结束，记录排序
        if (left == right && left == n) {
            ans.add(sb.toString());
            return;
        }


        if (left == right) {
            // 1. 只能选择left
            recurse(sb.append(leftBracket), left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left == n) {
            // 2. 只能选择right
            recurse(sb.append(rightBracket), left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // 3. 两种都可以
            recurse(sb.append(leftBracket), left + 1, right);
            sb.deleteCharAt(sb.length() - 1);

            recurse(sb.append(rightBracket), left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        GenerateBucket s = new GenerateBucket();
        System.out.println(s.generateParenthesis(3));
    }
}
