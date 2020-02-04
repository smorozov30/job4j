package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.theInstance;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenAskExitThenNothing() throws IOException {
        this.testServer(
                "пока",
                ""
        );
    }
    @Test
    public void whenAskHelloThenBackHello() throws IOException {
        this.testServer(String.format(
                "привет%sпока",
                LN
        ),
                String.format(
                "Привет, я Оракл!%s%s",
                LN,
                LN)
        );
    }

    @Test
    public void whenAskUnsupportedThenBackDontUnderstand() throws IOException {
        this.testServer(Joiner.on(LN).join(
                "какое-то сообщение",
                "пока"
        ),
                Joiner.on(LN).join(
                "Ну этого я не понимаю...",
                "",
                "")
        );
    }
}
