package GameObjects.Grid.Position;


import GameObjects.Grid.Grid;

public abstract class AbstractUnitPosition implements GridPosition {

    private double col;
    private double row;
    private final Grid grid;

    public AbstractUnitPosition(double col, double row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public void setPos(double col, double row) {
        this.col = col;
        this.row = row;
        show();
    }

    @Override
    public double getCol() {
        return col;
    }

    @Override
    public double getRow() {
        return row;
    }

    @Override
    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow();
    }



}
