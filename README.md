# Burst-Balloons-problem-in-Java-
Problem

You are given n balloons, numbered from 0 to n - 1. Each balloon has a number on it, stored in the array nums.

You are asked to burst all the balloons.
If you burst balloon i, you get nums[left] * nums[i] * nums[right] coins,
where left and right are the adjacent balloons still remaining.

Goal: Return the maximum coins you can collect by bursting the balloons wisely.


---

Example

Input: nums = [3,1,5,8]
Output: 167
Explanation: 
Burst balloons in this order:
- Burst 1 → gain 3*1*5 = 15
- Burst 5 → gain 3*5*8 = 120
- Burst 3 → gain 1*3*8 = 24
- Burst 8 → gain 1*8*1 = 8
Total = 167


---

🔹 Intuition

Bursting balloons is tricky because when you remove one, the neighbors change.

Instead of thinking which balloon to burst first, think which balloon to burst last in a range.

Use interval DP:

Let dp[left][right] = maximum coins obtainable by bursting balloons between left and right (exclusive).

Transition:

dp[left][right] = max(
    dp[left][k] + nums[left]*nums[k]*nums[right] + dp[k][right]
) for all k in (left, right)


Add padding balloons of value 1 at both ends to simplify boundaries.


🔹 Complexity

Time: O(n^3) → three nested loops (left, right, k).

Space: O(n^2) → DP table.
