**<ins>Lab: Binary Search Tree</ins>**<br>


Question 1<br>
Create a package called BST and implement a node class called TreeNode<E> and Binary
Search Tree Class called BST<E>. Both the BST<E> and TreeNode<E> classes extends
Comparable.<br>
a) Include necessary declaration in the BST<E> and TreeNode<E> classes.  

b) Implement the following methods in class BST<E>: <br>
i. public boolean search(E e)  
Returns true if the element is in the tree


ii. public boolean insert(E e)  
Insert element o into the binary tree and return true if the element is inserted
successfully  

iii. public int getSize()  
Get the number of nodes in the tree

iv. public int height()and private int height(TreeNode<E> node)  
Returns the height of the BST

v. public E getRoot()  <br>
Returns the root of the BST

vi. public E minValue()<br>
Returns the minimum value of the BST

vii. public E maxValue()<br>
Returns the maximum value of the BST

viii. public java.util.ArrayList<TreeNode<E>> path(E e)<br>
Returns a path from the root leading to the specified element

ix. public boolean delete(E e)<br>
Delete an element from the binary tree. Return true if the element is deleted
successfully, and return false if the element is not in the tree

x. public boolean clear()<br>
Remove all elements from the tree

xi. protected void inorder(TreeNode<E> root)<br>
Display inorder traversal from a subtree

xii. protected void postorder(TreeNode<E> root)<br>
Display postorder traversal from a subtree

xiii. protected void preorder(TreeNode<E> root)<br>
Display preorder traversal from a subtree

c) Write a test program called TestBST in the BST package. Using the appropriate
methods you implemented in BST<E>, produce the following output:<br>

Input Data: 45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14<br>
Inorder (sorted): 1 2 6 14 20 28 32 42 45 53 54 65 76 86 88 98 100<br>
Postorder: 14 6 28 32 42 20 2 1 53 65 86 76 54 100 98 88 45<br><br>
Preorder: 45 1 2 20 6 14 42 32 28 88 54 53 76 65 86 98 100<br>
Height of BST: 6<br>
Root for BST is: 45<br>
Check whether 10 is in the tree? false<br>
Delete 53<br>
Updated Inorder data (sorted): 1 2 6 14 20 28 32 42 45 54 65 76 86 88 98 100<br>
Min Value :1<br>
Max Value :100<br>
A path from the root to 6 is: 45 1 2 20 6<br> 