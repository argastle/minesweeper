public enum Tile{

    ZERO('0'),
    ONE('1'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    MINE('*'),
    SAFE('.');

    final char symbol;

    Tile(char symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return String.valueOf(symbol);
    }
  }