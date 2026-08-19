class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
       
        Map<Integer, Integer> rowMask = new HashMap<>();
        
        for (int[] r : reservedSeats) {
            int row = r[0], seat = r[1];
            if (seat < 2 || seat > 9) continue; 
            int bit = 1 << (seat - 2); 
            rowMask.put(row, rowMask.getOrDefault(row, 0) | bit);
        }
        
        int LEFT = 0b00001111;   
        int MIDDLE = 0b00111100; 
        int RIGHT = 0b11110000; 
        
        int rowsWithReservations = rowMask.size();
        int ans = (n - rowsWithReservations) * 2;
        
        for (int mask : rowMask.values()) {
            if ((mask & LEFT) == 0 && (mask & RIGHT) == 0) {
                ans += 2;
            } else if ((mask & MIDDLE) == 0 || (mask & LEFT) == 0 || (mask & RIGHT) == 0) {
                ans += 1;
            }
        }
        
        return ans;
    }
}
  
