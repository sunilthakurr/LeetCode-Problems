class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> factorMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int f : getPrimeFactors(num)) {
                factorMap.computeIfAbsent(f, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n - 1) return steps;

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }

                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                if (isPrime(nums[curr])) {
                    int p = nums[curr];

                    if (factorMap.containsKey(p)) {
                        for (int next : factorMap.get(p)) {
                            if (!visited[next]) {
                                visited[next] = true;
                                queue.offer(next);
                            }
                        }

                        factorMap.remove(p);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                while (num % i == 0) num /= i;
            }
        }

        if (num > 1) factors.add(num);

        return factors;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}