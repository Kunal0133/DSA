class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>rans =new HashMap<>();
        HashMap<Character,Integer>mag=new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            rans.put(ransomNote.charAt(i),rans.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for(int j=0;j<magazine.length();j++){
            mag.put(magazine.charAt(j),mag.getOrDefault(magazine.charAt(j),0)+1);
        }
        for(char c:rans.keySet()){
            if(!mag.containsKey(c) || mag.get(c)<rans.get(c))
            return false;
        }
        return true;
    }
}