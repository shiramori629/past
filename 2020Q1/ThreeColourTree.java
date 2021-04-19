
import java.util.ArrayList;
import java.util.List;

/**
 * This question extends a red-black tree to a three-color tree data structure. There are the
 * following properties for a three-color tree:
 * 
 * 1. Each node is either PINK, PURPLE or MAGENTA. 2. Root and every leaf (NULL pointer) are PINK.
 * 3. Each path from Root-to-Leaf has the same number of PINK nodes. 4. A MAGENTA node cannot have a
 * MAGENTA child, and must at least has a PURPLE child. 5. A PURPLE node must have only PINK
 * children.
 * 
 * Please implement the checking functions testProp1, testProp2, testProp3, testProp4 to check if
 * properties (1), (2), (3), (4) hold. Hint: testProp5() has been already implemented in the partial
 * code. You are allowed to define additional methods in your implementation. But you cannot alter
 * the signatures of the given methods and the package structures of the given classes. Please
 * upload the ThreeColourTree.java file to wattle for marking.
 *
 * 
 *
 * @param <T>
 */
// 1. Each node is either PINK, PURPLE or MAGENTA.

public class ThreeColourTree<T extends Comparable<T>> {

  public Node<T> root; // The root node of the tree

  /**
   * Implement this method to check the property1. You may define additional helper methods to
   * complete the task
   * 
   * @return
   */
  public Boolean testProp1() {
    // START YOUR CODE

    return checkProp1(root);

    // END YOUR CODE
  }

  public Boolean checkProp1(Node<T> node) {
    if (node.value == null) {
      return true;
    } else if (node.left.colour == Colour.VIOLET) {
      return false;
    } else if (node.right.colour == Colour.VIOLET) {
      return false;
    }

    return checkProp1(node.left) && checkProp1(node.right);

  }

  /**
   * Implement this method to check the property2. You may define additional helper methods to
   * complete the task
   * 
   * @return
   */
  // 2. Root and every leaf (NULL pointer) are PINK.

  public Boolean testProp2() {
    // START YOUR CODE
    if (root.colour != Colour.PINK) {
      return false;
    } else {
      List<Node<T>> leave = root.childrenLeaves();
      for (Node<T> node : leave) {
        if (node.colour != Colour.PINK) {
          return false;
        }
      }
    }


    return true;

    // END YOUR CODE
  }

  /**
   * Implement this method to check the property3. You may define additional helper methods to
   * complete the task
   * 
   * @return
   */
  // 3. Each path from Root-to-Leaf has the same number of PINK nodes.

  public Boolean testProp3() {
    // START YOUR CODE
    List<Node<T>> leave = root.childrenLeaves();

    int pink = leave.get(0).colorCount(Colour.PINK);
    for (int i = 1; i < leave.size(); i++) {
      if (leave.get(i).colorCount(Colour.PINK) != pink) {
        return false;
      }
    }



    return true;

    // END YOUR CODE
  }

  /**
   * Implement this method to check the property4. You may define additional helper methods to
   * complete the task
   * 
   * @return
   */
  // 4. A MAGENTA node cannot have a MAGENTA child, and must at least has a PURPLE child.

  public Boolean testProp4() {
    // START YOUR CODE

    return checkProp4(this.root);

    // END YOUR CODE
  }

  public Boolean checkProp4(Node<T> node) {
    if (node == null) {
      return true;
    } else if (node.colour == Colour.MAGENTA) {

      if (node.left.colour == Colour.MAGENTA || node.right.colour == Colour.MAGENTA) {
        return false;
      }

      else if (node.left.colour == Colour.PURPLE || node.right.colour == Colour.PURPLE) {
        return true;
      }

      else {
        return false;
      }
    }

    return checkProp4(node.left) && checkProp4(node.right);
  }

  // HINT: testProp5() has been implemented.
  public Boolean testProp5() {
    return checkProp5(this.root);
  }

