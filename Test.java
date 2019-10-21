1.
初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 
第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个
灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮
着的灯泡。
示例:

输入: 3
输出: 1 
解释: 
初始时, 灯泡状态 [关闭, 关闭, 关闭].
第一轮后, 灯泡状态 [开启, 开启, 开启].
第二轮后, 灯泡状态 [开启, 关闭, 开启].
第三轮后, 灯泡状态 [开启, 关闭, 关闭]. 

你应该返回 1，因为只有一个灯泡还亮着。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bulb-switcher
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}

2.
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int rob(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int[] res=new int[nums.length+1];
        res[0]=0;
        res[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            res[i]=Math.max(res[i-2]+nums[i-1],res[i-1]);
        }
        return res[nums.length];
    }
}

3.
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int tmp=0;
        int i=0;
        int j=0;
        for(i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
             int sum=tmp;
             sum+=(i>=0?a.charAt(i)-'0':0);
            sum+=(j>=0?b.charAt(j)-'0':0);
            sb.append(sum%2);
            tmp=sum/2;
        }
        sb.append(tmp==1?1:"");
        return sb.reverse().toString();
    }
}