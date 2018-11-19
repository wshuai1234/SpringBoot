// topological sort
// use map + BFS
// alien dictionary
// 1. get all the characters appeared in the input
// 2.for each pair of words, update the indegree of second character
// 3. use queue to implement BFS
// 4. remove one from the head of the queue and for all map.get(char), reduce its indegree by 1
// 5. if the indegree is 0 , then append to the tail of the queue 
/ 6. the terminal condition is queue is isEmpty
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String result = "";
        if (words == null || words.length == 0){
            return result;
        }
        // set all character in words 's indegree to be 0
        for (String s : words){
            for (char c : s.toCharArray()){
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++){
            // compare neighbor words
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)){
                        set = map.get(c1);
                    }
                    if (! set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    // we have got the direction from c1 => c2
                    break;
                }
            }
        }
        // now we have got all the character and its indegree
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()){
            if (degree.get(c) == 0){
                q.add(c);
            }
        }
        // now queue have all the roots
        // now BFS all the roots
        while (! q.isEmpty()){
            char c = q.remove();
            result += c;
            if (map.containsKey(c)){
                for (char c2 : map.get(c)){
                    degree.put(c2,degree.get(c2) - 1);
                    if (degree.get(c2) == 0){
                        q.add(c2);
                    }
                }
            }
        }
        if (result.length() != degree.size()){
            return "";
        }
        return result;
    }
    
}