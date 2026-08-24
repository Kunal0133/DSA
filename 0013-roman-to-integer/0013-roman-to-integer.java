class Solution {
   
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int curr = values.get(s.charAt(i));

            if (i + 1 < n && curr < values.get(s.charAt(i + 1))) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}
    
