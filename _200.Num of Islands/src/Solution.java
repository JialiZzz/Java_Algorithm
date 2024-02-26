import java.util.Stack;

class Solution {

    class Node{
        int row;
        int col;

        public Node(int row, int col){
            this.row=row;
            this.col=col;
        }

    }

    public int numIslands(char[][] grid) {
        int num=0;
        int col=grid.length;
        int row=grid[0].length;
        Stack<Node> stack = new Stack<>();
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(grid[i][j]=='1'){
                    Node newNode = new Node(j,i);
                    stack.push(newNode);
                }
                while(!stack.isEmpty()){
                    mark(stack,grid);
                    num++;
                }
            }
        }
        return num;
    }


    public void mark(Stack<Node>stack,char[][] grid){
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            grid[cur.col][cur.row]='2';
            if(cur.col+1<grid.length){
                if(grid[cur.col+1][cur.row]=='1'){
                    Node newNode = new Node(cur.col+1,cur.row);
                    stack.push(newNode);
                }
            }
            if(cur.row+1<grid[0].length){
                if(grid[cur.col][cur.row+1]=='1'){
                    Node newNode = new Node(cur.col,cur.row+1);
                    stack.push(newNode);
                }
            }
        }

    }


    public static void main(String[] args){

    }


}