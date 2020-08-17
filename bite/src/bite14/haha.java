package bite14;

import java.util.*;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/13 18:31
 * @Description:
 */
public class haha {
    //1170,比较字符串最小字母出现的次数
//    public int[] numSmallerByFrequency(String[] queries, String[] words) {
//        int [] sum = new int[queries.length];
//        for(int i = 0;i<queries.length;i++){
//            int num = countM(queries[i]);
//            for(String s1:words){
//                if(num < countM(s1))
//                    sum[i]++;
//            }
//        }
//        return sum;
//    }
//    public static int countM(String s){
//        char min = s.charAt(0);
//        int count = 0;
//        for(int i = 0;i<s.length();i++){
//            if (s.charAt(i)<min) {
//                min = s.charAt(i);
//                count = 0;
//            }
//            if(s.charAt(i) == min)
//                ++count;
//        }
//        return count;
//    }
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> set = new HashSet<>();
            for(String bannedWord : banned)
                set.add(bannedWord.toLowerCase());//注意转为小写
            Map<String,Integer> map = new HashMap<>();

            int len = paragraph.length();
            int i = 0;
            //构造一个新的字符串，单词间用空格分隔 便于分割
            StringBuffer sb = new StringBuffer();
            while(i < len){
                if(!isZiMu(paragraph.charAt(i))){
                    while(i < len && !isZiMu(paragraph.charAt(i)))
                        i++;
                    if(i != len)
                        sb.append(' ');
                }else
                    sb.append(paragraph.charAt(i++));
            }

            String[] words = sb.toString().split(" ");

            for(String word : words){
                //转为小写
                word = word.toLowerCase();
                if(!set.contains(word)){
                    map.put(word,map.getOrDefault(word,0) + 1);
                }
            }

            String key = null;
            int max = 0;
            for(String k : map.keySet()){
                //System.out.println(k + " ");
                if(map.get(k) > max){
                    max = map.get(k);
                    key = k;
                }
            }
            return key;
        }

        //判断是否属于字母
        private boolean isZiMu(Character c){
            if(c >= 'A' && c <= 'Z')
                return true;
            if(c >= 'a' && c <= 'z')
                return true;
            return false;
        }
    }

}

//class Solution {
//    public int singleNumber(int[] nums) {
//        Map<Integer,Integer> map = new TreeMap<>();
//        for(int num:nums){
////            Integer n = map.get(num);
////            if(n == null){
////                map.put(num,1);
////            }else {
////                n++;
////                map.put(num,n);
////            }
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//        for(int num : nums){
//            if (map.get(num) == 1){
//                return num;
//            }
//        }
//        return -1;
//    }
//}
class Solution1 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new TreeSet<>();
        for (char ch:J.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        for (char ch: S.toCharArray()){
            if(set.contains(ch)){
                count++;
            }
        }
        return count;
    }
}
//class Main1{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String right = scanner.next();
//        String wrong = scanner.next();
//        Set<Character> wrongSet = new HashSet<>();
//        for(char ch:wrong.toCharArray()){
//            wrongSet.add(ch);
//        }
//        Set<Character> printSet = new HashSet<>();
//        for(char ch:right.toCharArray()){
//            if(!wrongSet.contains(ch)){
//                ch = Character.toUpperCase(ch);
//                if(! printSet.contains(ch)){
//                    System.out.print(ch);
//                    printSet.add(ch);
//                }
//            }
//        }
//        System.out.println();
//    }
//}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//class Solution {
//    public Node copyRandomList(Node head) {
//        if(head == null)
//            return null;
//        Map<Node,Node> mp = new HashMap<>();
//        Node newT,newH;
//        newH = newT = null;
//        Node cur = head;
//        while (cur != null){
//            Node node = new Node(cur.val);
//            if(newH == null){
//                newH = newT = node;
//            }else {
//                newT.next = node;
//                newT = newT.next;
//            }
//            //构建
//            mp.put(cur,node);
//            cur = cur.next;
//        }
//        //复制随机指针
//        cur = head;
//        newT = newH;
//        while (cur != null){
//            if(cur.random != null){
//                newT.random = mp.get(cur.random);
//            }else {
//                newT.random = null;
//            }
//            newT = newT.next;
//            cur = cur.next;
//        }
//        return newH;
//    }
//}
//class EntryComparator implements Comparator<Map.Entry<String,Integer>>{
//
//    @Override
//    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//        int diff = o1.getValue()-o2.getValue();
//        if (diff == 0){
//            return o1.getKey().compareTo(o2.getKey());
//        }
//        return diff;
//    }
//}
//class Solution {
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String,Integer> mp = new HashMap<>();
//        for(String word:words){
//            mp.put(word,mp.getOrDefault(word,0)+1);
//        }
//        //进行建堆操作
//        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new EntryComparator());
//        for(Map.Entry<String,Integer> entry:mp.entrySet()){
//            pq.offer(entry);
//            if(pq.size()>k){
//                pq.poll();
//            }
//        }
//        LinkedList<String> list = new LinkedList<>();
//        while (!list.isEmpty()){
//            list.addFirst(pq.poll().getKey());
//        }
//        return list;
//    }
//}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

