package ga.rugal.list;

/**
 *
 * @author Rugal Bernstein
 * @param <T>
 */
public class LinkedList<T> implements List<T> {

  private Node<T> head = null, tail = null;

  private Node<T> current = null;

  private int size = 0;

  private void addTail(T data) {
    Node<T> node = new Node<T>();
    node.data = data;

    if (this.isEmpty()) {
      this.addAfter(data);
    } else {
      this.tail.next = node;
      this.tail = node;
    }
    this.size++;
  }

  private Node<T> getElementBefore(Node<T> target) {
    Node<T> temp = this.head;
    for (; temp.next != target; temp = temp.next);

    return temp;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   *
   * @param data
   */
  @Override
  public void addAfter(T data) {
    Node<T> node = new Node<T>();
    node.data = data;

    if (this.isEmpty()) {
      this.head = this.tail = this.current = node;
    } else {
      if (this.current == this.tail) {
        this.tail = node;
      }
      node.next = this.current.next;
      this.current.next = node;

    }
    this.size++;
  }

  /**
   *
   * @param data
   */
  @Override
  public void addBefore(T data) {
    Node<T> node = new Node<T>();
    node.data = data;

    if (this.isEmpty()) {
      this.head = this.tail = this.current = node;
    } else {
      if (this.current == this.head) {
        node.next = this.current;
        this.head = node;
      } else {
        Node<T> temp = this.getElementBefore(this.current);
        node.next = this.current;
        temp.next = node;
      }
    }
    this.size++;
  }

  @Override
  public void advance() {
    if (!this.isCurrent()) {
      throw new IllegalStateException("No current element");
    }
    this.current = this.current.next;
  }

  @Override
  public boolean isCurrent() throws IllegalStateException {
    if (!this.isCurrent()) {
      throw new IllegalStateException("No current element");
    }
    return this.current != null;
  }

  @Override
  public T getCurrent() {
    if (!this.isCurrent()) {
      throw new IllegalStateException("No current element");
    }
    return this.current.data;
  }

  @Override
  public void removeCurrent() {
    if (!this.isCurrent() || this.isEmpty()) {
      throw new IllegalStateException("No current element");
    }

    if (this.head == this.current) {
      this.current = this.head = this.head.next;
    } else {
      Node<T> temp = this.getElementBefore(this.current);
      temp.next = this.current.next;
      this.current = this.current.next;
    }
    this.size--;
  }

  @Override
  public void addAll(LinkedList<T> another) {
    if (null == another || another.isEmpty()) {
      //Doing this to exit this method right away
      return;
    }
    for (Node<T> node = another.head; node != null; node = node.next) {

      this.addTail(node.data);
    }
  }
}

class Node<T> {

  public T data;

  public Node next;

  public Node() {
  }

  public Node(T data) {
    this.data = data;
  }
}
