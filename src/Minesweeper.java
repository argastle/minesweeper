import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Minesweeper {

  public static void main(String[] args) {
    File input = new File("resources/input.txt");
    List<MinesweeperGrid> grids = readGridsOutOfFile(input);
    int fieldNumber = 1;
    for (MinesweeperGrid grid : grids) {
      System.out.println("Field #"+fieldNumber);
      grid.calculate();
      grid.print();
      System.out.println();
      fieldNumber++;
    }
  }

  private static List<MinesweeperGrid> readGridsOutOfFile(File file) {
    List<MinesweeperGrid> grids = new ArrayList<>();
    try (Scanner scanner = new Scanner(file)){
      MinesweeperGrid grid;
      while (scanner.hasNextLine()){
        grid = getNextGrid(scanner);
        if (!grid.isEmpty()){
          grids.add(grid);
        }
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    return grids;
  }

  private static MinesweeperGrid getNextGrid(Scanner scanner) {
    String currentLine = scanner.nextLine();
    Dimension dimension = getSize(currentLine);
    List<String> rows = new ArrayList<>();
    for (int i = 0; i < dimension.height; i++) {
      rows.add(scanner.nextLine());
    }

    MinesweeperGrid grid = new MinesweeperGrid(dimension);
    grid.fillGrid(rows);
    return grid;
  }

  private static Dimension getSize(String s) {
    String[] splits = s.split(" ");
    return new Dimension(Integer.parseInt(splits[1]),Integer.parseInt(splits[0]));
  }




}
