class Solution {
    public void reverseString(char[] s) {
       int n= s.length;
       int first=0;
       int last= n-1;
       while(first<last){
            char temp=s[last];
            s[last]=s[first];
            s[first]=temp;
            first++;
            last--;
       }
    }
}