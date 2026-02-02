class MagicDictionary {
    class Node{ //Trie Node
        Node[] next;
        boolean isEnd;
        Node(){
            next=new Node[26];
            isEnd=false;
        }
    }
    public void insert(Node root,String str){
        Node cur=root;
        for(int i=0;i<str.length();i++){
            int c=str.charAt(i)-'a';
            if(cur.next[c]==null){
                Node newNode=new Node();
                cur.next[c]=newNode;
            }
            cur=cur.next[c];
            if(i==str.length()-1){
                cur.isEnd=true;
            }
        }
    }
    Node root;
    public MagicDictionary() {
        root=new Node();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i=0;i<dictionary.length;i++){
            String str=dictionary[i];
            insert(root,str);
        }
    }
    
    public boolean search(String searchWord) {
        boolean flag=false; //false means not modified
        Node cur=root;
        return dfs(searchWord,0,cur,flag);
    }

    public boolean dfs(String searchWord,int index,Node node,boolean flag){
        if(index==searchWord.length()){
            if(node.isEnd){
                return flag;
            }
            else{
                return false;
            }
        }
        int curIdx=searchWord.charAt(index)-'a';
        for(int i=0;i<26;i++){
            if(node.next[i]!=null){
                if(curIdx==i){
                    boolean res=dfs(searchWord,index+1,node.next[i],flag);
                    if(res) return true;
                }
                else{
                    if(!flag){
                        boolean res=dfs(searchWord,index+1,node.next[i],true);
                        if(res) return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */