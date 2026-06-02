class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    int dfs(int[] numbers, int target, int d, int sum) {
        if (d == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int answer = 0;
        answer += dfs(numbers, target, d + 1, sum + numbers[d]);
        answer += dfs(numbers, target, d + 1, sum - numbers[d]);

        return answer;
    }
}