  public boolean checkProp5(Node<T> node) {
    if (node == null) {
      return true;
    } else if (node.colour == Colour.PURPLE) {
      if (node.left != null && node.left.colour != Colour.PINK) {
        return false;
      }

      if (node.right != null && node.right.colour != Colour.PINK) {
        return false;
      }
    }

    return checkProp5(node.left) && checkProp5(node.right);
  }

  /**
   * Initialize empty RBTree
   */
  public ThreeColourTree() {
    this.root = null;
  }

  /**
   * Add a new node into the tree with {@code root} node.
   * 
   * @param root Node<T> The root node of the tree where x is being inserted.
   * @param x Node<T> New node being inserted.
   */
  private void insertRecurse(Node<T> root, Node<T> x) {
    if (root.value.compareTo(x.value) > 0) {
      if (root.left.value == null) {
        root.left = x;
        x.parent = root;
      } else {
        insertRecurse(root.left, x);
      }
    } else if (root.value.compareTo(x.value) < 0) {
      if (root.right.value == null) {
        root.right = x;
        x.parent = root;
      } else {
        insertRecurse(root.right, x);
      }
    }
    // Do nothing if the tree already has a node with the same value.
  }

  /**
   * Insert node into RBTree.
   * 
   * @param x Node<T> The new node being inserted into the tree.
   */
  private void insert(Node<T> x) {
    if (this.root == null) {
      this.root = x;
    } else {
      insertRecurse(this.root, x);
    }
  }

  /**
   * Demo functions (Safely) insert a value into the tree
   * 
   * @param value T The value of the new node being inserted.
   */
  public void insert(T value) {
    Node<T> node = new Node<T>(value);
    if (node != null) {
      insert(node);
    }
  }

  /**
   * Return the corresponding node of a value, if it exists in the tree
   * 
   * @param x Node<T> The root node of the tree we search for the value {@code v}
   * @param v Node<T> The node that we are looking for
   * @return
   */
  private Node<T> find(Node<T> x, T v) {
    if (x.value == null) {
      return null;
    }

    int cmp = v.compareTo(x.value);
    if (cmp < 0)
      return find(x.left, v);
    else if (cmp > 0)
      return find(x.right, v);
    else
      return x;
  }

  /**
   * Returns a node if the value of the node is {@code key}.
   * 
   * @param key T The value we are looking for
   * @return
   */
  public Node<T> search(T key) {
    return find(this.root, key);
  }

  /**
   * The helper method childrenLeaves() and colorCount() is given, which you can take advantage of.
   * You can also define your own helper methods in the Node class.
   * 
   * 
   *
   * @param <E>
   */
  public class Node<E extends Comparable<E>> {

    Colour colour; // Node colour
    E value; // Node value
    Node<E> parent; // Parent node
    Node<E> left, right; // Children nodes

    // helper class
    // Return a list of all leaves leading to the node
    public List<Node<E>> childrenLeaves() {
      List<Node<E>> rtn = new ArrayList<>();

      if (this.value == null) {
        rtn.add(this);
      } else {
        rtn.addAll(this.left.childrenLeaves());
        rtn.addAll(this.right.childrenLeaves());
      }

      return rtn;
    }

    // helper class
    // Return the number of a given colour node between this node and root
    // (inclusive)
    public int colorCount(Colour colour) {
      if (this.parent == null) {
        return this.colour == colour ? 1 : 0;
      }

      return (this.colour == colour ? 1 : 0) + this.parent.colorCount(colour);
    }

    public Node(E value) {
      this.value = value;
      this.colour = Colour.PINK;
      this.parent = null;

      // Initialise children leaf nodes
      this.left = new Node<E>();
      this.right = new Node<E>();
      this.left.parent = this;
      this.right.parent = this;
    }

    // Leaf node
    public Node() {
      this.value = null;
      this.colour = Colour.PINK;
    }

    public void setColour(Colour colour) {
      this.colour = colour;
    }

    @Override
    public String toString() {
      return this.value + " " + this.colour;
    }
  }
}
