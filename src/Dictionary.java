
public class Dictionary {
     WordInfo root;


    public Dictionary(){
        root = null;
    }


    public boolean add(String word, String meaning){
       
        WordInfo newWord = new WordInfo(word.toLowerCase(), meaning);
        if(root == null){
           root = newWord;
           return true;
        }
        WordInfo curr, parent;
        parent=curr=root;
         while(curr!=null){
            parent = curr;
            if(curr.word.equals(word.toLowerCase())){
                return false;
            }
            else{    
            if(word.toLowerCase().compareTo(curr.word.toLowerCase()) < curr.word.toLowerCase().compareTo(curr.word.toLowerCase())){
              curr=curr.left;
            }else{
              curr = curr.right;
            }
            }  
        }
        if(word.toLowerCase().compareTo(parent.word.toLowerCase()) < parent.word.compareTo(parent.word.toLowerCase())){
            parent.left = newWord;
        }else{
            parent.right = newWord;
        }

        return true;
        
       
        
    }

    public String printWordList(){
       return inOrder(root);
       
       
       
       
    }

    private String inOrder(WordInfo curr){
        
        if(curr != null){
            String left = inOrder(curr.left);
            String right = inOrder(curr.right);
            return left +  "\n " + curr.word + "\n" +  right;
        }
        return "";
    }

    public void printDictionary(){
         inOrder2(root);
    
    }
 
    private void inOrder2(WordInfo curr){
         
        if(curr != null){
            inOrder2(curr.left);
            System.out.println(curr.word + "");
            inOrder2(curr.right);
        }
        
    }

    public boolean delete(String key){
        
        if(exists(key.toLowerCase())){
            root = recursiveDelete(root, key);
            return true;
        }
        return false;
    }

    private WordInfo recursiveDelete(WordInfo root, String key){
        if (root==null) return null; 
        if (key.toLowerCase().compareTo(key.toLowerCase()) < root.word.toLowerCase().compareTo(key.toLowerCase())){
            ;
            root.left = recursiveDelete(root.left,key);
           
        
        }
        else
            if (key.toLowerCase().compareTo(key.toLowerCase())>root.word.toLowerCase().compareTo(key.toLowerCase())){
                root.right = recursiveDelete(root.right,key);
               
             }else{
                 if (root.left==null) return root.right;
                 if (root.right==null) return root.left;
                 //case 3
                 WordInfo succ= root.right;
                 while(succ.left!=null){
                     succ=succ.left;
                 }
                 root.word=succ.word;
                 root.right= recursiveDelete(root.right,succ.word);
             }
             
        return root;
    }


    public boolean exists(String word) {
        WordInfo curr;
        curr=root;
        while(curr!=null){
           if(curr.word.toLowerCase().equals(word)){
               return true;
           }
            else{  
                
                if(word.toLowerCase().compareTo(curr.word.toLowerCase()) < curr.word.toLowerCase().compareTo(curr.word.toLowerCase())){
                    curr=curr.left;
                    
                 }else{
                    curr = curr.right;
                }
           }     
       }

       return false; 
    }

    public String getMeaning(String word){
        String s ="";
        WordInfo curr;
        curr=root;
        while(curr!=null){
           if(curr.word.toLowerCase().equals(word.toLowerCase())){
               return curr.meaning;
           }
            else{  
                
                if(word.toLowerCase().compareTo(curr.word.toLowerCase()) < curr.word.toLowerCase().compareTo(curr.word.toLowerCase())){
                    curr=curr.left;
                    
                 }else{
                    curr = curr.right;
                }
           }     
       }
        return s = word + " not found in tree!";
    }

    public int getCount(){
        int count = countNode(root);
        return count;
    }


    public int countNode(WordInfo root){

        //base case
        if(root==null)
            return 0;

        //recursive call to left child and right child and
        // add the result of these with 1 ( 1 for counting the root)
        return 1 + countNode(root.left) + countNode(root.right);
    }
    
    boolean isBalanced(WordInfo node)
    {
        int lh; 
 
        int rh; 
 
       
        if (node == null)
            return true;
 
        //Get the height of left and right sub trees 
        lh = height(node.left);
        rh = height(node.right);
        System.out.println("left height has " + lh + " nodes!");
        System.out.println("right height has " + rh + " nodes!");
        if (Math.abs(lh - rh) <= 1
            && isBalanced(node.left)
            && isBalanced(node.right))
            return true;
 
        // tree is not balanced
        return false;
    }
 
   
    int height(WordInfo node){
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }


    
    public WordInfo sortedArrayToBST(String arr[], int start, int end) {

        if (start > end) {
            return null;
        }
 
        // Get the middle element and make it root 
        int mid = (start + end) / 2;

        // create a node with current middle string from array
        WordInfo node = new WordInfo(arr[mid], "Undefind word");
        add(node.word, "Undefind word");
 
        // go through left side using recursion
        node.left = sortedArrayToBST(arr, start, mid - 1);
 
        // go through right side using recusrsion
        node.right = sortedArrayToBST(arr, mid + 1, end);
         
        return node;
    }

   
}


