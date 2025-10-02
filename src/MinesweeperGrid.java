import java.awt.Dimension;
import java.util.List;

public class MinesweeperGrid extends Grid {

  public MinesweeperGrid(Dimension dimension) {
    super(dimension);
  }

  public void fillGrid(List<String> rows) {
    for (int y = 0; y < rows.size(); y++) {
      String currentRow = rows.get(y);
      for (int x = 0; x < currentRow.length(); x++) {
        char input = currentRow.charAt(x);
        if (input == '*') {
          setTile(x,y, Tile.MINE);
        } else {
          setTile(x,y,Tile.SAFE);
        }
      }
    }
  }

  public void calculate() {
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        if (!isMine(x,y)) {
          int mineCount = countMines(x, y);
          Tile convertedNumber = numberToTile(mineCount);
          setTile(x,y,convertedNumber);
        }
      }
    }
  }

  private Tile numberToTile(int amount) {
    return switch (amount) {
      case 0 -> Tile.ZERO;
      case 1 -> Tile.ONE;
      case 2 -> Tile.TWO;
      case 3 -> Tile.THREE;
      case 4 -> Tile.FOUR;
      case 5 -> Tile.FIVE;
      case 6 -> Tile.SIX;
      case 7 -> Tile.SEVEN;
      case 8 -> Tile.EIGHT;
      default -> throw new IllegalStateException("Unexpected value: " + amount);
    };
  }

  public int countMines(int x, int y){
    int amount = 0;
    for (int yOffSet = -1; yOffSet <= 1; yOffSet++) {
      for (int xOffSet = -1; xOffSet <= 1; xOffSet++) {
        if (isMine(x+xOffSet,y+yOffSet)){
          amount++;
        }
      }
    }
    return amount;
  }

  private boolean isMine(int x, int y){
    return inBounds(x,y) && (getTile(x,y) == Tile.MINE);
  }

  private boolean inBounds(int x, int y) {
    return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
  }


}