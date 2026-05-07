/*
================================================================================
                                LineTrip.java
================================================================================

Problem Name:
Line Trip

Problem Summary:
You are standing at point 0 on a number line.

You must:
1. Travel from 0 to x
2. Then return back from x to 0

Your car:
- Consumes 1 liter of fuel per 1 unit distance
- Starts with a full tank
- Can refill ONLY at gas stations

There are n gas stations placed between 0 and x.

Goal:
Find the MINIMUM fuel tank capacity required to complete the trip.

================================================================================
                                PROBLEM INTUITION
================================================================================

The car gets fully refueled at every gas station.

So we only care about:
"What is the maximum distance traveled without refueling?"

That maximum distance becomes the minimum tank capacity required.

----------------------------------------------------------------------------
IMPORTANT OBSERVATION
----------------------------------------------------------------------------

We must consider:

1. Distance from 0 to first gas station
2. Distance between consecutive gas stations
3. Distance from last gas station to x AND back

----------------------------------------------------------------------------
WHY DO WE DOUBLE THE LAST DISTANCE?
----------------------------------------------------------------------------

Because there is NO gas station at point x.

Suppose:
x = 7
last station = 5

To travel:
5 -> 7 requires 2 liters

But after reaching 7:
You cannot refuel there.

So you must immediately return:
7 -> 5 requires another 2 liters

Total fuel needed:
2 + 2 = 4 liters

Therefore:
Required fuel = 2 * (x - lastStation)

----------------------------------------------------------------------------
FINAL LOGIC
----------------------------------------------------------------------------

Answer =
Maximum among:
- Distance from 0 to first station
- Distances between stations
- 2 * (x - lastStation)

================================================================================
                                TIME COMPLEXITY
================================================================================

For each test case:
- We traverse the array once

Time Complexity:
O(n)

Space Complexity:
O(n)

================================================================================
*/

import java.util.Scanner;

public class LineTrip {

    public static void main(String[] args) {

        // Scanner is used for taking input
        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int t = sc.nextInt();

        // Process each test case
        while (t-- > 0) {

            // Number of gas stations
            int n = sc.nextInt();

            // Destination point
            int x = sc.nextInt();

            // Array to store gas station positions
            int[] stations = new int[n];

            // Read all gas station positions
            for (int i = 0; i < n; i++) {
                stations[i] = sc.nextInt();
            }

            /*
            ------------------------------------------------------------
            Initially assume the maximum required distance is:
            Distance from 0 to first station
            ------------------------------------------------------------
            Example:
            stations[0] = 3

            Then:
            Car must travel 0 -> 3 without refueling

            So at least 3 liters are needed
            */
            int maxDistance = stations[0];

            /*
            ------------------------------------------------------------
            Find maximum gap between consecutive gas stations
            ------------------------------------------------------------

            Example:
            stations = [1, 2, 5]

            Gaps:
            2 - 1 = 1
            5 - 2 = 3

            Maximum gap = 3
            */
            for (int i = 1; i < n; i++) {

                // Current distance between two stations
                int gap = stations[i] - stations[i - 1];

                // Update maximum if current gap is larger
                if (gap > maxDistance) {
                    maxDistance = gap;
                }
            }

            /*
            ------------------------------------------------------------
            Distance from last station to destination
            ------------------------------------------------------------

            Example:
            x = 7
            last station = 5

            One-way distance:
            7 - 5 = 2
            */
            int lastGap = x - stations[n - 1];

            /*
            ------------------------------------------------------------
            Since there is NO gas station at x,
            the car must return back to the last station
            using the same fuel.

            So required fuel becomes:
            2 * lastGap
            ------------------------------------------------------------
            */
            int returnDistance = lastGap * 2;

            // Update answer if this value is larger
            if (returnDistance > maxDistance) {
                maxDistance = returnDistance;
            }

            /*
            ------------------------------------------------------------
            Print final minimum tank capacity required
            ------------------------------------------------------------
            */
            System.out.println(maxDistance);
        }

        // Close scanner
        sc.close();
    }
}
