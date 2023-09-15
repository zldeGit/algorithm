package lu.zhang.entity;

public class RandomListNode {

  public int val;
  public RandomListNode next;
  public RandomListNode rand;

  public RandomListNode() {
  }

  public RandomListNode(int val) {
    this.val = val;
  }

  public RandomListNode(int val, RandomListNode next) {
    this.val = val;
    this.next = next;
  }
}