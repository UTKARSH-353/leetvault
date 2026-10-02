class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans =  new ArrayList<>();
        generate("",2*n, ans);
        return ans;
    }
    void generate(String s, int length, List<String> ans){
        if(s.length() == length){
            if(isValid(s)){
                ans.add(s);
            }
            return;
        }
        generate(s+"(", length, ans);
        generate(s+")",length, ans);
    }
    boolean isValid(String s){
        int count = 0;
        for(int i= 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
                }else{
                    count--;
                }
                            
        
        if(count<0){
            return false;
        }
    }
    return count == 0;
}
}