class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SegmentTree tree = new SegmentTree(nums);

        PriorityQueue<Candidate> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.value, a.value)
        );

        for (int l = 0; l < n; l++) {
            int value = tree.value(l, n - 1);
            maxHeap.add(new Candidate(l, n - 1, value));
        }

        long sum = 0L;

        for (int i = 0; i < k; i++) {
            Candidate cur = maxHeap.remove();
            sum += cur.value;

            if (cur.l < cur.r) {
                int nextR = cur.r - 1;
                int nextValue = tree.value(cur.l, nextR);
                maxHeap.add(new Candidate(cur.l, nextR, nextValue));
            }
        }

        return sum;
    }

    private static class Candidate {
        int l;
        int r;
        int value;

        Candidate(int l, int r, int value) {
            this.l = l;
            this.r = r;
            this.value = value;
        }
    }

    private static class SegmentTree {
        private final Node root;
        private final int[] nums;

        SegmentTree(int[] nums) {
            this.nums = nums;
            this.root = build(0, nums.length - 1);
        }

        private Node build(int l, int r) {
            if (l == r) {
                return new Node(l, r, nums[l], nums[l]);
            }

            int m = l + (r - l) / 2;

            Node left = build(l, m);
            Node right = build(m + 1, r);

            return new Node(
                l,
                r,
                Math.min(left.min, right.min),
                Math.max(left.max, right.max),
                left,
                right
            );
        }

        int value(int l, int r) {
            MinMax result = query(root, l, r);
            return result.max - result.min;
        }

        private MinMax query(Node node, int ql, int qr) {
            if (qr < node.l || ql > node.r) {
                return null;
            }

            if (node.l == ql && node.r == qr) {
                return new MinMax(node.min, node.max);
            }

            int m = node.l + (node.r - node.l) / 2;

            MinMax left = query(node.left, ql, Math.min(qr, m));
            MinMax right = query(node.right, Math.max(ql, m + 1), qr);

            if (left != null && right != null) {
                return new MinMax(
                    Math.min(left.min, right.min),
                    Math.max(left.max, right.max)
                );
            }

            return left != null ? left : right;
        }
    }

    private static class Node {
        int l;
        int r;
        int min;
        int max;
        Node left;
        Node right;

        Node(int l, int r, int min, int max) {
            this.l = l;
            this.r = r;
            this.min = min;
            this.max = max;
        }

        Node(int l, int r, int min, int max, Node left, Node right) {
            this.l = l;
            this.r = r;
            this.min = min;
            this.max = max;
            this.left = left;
            this.right = right;
        }
    }

    private static class MinMax {
        int min;
        int max;

        MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}