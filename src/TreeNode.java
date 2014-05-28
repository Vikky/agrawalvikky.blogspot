
/**
 * @author vikky.agrawal
 *
 */
public class TreeNode {
    
    private int data;
    private TreeNode right;
    private TreeNode left;   
    
    TreeNode(){}
    
    TreeNode(int data){
        this.setData(data);
        this.setLeft(null);
        this.setRight(null);
    }
    
    public int getData(){
        return this.data;
    }
    
    public TreeNode getRight(){
        return this.right;
    }
    
    public TreeNode getLeft(){
        return this.left;
    }
    
    public void setData(int data){
        this.data=data;
    }
    
    public void setRight(TreeNode right){
        this.right=right;
    }
    
    public void setLeft(TreeNode left){
        this.left=left;
    }  
}