package offer2016;

public class Solution {
    public int movingCount(int threshold, int rows, int cols){
        boolean[] visited=new boolean[rows*cols];
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }
    public int movingCountCore(int threshold, int rows, int cols,int row,int col,boolean[] visited){
        int count=0;
        if(check(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col]=true;
            count=1+movingCountCore(threshold,rows,cols,row,col-1,visited)
                +movingCountCore(threshold,rows,cols,row,col+1,visited)
                +movingCountCore(threshold,rows,cols,row-1,col,visited)
                +movingCountCore(threshold,rows,cols,row+1,col,visited);
        }
        return count;
    }
    public boolean check(int threshold, int rows, int cols,int row,int col,boolean[] visited){
        if(row>=0&&row<rows&&col>=0&&col<cols&&getDigitSum(col)+getDigitSum(row)<=threshold&&!visited[row*cols+col]){
            return true;
        }
        return false;
    }
    public int getDigitSum(int number){
        int sum=0;
        while(number>0){
            sum +=number%10;
            number /=10;
        }
        return sum;
    }
}