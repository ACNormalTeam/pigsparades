package org.academiadecodigo.vimdiesels.pigsParade.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.vimdiesels.pigsParade.grid.Grid;
import org.academiadecodigo.vimdiesels.pigsParade.grid.GridColor;
import org.academiadecodigo.vimdiesels.pigsParade.grid.GridDirection;

public class Position extends AbstractGridPosition {

    private Rectangle rectangle;
    private Grid grid;

    public Position(Grid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        this.grid = grid;

        rectangle =
                new Rectangle(
                        this.grid.columnToX(this.getCol()),
                        this.grid.rowToY(this.getRow()),
                        this.grid.getCellSize(),
                        this.grid.getCellSize()
                );

        show();

    }

    public Position(int col, int row, Grid grid){
        super(col, row, grid);

        this.grid = grid;

        rectangle =
                new Rectangle(
                        this.grid.columnToX(col),
                        this.grid.rowToY(row),
                        this.grid.getCellSize(),
                        this.grid.getCellSize()
                );

        show();

    }

    @Override
    public void show() {

        this.rectangle.fill();

    }

    @Override
    public void hide() {

        this.rectangle.delete();

    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        //hide();

        super.moveInDirection(direction, distance);
        System.out.println("dir: "+ direction+ " dist: "+distance);
        this.rectangle.translate(
                this.grid.columnToX(this.getCol()) - this.rectangle.getX(),
                this.grid.rowToY(this.getRow()) - this.rectangle.getY()
        );

        //show();

    }

    @Override
    public void setColor(GridColor color) {

        this.rectangle.setColor(Color.BLUE);
        super.setColor(color);

    }
}
