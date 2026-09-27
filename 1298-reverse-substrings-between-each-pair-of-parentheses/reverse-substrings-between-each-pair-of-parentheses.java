class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(str.toString());
                str.setLength(0);
            }
            else if(ch== ')'){
                str.reverse();
                String prev= stack.pop();
                str.insert(0, prev);
            }
            else{
                str.append(ch);

            }
        }
        return str.toString();
    }
}