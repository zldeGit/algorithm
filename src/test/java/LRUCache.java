import java.util.HashMap;

//https://leetcode.cn/problems/lru-cache/submissions/
class LRUCache {

  Integer capacity;
  Integer size = 0;
  HashMap<Integer, Node> map;
  Node head;
  Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  private void moveToHead(Node node) {
    Node pre = node.pre;
    if (pre == null) {
      return;
    }
    Node next = node.next;
    pre.next = next;
    if (next != null) {
      next.pre = pre;
    } else {
      tail = pre;
    }
    node.next = head;
    head.pre = node;
    node.pre = null;
    head = node;
  }

  private void addHead(Node newNode) {
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
      return;
    }
    newNode.next = head;
    head.pre = newNode;
    head = newNode;
  }

  private void removeTail() {
    if (tail == head) {
      this.head = null;
      this.tail = null;
      return;
    }
    tail.pre.next = null;
    tail = tail.pre;
  }

  public void put(int key, int value) {
    Node node = map.get(key);
    if (node == null) {
      Node newNode = new Node(key, value);
      size++;
      if (size > capacity) {
        expire();
      }
      map.put(key, newNode);
      addHead(newNode);
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

  public void expire() {
    size--;
    map.remove(tail.key);
    removeTail();
  }

  public class Node {

    public Node pre;
    public Node next;
    public Integer key;
    public Integer value;

    public Node(Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    String[] sa = {"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put",
        "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get",
        "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put",
        "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get",
        "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put",
        "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put",
        "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put",
        "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put",
        "get", "put", "put", "put", "put", "put", "put", "put"};
    int[][] arr = {{10}, {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3},
        {5, 25}, {8}, {9, 22}, {5, 5}, {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9}, {4, 30}, {9, 3},
        {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8}, {2, 14}, {1}, {5}, {4}, {11, 4},
        {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4},
        {8, 18}, {1, 7}, {6}, {9, 29}, {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22},
        {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4},
        {1}, {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26},
        {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17},
        {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4},
        {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};
    LRUCache cache = null;
    LRUCache2 cache2 = null;
    for (int i = 0; i < sa.length; i++) {
      String s = sa[i];
      switch (s) {
        case "LRUCache":
          cache = new LRUCache(arr[i][0]);
          cache2 = new LRUCache2(arr[i][0]);
          break;
        case "put":
          cache.put(arr[i][0], arr[i][1]);
          cache2.put(arr[i][0], arr[i][1]);
          vaild(cache, cache2);
          System.out.println("");
          break;
        case "get":
          int i1 = cache.get(arr[i][0]);
          int i2 = cache2.get(arr[i][0]);
          vaild(cache, cache2);
          System.out.println("");
          break;
      }
    }
  }

  private static void vaild(LRUCache cache1, LRUCache2 cache2) {
    Node head1 = cache1.head;
    LRUCache2.DLinkedNode head2 = cache2.head.next;
    while (head1 != null) {
      if (head1.value != head2.value) {
        System.out.println("error");
        break;
      }
      head1 = head1.next;
      head2 = head2.next;
    }
  }

}

/**
 * ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
 * [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
 * [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,-1,-1,null,null,null,null,29,null,null,null,null,-1,-1,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
 * [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
 */