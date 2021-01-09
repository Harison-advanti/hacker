package com.hacker.codility;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;


public class Nesting {

    private final Solution solution = new Solution();

    @Test
    public void noBrackets() {
        assertThat(solution.solution("UV"), is(1));
    }

    @Test
    public void wellFormedSingleBrackets() {
        assertThat(solution.solution("(U)"), is(1));
    }

    @Test
    public void malformed() {
        assertThat(solution.solution("())"), is(0));
    }

    @Test
    public void onlyBrackets() {
        assertThat(solution.solution("(()(())())"), is(1));
    }
}

class Solution {

    private final Stack<Character> stack = new Stack<>();

    public int solution(String S) {
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            if (ch == ')') {
                if (!stack.empty()&&stack.peek() == '(')
                    stack.pop();
                else
                    return 0;
            }

        }
        return stack.size() == 0 ? 1 : 0;
    }
}
