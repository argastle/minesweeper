import java.awt.Dimension;

public class Grid {
  private final Tile[][] tiles;
  private final Dimension dimension;

  public Grid(Dimension dimension) {
    tiles = new Tile[dimension.height][dimension.width];
    this.dimension = dimension;
  }

  public void print(){
    for (Tile[] tiles : tiles) {
      for (Tile tile : tiles) {
        System.out.print(tile);
      }
      System.out.println();
    }
  }

  public void setTile(int x,int y,Tile tile) {
    tiles[y][x] = tile;
  }

  public Tile getTile(int x,int y) {
    return tiles[y][x];
  }

  public int getWidth() {
    return dimension.width;
  }

  public int getHeight() {
    return dimension.height;
  }

  public boolean isEmpty() {
    return dimension.height == 0 && dimension.width == 0;
  }
}
