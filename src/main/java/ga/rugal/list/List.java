package ga.rugal.list;

/**
 *
 * @author Rugal Bernstein
 * @param <T>
 */
public interface List<T> {

  /**
   *
   * @param data
   */
  void addAfter(T data);

  /**
   * 
   */
  void addAll(LinkedList<T> another);

  /**
   *
   * @param data
   */
  void addBefore(T data);

  /**
   * 
   */
  void advance();

  T getCurrent();

  int getSize();

  /**
   * Use "throws" to declare exception
   *
   * @return
   * @throws IllegalStateException
   */
  boolean isCurrent() throws IllegalStateException;

  boolean isEmpty();

  void removeCurrent();
}
