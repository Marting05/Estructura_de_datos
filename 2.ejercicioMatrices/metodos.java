public class metodos {
    public int [][] LLenarMatrizEntera(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = (int) (Math.random()*50 +1);
            }
        }
        return m;
    }

    public void MostrarMatrizEntera(int [][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(" - "+m[i][j]);
            }
            System.out.println();
        }
    }
 
    public ObjMatriz [][] LLenarMatrizObjetual(ObjMatriz[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
             ObjMatriz o = new ObjMatriz();
             o.setDato((int) (Math.random()*50+1));
             m[i][j] = o;               
            }
        }
        return m;
    }

    public void MostrarMatrizObjetual(ObjMatriz [][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(" - "+m[i][j].getDato());
            }
            System.out.println();
        }
    }  
    
    public void MostrarDiagionalSuperior(ObjMatriz [][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if(i==j){
                    System.out.print(" - "+m[i][j].getDato());
                }
            }
            System.out.println();
        }
    }
    

    public void MostrarPar(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if(m[i][j]%2 == 0){
                    System.out.println(" - "+m[i][j]);
                }
            }
            System.out.println();
        }
    }
}
