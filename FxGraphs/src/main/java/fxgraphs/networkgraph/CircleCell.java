package fxgraphs.networkgraph;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleCell extends Cell {

    public CircleCell( String id) {
        super( id);

        Circle view = new Circle(50);

        view.setStroke(Color.DODGERBLUE);
        view.setFill(Color.DODGERBLUE);

        setView( view);

    }

}