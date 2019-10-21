1.
给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。

我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。

山羊拉丁文的规则如下：

如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
例如，单词"apple"变为"applema"。

如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
例如，单词"goat"变为"oatgma"。

根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
返回将 S 转换为山羊拉丁文后的句子。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/goat-latin
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String toGoatLatin(String S) {
        String res="";
        int i=0;
        int count=0;
        while(i<S.length()){
                if(S.charAt(i)=='a'||S.charAt(i)=='e'||S.charAt(i)=='i'||
                   S.charAt(i)=='o'||S.charAt(i)=='u'||S.charAt(i)=='A'||
                   S.charAt(i)=='E'||S.charAt(i)=='I'||S.charAt(i)=='O'||
                   S.charAt(i)=='U'){
                     while(i!=S.length()&&S.charAt(i)!=' '){
                        res+=S.charAt(i);
                         i++;
                    }
                }else{
                    char c=S.charAt(i);
                      i++;
                    if(i!=S.length()){
                        while(i<S.length()&&S.charAt(i)!=' '){
                        res+=S.charAt(i);
                         i++;
                    }
                    }
                    res+=c;
                }
                res+='m';
                res+='a';
                int tmp=++count;
                while(tmp!=0){
                    res+='a';
                    tmp--;
                }
            if(i<S.length()&&S.charAt(i)==' '){
                res+=' ';
                i++;
            }
        }
        return res;
    }
}

2.
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
                if(nums[left]<target){
                    left++;
                }
            }else if(nums[mid]<target){
                left=mid+1;
                if(nums[right]>target){
                    right--;
                }
            }else{
                if(nums[left]<target){
                    left++;
                }if(nums[right]>target){
                    right--;
                }
            }
            if(left>=nums.length||right<0){
                break;
            }if(nums[left]==target&&nums[right]==target){
                res[0]=left;
                res[1]=right;
                return res;
            }
        }
        return res;
    }
}

3.
峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-peak-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(left<right){
            mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }
        }
        return left;
    }
}