class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        boolean[][] isPalindrome = new boolean[n][n];
        computePalinTable(s, isPalindrome);
        backTrack(s, 0, result, path, isPalindrome);
        return result;
    }
    private void computePalinTable(String s, boolean[][] isPalindrome){
        int n = s.length();
        for(int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
        }
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                isPalindrome[i][i + 1] = true;
            }
        }
        for(int len = 3; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1])
                isPalindrome[i][j] = true;
            }
        }
    }
    private void backTrack(String s, int start, List<List<String>> result, List<String> path, boolean[][] isPalindrome){
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(isPalindrome[start][end]){
                String substring = s.substring(start, end + 1);
                path.add(substring);
                backTrack(s, end + 1, result, path, isPalindrome);
                path.remove(path.size() - 1);
            }
        }
    }       
}