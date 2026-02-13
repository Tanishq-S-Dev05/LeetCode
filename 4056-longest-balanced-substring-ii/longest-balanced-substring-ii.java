import java.util.*;

class Solution {

    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 1;
        for (char ch : new char[]{'a', 'b', 'c'}) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == ch) {
                    cnt++;
                    ans = Math.max(ans, cnt);
                } else {
                    cnt = 0;
                }
            }
        }

        ans = Math.max(ans, longestTwo(s, 'a', 'b'));
        ans = Math.max(ans, longestTwo(s, 'a', 'c'));
        ans = Math.max(ans, longestTwo(s, 'b', 'c'));


        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int A = 0, B = 0, C = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') A++;
            else if (ch == 'b') B++;
            else C++;

            int key = (A - B) * 200001 + (B - C);

            if (map.containsKey(key)) {
                ans = Math.max(ans, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return ans;
    }

    private int longestTwo(String s, char x, char y) {
        int n = s.length();
        int size = 2 * n + 1;

        int[] first = new int[size];
        int[] seen = new int[size];
        int version = 1;

        int sum = 0, res = 0;

        first[n] = -1;
        seen[n] = version;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == x) sum++;
            else if (c == y) sum--;
            else {
                version++;     
                sum = 0;
                first[n] = i;
                seen[n] = version;
                continue;
            }

            int idx = sum + n;
            if (seen[idx] == version) {
                res = Math.max(res, i - first[idx]);
            } else {
                seen[idx] = version;
                first[idx] = i;
            }
        }
        return res;
    }
}