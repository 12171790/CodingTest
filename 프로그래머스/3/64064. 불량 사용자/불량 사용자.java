import java.util.*;

class Solution {
    
    static String[] arr = new String[9];
    static int[] used = new int[9];
    static Set<String> set = new HashSet<>();
    static int countComb = 0;
    
    public static void func(int k, String[] user_id, String[] banned_id) {
        if (k == banned_id.length) {
            if (banned_id.length == match(k, banned_id)) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < k; i++) list.add(arr[i]);
                Collections.sort(list);
                String key = String.join(",", list);
                set.add(key);
            }
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (used[i] == 1) continue;
            
            arr[k] = user_id[i];
            used[i] = 1;
            func(k + 1, user_id, banned_id);
            used[i] = 0;
        }
        
    }
    
    public static int match(int k, String[] banned_id) {
        int cnt = 0;
        int[] alreadyMatched = new int[k];
        
        for (int i = 0; i < banned_id.length; i++) {
            int bannedIdLen = banned_id[i].length();
            
            for (int j = 0; j < k; j++) {
                if (bannedIdLen == arr[j].length() && alreadyMatched[j] != 1) {
                    boolean check = true;
                    
                    for (int o = 0; o < bannedIdLen; o++) {
                        if (banned_id[i].charAt(o) == '*') continue;
                        
                        if (banned_id[i].charAt(o) != arr[j].charAt(o)) {
                            check = false;
                            break;
                        }
                    }
                    
                    if (check) {
                        cnt++;
                        alreadyMatched[j] = 1;
                        break;
                    }
                }
            }
        }
        
        return cnt;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        func(0, user_id, banned_id);
        
        return set.size();
    }
}