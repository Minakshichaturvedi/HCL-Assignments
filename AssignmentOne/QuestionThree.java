import java.util.*;

class QuestionThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{5,6},{7,8}};
        
        // Addition
        int[][] add = new int[2][2];
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) add[i][j]=A[i][j]+B[i][j];
        System.out.println("Addition: " + Arrays.deepToString(add));
        
        // Subtraction
        int[][] sub = new int[2][2];
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) sub[i][j]=A[i][j]-B[i][j];
        System.out.println("Subtraction: " + Arrays.deepToString(sub));
        
        // Multiplication
        int[][] mul = new int[2][2];
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) 
            for(int k=0;k<2;k++) mul[i][j]+=A[i][k]*B[k][j];
        System.out.println("Multiplication: " + Arrays.deepToString(mul));
        
        // Transpose
        int[][] trans = new int[2][2];
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) trans[i][j]=A[j][i];
        System.out.println("Transpose: " + Arrays.deepToString(trans));
        
        // Check Square
        System.out.println("Is Square? " + (A.length==A[0].length));
        
        // Check Diagonal
        boolean diagonal=true;
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) if(i!=j && A[i][j]!=0) diagonal=false;
        System.out.println("Is Diagonal? " + diagonal);
        
        // Check Identity
        boolean identity=true;
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) {
            if(i==j && A[i][j]!=1) identity=false;
            if(i!=j && A[i][j]!=0) identity=false;
        }
        System.out.println("Is Identity? " + identity);
    }
}