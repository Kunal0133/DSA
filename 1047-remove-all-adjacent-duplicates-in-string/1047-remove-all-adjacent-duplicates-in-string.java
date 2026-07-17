class Solution {
    public String removeDuplicates(String s) {
        Stack<Character>stack=new Stack<>();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek()==s.charAt(i)){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
      return sb.reverse().toString(); 
    }
}