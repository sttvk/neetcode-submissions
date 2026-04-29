class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(i)) {
                continue;
            }

            res.append(s.charAt(i));
        }

        return res.toString();
    }
}