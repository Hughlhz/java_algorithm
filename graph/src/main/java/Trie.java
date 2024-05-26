public class Trie {
    class Node{
        boolean isEnd;
        Node[] next;
        public Node(){
            isEnd=false;
            next=new Node[26];
        }
    }
    Node head;

    public Trie() {
        head=new Node();
    }

    public void insert(String word) {
        Node cur=head;
        for(char ch: word.toCharArray()){
            if(cur.next[ch-'a']==null){
                cur.next[ch-'a']=new Node();

            }
            cur=cur.next[ch-'a'];
        }
        cur.isEnd=true;

    }

    public boolean search(String word) {
        Node cur=head;
        for(char ch:word.toCharArray()){
            if(cur.next[ch-'a']==null)
                return false;
            cur=cur.next[ch-'a'];
        }
        if(cur.isEnd==true) return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
        Node cur=head;
        for(char ch:prefix.toCharArray()){
            if(cur.next[ch-'a']==null)
                return false;
            cur=cur.next[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */