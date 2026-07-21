class Solution {
    public String removeDuplicates(String s, int k) {
       Stack<Character> ch= new Stack<>();
       Stack<Integer> count = new Stack<>(); 
       for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
       
       if(!ch.isEmpty() && ch.peek()==c ){
        int newcount = count.pop()+1;
        count.push(newcount);
       }
       else{
        ch.push(c);
        count.push(1);
       }
       if(count.peek()==k){
        count.pop();
        ch.pop();
       }
    }
    StringBuilder sb =new StringBuilder();
    while(!ch.isEmpty()){
        char chars= ch.pop();
        int counts=count.pop();
        for(int j=0;j<counts;j++){
            sb.append(chars);
        }
    }
    return sb.reverse().toString();
    }
}