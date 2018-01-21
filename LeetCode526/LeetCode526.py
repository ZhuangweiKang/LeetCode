'''
 Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

    The number at the ith position is divisible by i.
    i is divisible by the number at the ith position.

Now given N, how many beautiful arrangements can you construct?
'''
class Solution:
    result = 0
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        self.backtracking(list(range(1, N+1)), 1)
        return self.result

    def backtracking(self, l, i):
        if len(l) == 0:
            self.result += 1
            return
        for index, item in enumerate(l):
            if item % i == 0 or i % item == 0:
                self.backtracking(l[:index]+l[index+1:], i+1)

    '''
    Java Version:
    class Solution {
        int count = 0;
        public int countArrangement(int N) {
            backtracking(N, 1, new boolean[N+1]);
            return count;
        }
    
        private void backtracking(int N, int pos, boolean[] visited){
            if(pos>N){
                count++;
                return;   
            }
            for(int i = 1; i <= N; i++){
                if(!visited[i] && (i % pos == 0 || pos % i == 0)){
                    visited[i] = true;
                    backtracking(N, pos+1, visited);
                    visited[i] = false;
                }
            }
        }
    }
    '''