/*You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.ou are given two integer
array nums1 and nums2 sorted 

Exp1
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Exp2
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
*/

class Solution{
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
		int len1 = nums1.length;
		int len2 = nums2.length;
		List<List<Integer>> result = new LinkedList<>();
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0] + a[1] - b[1]));
		for(int i = 0; i < len1 && len2 != 0; i++){
			queue.offer(new int[] {nums1[i], nums2[0], 0});
		}
		while(queue.size(0 != 0 && k > 0){
			int[] temp = queue.poll();
			int index2 = temp[2];
			List<Integer> list = new LinkedList<>();
			list.add(temp[0]);
			list.add(temp[1]);
			result.add(list);
			k--;
			if(index2 + 1 < len2){
				queue.offer(new int[] {temp[0], nums2[index2 + 1], index2 + 1});
			}
		}
		return result;
	}
}