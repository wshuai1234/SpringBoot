// Morris preorder traversal(cur - left - right)
// steps:
//1.if cur 's left is null, output cur, cur = cur.right
//2. if cur 's left is not null, which means have not finished left subtree,
// find cur 's left subtree 's rightmost node predecessor
//2.1 if predecessor 's right == null  => pre.right = cur,  then output cur, and cur = cur.left
// 2.2 if predecessor 's right != null, which means have traversed before, then : pre.right = null, cur = cur.right

// java code
public List<Integer> mORRIS_PreOrder(TreeNode root){
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
            // this measn left subtree is not null
            // need to find predecessor
            TreeNode tmp = cur.left;
            while (tmp.right != null && tmp.right != cur){
                tmp = tmp.right;
            }
            if (tmp.right == null){
                tmp.right = cur;
                res.add(cur.val);
                cur = cur.left;
            }else{
                tmp.right = null;
                cur = cur.right;
            }
        }
    }
    return res;
}