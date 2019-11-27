package ru.job4j.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    private Address first;
    private Address second;
    private Address third;
    private Address fourth;
    @Before
    public void beforeTests() {
        first = new Address("Moscow", "Nova", 10, 65);
        second = new Address("Astra", "Novaya", 10, 65);
        third = new Address("Astra", "Novaya", 10, 65);
        fourth = new Address("Piter", "Gagarina", 10, 65);
    }
    @Test
    public void whenReturnList5Addresses() {
        List<Profile> list = List.of(new Profile(first), new Profile(second), new Profile(third));
        List<Address> result = new Profiles().collect(list);
        assertThat(result.size(), is(3));
    }
    @Test
    public void whenGetUniqueAndSortedList() {
        List<Profile> listProfiles = List.of(new Profile(first), new Profile(second), new Profile(third), new Profile(fourth));
        List<Address> result = new Profiles().getUniqueList(listProfiles);
        List<Address> expected = List.of(second, first, fourth);
        assertThat(result, is(expected));
    }
}