////验证二叉搜索树
//class Solution {
//    public boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        double pre = -Double.MAX_VALUE;
//        while (!stack.isEmpty() || root != null){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if(root.val<=pre) return false;
//            pre = root.val;
//            root = root.right;
//        }
//        return true;
//    }
//}
//205  同构字符串
//class Solution {
//    public boolean isIsomorphic(String s, String t) {
//        return helper(s,t)&&helper(t,s);
//    }
//    public boolean helper(String s,String t){
//        Map<Character,Character> map = new HashMap<>();
//        int length = s.length();
//        for(int i = 0;i<length;i++){
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//            if (map.containsKey(c1)){
//                if (map.get(c1)!=c2)
//                    return false;
//            }else
//                map.put(c1,c2);
//        }
//        return true;
//    }
//}
//305
//class Solution {
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//        HashMap<Integer, Integer> m = new HashMap<>();
//        for (int n : nums1) {
//            m.put(n, m.getOrDefault(n, 0) + 1);
//        }
//        int k = 0;
//        for (int n : nums2) {
//            int cnt = m.getOrDefault(n, 0);
//            if (cnt > 0) {
//                nums1[k++] = n;
//                m.put(n, cnt - 1);
//            }
//        }
//        return Arrays.copyOfRange(nums1, 0, k);
//    }
//}
//349
//class Solution {
//    public int[] intersection(int[] nums1, int[] nums2){
//        if(nums1.length>nums2.length){
//            int[] temp = nums1;
//            nums1 = nums2;
//            nums2 = temp;
//        }
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> set1 = new HashSet<>();
//        for (int i:nums1){
//            set.add(i);
//        }
//        for (int j:nums2){
//            set1.add(j);
//        }
//        int k = 0;
//        for(int i:set){
//            if(set1.contains(i)){
//                nums1[k++] = i;
//            }
//        }
//        return Arrays.copyOfRange(nums1,0,k);
//    }
//}
//387
//class Solution {
//    public int firstUniqChar(String s) {
//        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            count.put(c, count.getOrDefault(c, 0) + 1);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (count.get(s.charAt(i)) == 1)
//                return i;
//        }
//        return -1;
//    }
//}
//class Solution {
//    public int getImportance(List<Employee> employees, int id) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(Employee employee:employees){
//            map.put(employee.id,employee.importance);
//        }
//        int count = 0;
//        int num = map.get(id);
//        List<Employee> emp = new LinkedList<>();
//        for(int i = 0;i<employees.size();i++){
//            if(id == employees.get(i).id){
//                emp.add(employees.get(i));
//            }
//        }
//        for(int i = 0;i<emp.size();i++){
//            count+=emp.get(i).importance;
//        }
//        int sum = count+num;
//        return sum;
//    }
//}

// Employee info
//class Employee {
//    // It's the unique id of each node;
//    // unique id of this employee
//    public int id;
//    // the importance value of this employee
//    public int importance;
//    // the id of direct subordinates
//    public List<Integer> subordinates;
//};
//
//class Solution {
//    public int getImportance(List<Employee> employees, int id) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(id);
//        int count = 0;
//        while (!queue.isEmpty()){
//            int up = queue.poll();
//            for(Employee e:employees){
//                if(e.id == up){
//                    count+=e.importance;
//                    for(int i:e.subordinates)
//                        queue.offer(i);
//                }
//            }
//        }
//
//        return count;
//    }
//}
class Solution {
    public int compareVersion(String version1, String version2) {
        int len = Math.max(version1.length(),version2.length());
        String[] strings1 = version1.split("//.");
        String[] strings2 = version2.split("//.");
        int [] a1 = new int[strings1.length];
        int[] a2 = new int[strings2.length];
        for(int i = 0;i<len;i++){
            if(i<strings1.length)
                a1[i] = Integer.valueOf(strings1[i]);
            if(i<strings2.length)
                a2[i] = Integer.valueOf(strings2[i]);
            if(a1[i]<a2[i])
                return -1;
            else if(a1[i]>a2[i])
                return 1;
        }
        return 0;
    }
    //658.找到K个最接近的元素
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++)
            list.add(arr[i]);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-x) - Math.abs(o2-x);
            }
        });
        list = list.subList(0,k);
        Collections.sort(list);
        return list;
    }
}