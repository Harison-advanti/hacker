package com.hacker.rank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubStringTest {
    @Test
    public void simple() {
        assertThat(render(list("abcd", 3)), is(render(asList("abc","bcd"))));
    }

    @Test
    public void example() {
        assertThat(render(list("welcometojava", 3)), is(render(asList("wel", "elc","lco","com","ome","met","eto","toj","oja","jav","ava"))));
    }

    @Test
    public void sortList() {
        assertThat(render(sort(list("abcd",3))), is(render(asList("abc","bcd"))));
    }

    @Test
    public void exampleSort() {
        assertThat(render(sort(list("welcometojava",3))), is(render(asList("ava","com","elc","eto","jav","lco","met","oja","ome","toj","wel"))));
    }

    @Test
    public void expectation() {
        List<String> welcometojava = sort(list("welcometojava", 3));
        assertThat(welcometojava.get(0), is("ava"));
        assertThat(welcometojava.get(welcometojava.size()-1), is("wel"));
    }

    public static int compareWords(String a, String b){
        return a.compareTo(b);
    }

    private String render(List<String> list) {
        return list.stream().collect(Collectors.joining("\n"));
    }

    private List<String> sort(List<String> asList) {
        asList.sort(SubStringTest::compareWords);
        return asList;
    }

    private List<String> list(String input, int k) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i + k <= input.length(); i++) {
            list.add(input.substring(i, i + k));
        }
        return list;
    }
}
