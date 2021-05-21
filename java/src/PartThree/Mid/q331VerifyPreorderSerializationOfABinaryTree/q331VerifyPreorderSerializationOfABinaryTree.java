package PartThree.Mid.q331VerifyPreorderSerializationOfABinaryTree;
//Java：验证二叉树的前序序列化

public class q331VerifyPreorderSerializationOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSerialization(String preorder) {
        //out is -1,in is +1 -1+1
        //非空节点出度2，入度-1
        //根节点出度2，入度0
        //为了跟非空节点同步，使得根节点出度2，入度-1，初始总的度为1.模拟dummpy节点

        //叶子节点出度0,入度-1

        //diff = 出度 - 入度//整个过程出度>=入度，即diff>=0
        int diff=1;
        String[] split = preorder.split(",");
        for (int i = 0; i < split.length; i++) {
            diff-=1;
            if(diff<0){//防止空节点还有叶子节点
                //如果过程中出度小于入度不可能存在
                return false;
            }
            if(!split[i].equals("#")){
                diff+=2;
            }

        }
        return diff==0?true:false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
