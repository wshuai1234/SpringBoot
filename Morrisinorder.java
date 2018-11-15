// morris traversal
// space -> O(1)
// morris inorder traversal
// steps: (left - root - right)
1.if cur's left is empty, this means we have finished cur 's left, need to output cur value, 
  cur = cur.right
2.if cur 's left is not empty, there must exist one smaller than cur 's value, need to find cur 's
  predecessor in its left subtree
3. if predecessor 's right is null -->  predecessor 's right = cur, cur = cur.right
  if predecessor 's right is not null -- > this means we have traversed before,  predecessor 's right =null,
  output cur, cur = cur.right

  // java code
  public List<Integer> MorrisInorder(TreeNode root){
      List<Integer> res = new ArrayList<>();
      if (root == null){
          return res;
      }
      TreeNode cur = root;
      while (cur != null){
          if (cur.left == null){
              res.add(cur.val);
              cur = cur.right;
          }else{
              // cur 's left is not null
              TreeNode tmp = cur.left;
              while (tmp.right != null && tmp.right != cur){
                  tmp = tmp.right;
              }
              // we have got cur 's predecessor
              if (tmp.right == null){
                  tmp.right = cur;
                  cur = cur.left;
              }else{
                  res.add(cur.val);
                  tmp.right = null;
                  cur = cur.right;
              }
          }
      }
      return res;
  }