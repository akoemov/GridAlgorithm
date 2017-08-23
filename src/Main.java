import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Cel> grid = new ArrayList<>();

    public static void main(String[] args) {
       createGrid(100);
        traversal();
    }

    private static void createGrid(int size){
        int rowSize = (int) Math.sqrt(size);
        int [] [] indexLayout = new int[rowSize][rowSize];
        int index = 0;
        for (int i = 0; i <rowSize ; i++) {
            for (int j = 0; j < rowSize; j++) {
                indexLayout[i][j] = index++;
//                System.out.print(indexLayout[i][j] + " ");
            }
//            System.out.println();
        }
        System.out.println();
        for (int s = 0; s < rowSize-1; s++) {
            for (int k = 0; k < rowSize-1; k++) {
                ArrayList<Integer> list = new ArrayList();
                        
                for (int i = s; i < s+2; i++) {
                    for (int j = k; j < k+2; j++) {
                        list.add(indexLayout[i][j]);
//                        System.out.print(indexLayout[i][j] + " ");
                    }
//                    System.out.println();
                }
                
//                System.out.println();
                grid.add(new Cel(list));
                
            }
        }


//        for (List sel : grid) {
//            System.out.println(sel);
//            System.out.println();
//        }
    }

    private static void traversal(){

        long start = System.currentTimeMillis();
        for (Cel cel : grid) {
            List<Integer> ids = cel.getIndexes();
            for (Cel cel1 : grid) {
                if(cel == cel1)
                    continue;
                List<Integer> ids1 = cel1.getIndexes();
                for (Integer id : ids) {
                   if(ids1.contains(id)){
                       cel.addNeighbor(cel);
                   }
                }
            }
        }

        System.out.println("v1 = "+(start-System.currentTimeMillis()));
    }

    private static void traversalRef(){
        long start = System.currentTimeMillis();
        for (Cel cel : grid) {
            List<Integer> ids = cel.getIndexes();
            for (Cel cel1 : grid) {
                if(cel == cel1)
                    continue;
                List<Integer> ids1 = cel1.getIndexes();
                for (Integer id : ids) {
                    if(ids1.contains(id)){
                        cel.addNeighbor(cel);
                        cel.
                    }
                }
            }
        }

        System.out.println("v1 = "+(start-System.currentTimeMillis()));
    }
}

class Cel{
    public Cel(List indexes) {
        this.indexes = indexes;
    }

    private List<Integer> indexes;
    private List<Cel> neighbor = new ArrayList<>();

    public List<Cel> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(List<Cel> neighbor) {
        this.neighbor = neighbor;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }

    public void setIndexes(List indexes) {
        this.indexes = indexes;
    }

    public void addNeighbor(Cel cel){
        neighbor.add(cel);
    }

}

