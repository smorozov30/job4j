package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenReturnList5Addresses() {
        Address first = new Address("Astra", "Novaya", 10, 65);
        List<Profile> list = Arrays.asList(new Profile(first), new Profile(first), new Profile(first));
        List<Address> result = new Profiles().collect(list);
        assertThat(result.size(), is(3));
    }
}
