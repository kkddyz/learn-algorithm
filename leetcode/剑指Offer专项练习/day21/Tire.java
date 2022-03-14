package leetcode.剑指Offer专项练习.day21;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/3/11
 * @description
 */


class TireNode {
    // 是否是单词
    boolean isWord;

    // 指向26个英文字母
    TireNode[] children;


    public TireNode() {
        isWord = false;
        children = new TireNode[26];
    }
}

public class Tire {


    // root不存储数据
    private TireNode root;

    public Tire() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TireNode();
            }
            cur = cur.children[index];
        }
        // 循环结束 将cur执行啊你管得最后一个TireNode.isWord置为ture
        cur.isWord = true;
    }

    public boolean search(String word) {

        TireNode cur = find(word);
        return cur != null && cur.isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    /**
     * 返回str匹配到的最短前缀,
     * 如果匹配不到返回str
     * 如果返回str，好处是不需要在外部判断，但是问题在于你无法直到到底有没有替换掉
     * 所以从逻辑和理性上，我觉得还是应该返回""(不要返回null)
     */
    public String replaceWithRoot(String str) {
        TireNode current = root;

        // 遍历每一个单词对应的TireNode，直到isWord
        // 符合条件的部分(可以匹配到且不是word)是[0,i-1] 当i == 0 str[0,-1]用null表示
        // 当 i != 0, 符合条件部分是[0,i-1]，但是最后需要将i算上，即返回str[0,i] 对应的len = i+1

        // 当i = 0时,有两种情况 1. 没有匹配到 返回"". 匹配到但是是word 返回str[0,0]
        // 当i = i时，不会出现情况1，因为如果出现，在上一轮就是情况2 如果是情况二 返回[0,i]

        // 但是情况一只会在 i==0时出现，

        // 注意 i 与 cur 的变化不是原子性的
        int i;
        for (i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if ((current = current.children[index]) == null || current.isWord) {
                break;
            }// else 说明当前字符在前缀树中,不是word
        }

        // 需要判断导致循环结束的是哪一种情况
        // 情况2
        if (current != null) {
            return new String((Arrays.copyOf(str.toCharArray(), i + 1)));
        } else {
            return "";
        }
    }

    //
    //public String replaceWords(List<String> dictionary, String sentence) {
    //
    //    Tire tire = new Tire();
    //
    //    // 将字典中的词根加入Tire
    //    for (String root : dictionary) {
    //        tire.insert(root);
    //    }
    //
    //    String newSentence = "";
    //    for (String word : sentence.split(" ")) {
    //
    //    }
    //}

    /**
     * 返回最终匹配到的TireNode
     */
    private TireNode find(String str) {
        TireNode current = root;

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if ((current = current.children[index]) == null) {
                return null;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Tire tire = new Tire();
        tire.insert("a");
        tire.insert("b");
        tire.insert("c");

        String sentence = "aadsfasf absbs bbab cadsfafs";
        String[] words = sentence.split(" ");
        for (String word : words) {
            String replaceWord;
            // 返回空串，表面没有匹配到对应的词根
            if ("".equals(replaceWord = tire.replaceWithRoot(word))) {
                System.out.println(word);
            } else {
                System.out.println(replaceWord);
            }
        }
    }
}
