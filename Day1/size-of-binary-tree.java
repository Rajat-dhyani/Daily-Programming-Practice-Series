/**
 * Question : http://practice.geeksforgeeks.org/problems/size-of-binary-tree/1
 * Difficulty: Basic
 * Topic: Tree
 *
 *
 * Definition for Tree.
 * public class TreeNode {
 *     int val;
 *     TreeNode left, right;
 *     TreeNode(int val){this.val = val;}
 * }
 *
 *
 * My submission :
 */
 class GfG{
   public static int size(TreeNode root){
     if (root ==  null)
        return 0;

     return size(root.left) + 1 +size(root.right);
   }
 }
