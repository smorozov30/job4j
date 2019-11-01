package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI();
        UserAction[] actions = {new CreateAction()};
        String[] answers = {"0", "Fix PC", actions.length + ""};
        Input input = new StubInput(answers);
        startUI.init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI();
        UserAction[] actions = {new ReplaceAction()};
        Item item = new Item("new Item");
        tracker.add(item);
        String id = item.getId();
        String[] answers = {"0", id, "Replaced item", actions.length + ""};
        Input input = new StubInput(answers);
        startUI.init(input, tracker, actions);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("Replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI();
        UserAction[] actions = {new DeleteAction()};
        Item item = new Item("new Item");
        tracker.add(item);
        String id = item.getId();
        String[] answers = {"0", id, actions.length + ""};
        Input input = new StubInput(answers);
        startUI.init(input, tracker, actions);
        Item result = tracker.findById(item.getId());
        Item expected = null;
        assertThat(result, is(expected));
    }
}
