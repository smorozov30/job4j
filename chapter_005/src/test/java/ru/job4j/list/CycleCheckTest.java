package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CycleCheckTest {
    private CycleCheck.Node first;
    private CycleCheck.Node two;
    private CycleCheck.Node third;
    private CycleCheck.Node four;
    @Before
    public void beforeTest() {
        first = new CycleCheck.Node(1);
        two = new CycleCheck.Node(2);
        third = new CycleCheck.Node(3);
        four = new CycleCheck.Node(4);
    }
    @Test
    public void whenCycleTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(new CycleCheck().hasCycle(first), is(true));
    }
    @Test
    public void whenCycleFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        assertThat(new CycleCheck().hasCycle(first), is(false));
    }
    @Test
    public void whenCycleTrueInMiddle() {
        first.next = two;
        two.next = first;
        third.next = four;
        assertThat(new CycleCheck().hasCycle(first), is(true));
    }
}
