package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {
    private UserStore userStore;
    private User first;
    private User second;
    private User third;

    @Before
    public void loadBeforeTest() {
        userStore = new UserStore(3);
        first = new User("12");
        second = new User("34");
        third = new User("56");
        userStore.add(first);
        userStore.add(second);
        userStore.add(third);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddOverSizeStore() {
        userStore.add(new User("78"));
    }

    @Test
    public void whenReplaceOldElementReturnNewElement() {
        userStore.replace("12", third);
        User result = userStore.findById("56");
        assertThat(result, is(third));
    }

    @Test
    public void whenDeleteElementFindReturnNull() {
        assertThat(userStore.findById("34"), is(second));
        userStore.delete("34");
        User deleted = userStore.findById("34");
        User expected = null;
        assertThat(deleted, is(expected));
    }

    @Test
    public void whenFindByIdReturnElement() {
        assertThat(userStore.findById("12"), is(first));
        assertThat(userStore.findById("34"), is(second));
        assertThat(userStore.findById("56"), is(third));
    }
}
