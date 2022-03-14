package leetcode.剑指Offer专项练习.day21;

/**
 * @author kkddyz
 * @date 2022/3/11
 * @description
 */

class MagicDictionary {

    private TireNode root;

    public MagicDictionary() {
        root = new TireNode();
    }

    public void buildDict(String[] dictionary) {
        // 将所有单词插入Tire
        for (String word : dictionary) {
            insert(word);
        }
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


    /**
     * @param word         单词
     * @param changedIndex 修改位的下标
     * @return 修改对应下标后的单词是否存在
     */
    public boolean search(String word, int changedIndex) {

        // leat a 作为修改位
        TireNode cur = root;
        // 正常搜索，直到遇到修改位
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 遇到修改位
            if (i == changedIndex) {
                // 将当前字符替换成其他字符后继续匹配
                return searchFromChildren(word, i + 1, index, cur);
            }

            // 正常搜索
            if ((cur = cur.children[index]) == null) {
                return false;
            }
        }

        // changedIndex < word.length 因此一定会在循环中返回一个值,这里返回什么都无所谓
        return false;
    }

    public boolean search(String word) {
        // 枚举每一位作为修改位,只要有一个成功即可
        for (int i = 0; i < word.length(); i++) {
            if (search(word, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从i开始继续匹配字符word
     */
    private boolean searchFromI(String word, int i, TireNode root) {
        if (root == null) {
            return false;
        }

        TireNode cur = root;
        for (; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 搜索不到
            if ((cur = cur.children[index]) == null) {
                return false;
            }
        }

        return cur.isWord;
    }


    /**
     * 一般情况下，cur = cur.children[index];
     * 而如果遇到修改位，这个字符可以代表任何其他字符。
     * 因此，cur有25中选择，index=0就是认为当前字符修改为'a'依次类推..
     * <p>
     * 注意搜索时需要检查isWord()部分
     *
     * @param word        完整单词
     * @param start       匹配起点，只匹配word[start,len-1]
     * @param exceptIndex 不选择cur.children[exceptIndex]作为root，即cur != cur.children[exceptIndex]
     * @param cur         选择cur.children[i]作为root
     */
    private boolean searchFromChildren(String word, int start, int exceptIndex, TireNode cur) {
        for (int index = 0; index < 26; index++) {
            // 跳过排除的index
            if (index == exceptIndex) continue;
            // 将当前字符替换成 (char)(index + 'a'),继续搜索
            boolean flag = searchFromI(word, start, cur.children[index]);
            // 只需要保证所有index中至少有一个true
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        String[] dict = {"hello", "hallo", "leet"};
        dictionary.buildDict(dict);
        boolean b = dictionary.search("aeet");
        System.out.println(b);
    }
}
