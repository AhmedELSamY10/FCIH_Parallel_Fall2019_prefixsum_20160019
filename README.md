# FCIH_Parallel_Fall2019_prefixsum_20160019

ahmed samy ahmed ali  20160019

nouran mosaad saad    20160479

john magdy ezzat      20160121



Prefix sum is the cumulative sum of a sequence of numbers a0, a1, ... . It is itself a sequence of numbers b0, b1, ... such that  PreSum0 = a0 PreSum1 = a0 + a1 = PreSum0 + a1 PreSum2 = a0 + a1 + a2 = PreSum1 + a2 . . . . . . . . . PreSumn=PreSumn-1+an  Prefix sum operations can be generalized to any binary operator ⊕. Prefix sum operation takes a sequence of n elements [a0, a1, ..., an] and returns a sequence [a0, (a0 ⊕ a1) , ... , (a0 ⊕ a1 ⊕ a2 ... ⊕ an) ] containing the prefix sums.  For example:  A[] = {1,3,4,5,2,7,8,11} The prefix sums corresponding to A will be PreSum[] = {1,4,8,13,15,22,30,41}  Pseudocode for calculating prefix sums:  A is a sequence containing n elements  PreSum[0]=A[0]  for i=1 to n-1     PreSum[i]=PreSum[i-1]+A[i] Prefix sums can be used to calculate the sum of elements in a given range. If we wish to find out the sum of values between [L..R] we can obtain the sum by subtracting the prefix sum PreSum[R] by PreSum[L-1].  Sum[L..R] = PreSum[R]-PreSum[L-1] { If L!=0 } Sum[L..R] = PreSum[R] { If L=0 }
