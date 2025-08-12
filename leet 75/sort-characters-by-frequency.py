class Solution:
    def frequencySort(self, s: str) -> str:
        f={}
        for i in s:
            if i not in f:
                f[i]=1
            else:
                f[i]+=1
        f=dict(sorted(f.items(),key=lambda x:x[1],reverse=True))
        res=""
        for key,value in f.items():
            res+=key*value
        return res