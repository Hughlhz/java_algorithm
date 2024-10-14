package hot100.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode146 {
    class Solution extends LinkedHashMap<Integer,Integer>{
        int capacity=5;

        public Solution(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity=capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {

        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size()>capacity;
        }
    }
    class LRUCache{
        class Node{
            int key;
            int value;
            Node pre;
            Node next;
            public Node() {
            }
            public Node(int key,int value) {
                this.value = value;
                this.key=key;
            }
        }
        HashMap<Integer, Node> cache = new HashMap<>();
        Node head;
        Node tail;
        int capacity=1;

        public LRUCache(HashMap<Integer, Node> cache, int capacity) {
            this.cache = cache;
            Node head = new Node();
            head.next=tail;
            tail.pre=head;
            Node tail = new Node();
            this.capacity= Math.max(capacity, this.capacity);
        }

        public int get(int key) {
            Node node = cache.getOrDefault(key, null);
            if (node == null) {
                return -1;
            }
            //从旧的位置移除
            node.pre=node.next;
            node.next.pre=node.pre;
            //从头插入
            head.next.pre=node;
            node.next=head.next;
            head.next=node;
            node.pre=head;

            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if(node!=null){
                node.value=value;
                get(key);
                return;
            }

            node = new Node(key,value);
            cache.put(key, node);

            //插入队头
            head.next.pre=node;
            node.next=head.next;
            head.next=node;
            node.pre=head;

            if(cache.size()>capacity) {
                cache.remove(tail.pre.key);
                //移除队尾
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
            }

        }
    }

}
