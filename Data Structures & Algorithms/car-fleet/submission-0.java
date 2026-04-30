class Solution {
    public int carFleet(int target, int[] positions, int[] speeds) {
        double[] times = new double[target];
        for (int i = 0; i < positions.length; i++) {
            times[positions[i]] = (double) (target - positions[i]) / speeds[i];
        }

        double prev = 0.0;
        int fleets = 0;
        
        for(int i = target - 1; i >= 0; --i) {
            double curr = times[i];

            if(curr > prev) {
                prev = curr;
                fleets++;
            }
        }

        return fleets;
    }
}
