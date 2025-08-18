class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] paper_count = new int[n+1];
        for(int i = 0; i<n; i++){
            if(citations[i]>=n){
                paper_count[n]++;
            }
            else{
            paper_count[citations[i]]++;
        }
        }
        int hindex = 0;
        for(int i = n; i>=0; i--){
            hindex = hindex + paper_count[i];
            if(hindex>=i)
            return i;
        }
        return 0;
        
    }
}