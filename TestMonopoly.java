import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMonopoly {

    @Test
    public void testAppendAndLoopBack(){
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("Go");
        list.append("Mediterranean Avenue");
        list.append("Community Chest");

        assertEquals("Go", list.getCurrentNode());
        list.step();
        assertEquals("Mediterranean Avenue", list.getCurrentNode());
        list.step();
        assertEquals("Community Chest", list.getCurrentNode());
        list.step();
        assertEquals("Go", list.getCurrentNode());
    }
}
