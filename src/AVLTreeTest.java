import static org.junit.Assert.*;
import org.junit.Test;

public class AVLTreeTest {
    private AVLTree tree;

    @Test
    public void testInsert() {
        tree = new AVLTree();
        tree.insert(null, "kelime");
        assertEquals("kelime", tree.getRoot().getWord());
        tree.insert(tree.getRoot(), "bir");
        assertEquals("bir", tree.getRoot().getRight().getWord());
        tree.insert(tree.getRoot(), "iki");
        assertEquals("iki", tree.getRoot().getLeft().getWord());
    }

    @Test
    public void testDelete() {
        tree = new AVLTree();
        tree.insert(null, "kelime");
        tree.insert(tree.getRoot(), "bir");
        tree.insert(tree.getRoot(), "iki");
        assertNull(tree.getRoot().getRight());
    }

    @Test
    public void testSearch() {
        tree = new AVLTree();
        tree.insert(null, "kelime");
        tree.insert(tree.getRoot(), "bir");
        tree.insert(tree.getRoot(), "iki");
        assertNotNull(tree.search("kelime"));
        assertNull(tree.search("berfin"));
    }
}
