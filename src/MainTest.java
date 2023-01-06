import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class MainTest {
    private Main main;

    @Test
    public void testReadInput() {
        main = new Main();
        String input = "hello\nworld\ngoodbye\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        String[] words = main.readInput(scanner);
        assertEquals(3, words.length);
        assertEquals("hello", words[0]);
        assertEquals("world", words[1]);
        assertEquals("goodbye", words[2]);
    }
}

