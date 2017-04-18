package Amz;

import java.util.*;

public class LFUCache {
    
    class Node{
        int freq = 0;
        Node pre = null, next = null;
        LinkedHashSet<Integer> keys = new LinkedHashSet<Integer>();
        Node(int freq)
        {
            this.freq = freq;
        }
    }
    
    HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
    HashMap<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    int capacity = 0;
    Node head = null;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (valueMap.containsKey(key))
        {
            int ret = valueMap.get(key);
            increase(key);
            return ret;
        }
        return -1;
    }
    
    public void increase(int key)
    {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (node.next == null)
        {
            Node next_node = new Node(node.freq+1);
            node.next = next_node;
            next_node.pre = node;
            next_node.keys.add(key);
            nodeMap.put(key, next_node);
        }
        else if (node.next.freq>node.freq+1)
        {
            Node next_node = new Node(node.freq+1);
            Node temp = node.next;
            node.next = next_node;
            next_node.pre = node;
            next_node.next = temp;
            temp.pre = next_node;
            next_node.keys.add(key);
            nodeMap.put(key, next_node);
        }
        else
        {
            node.next.keys.add(key);
        }
        if (node.keys.size() == 0) removeNode(node);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (valueMap.containsKey(key))
        {
            valueMap.put(key, value);
            increase(key);
        }
        else 
        {
            if (valueMap.size() == capacity)
            {
                remove();
                valueMap.put(key, value);
                addToHead(key);
            }
            else 
            {
                valueMap.put(key, value);
                addToHead(key);
            }
        }
    }
    
    public void addToHead(int key)
    {
        if (head == null)
        {
            Node node = new Node(0);
            node.keys.add(key);
            nodeMap.put(key, node);
            head = node;
        }
        else
        {
            if (head.freq > 0)
            {
                Node node = new Node(0);
                node.keys.add(key);
                nodeMap.put(key, node);
                head.pre = node;
                node.next = head;
                head = node;
            }
            else
            {
                head.keys.add(key);
                nodeMap.put(key, head);
            }
        }
    }
    
    public void remove()
    {
        if (head == null) return;
        
        int oldkey = 0;
        
        for (int n : head.keys)
        {
            oldkey = n;
            break;
        }
        
        head.keys.remove(oldkey);
        
        if (head.keys.size()==0) removeNode(head);
        valueMap.remove(oldkey);
        nodeMap.remove(oldkey);
    }
    
    public void removeNode(Node node)
    {
        /*if (node == null || head == null) return;
        
        if (node == head)
        {
            if (head.next != null)
            {
                head.next.pre = null;
                head = head.next;
            }
            else
            {
                head = null;
            }
        }
        else
        {
            if(node.next != null)
            {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            else
            {
                node.pre.next = node.next;
            }
        }*/
    	
    	if (node.pre == null) {
            head = node.next;
        } else {
            node.pre.next = node.next;
        } 
        if (node.next != null) {
            node.next.pre = node.pre;
        }
    }
    
    public static void main(String[] args)
    {
    	LFUCache cache = new LFUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	cache.get(2);       // returns -1 (not found)
    	cache.get(3);       // returns 3.
    	cache.put(4, 4);    // evicts key 1.
    	cache.get(1);       // returns -1 (not found)
    	cache.get(3);       // returns 3
    	cache.get(4);       // returns 4
    }
}

