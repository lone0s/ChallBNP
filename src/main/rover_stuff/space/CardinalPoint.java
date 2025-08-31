package main.rover_stuff.space;

public enum CardinalPoint {
//    TODO: Ajouter des safeguards parce que si la position est hors grid ca doit bloquer !!!
    NORTH {
        @Override
        public Position goForward(Position position) {
            return new Position(position.x, position.y + 1);
        }
        @Override
        public Direction rotateLeft() {
            return new Direction(WEST);
        }
        @Override
        public Direction rotateRight() {
            return new Direction(EAST);
        }
    },

    SOUTH {
        @Override
        public Position goForward(Position position) {
            return new Position(position.x, position.y - 1);
        }
        @Override
        public Direction rotateLeft() {
            return new Direction(WEST);
        }
        @Override
        public Direction rotateRight() {
            return new Direction(EAST);
        }
    },

    WEST{
        @Override
        public Position goForward(Position position) {
            return new Position(position.x - 1, position.y);
        }
        @Override
        public Direction rotateLeft() {
            return new Direction(NORTH);
        }
        @Override
        public Direction rotateRight() {
            return new Direction(SOUTH);
        }
    },

    EAST{
        @Override
        public Position goForward(Position position) {
            return new Position(position.x + 1, position.y);
        }
        @Override
        public Direction rotateLeft() {
            return new Direction(NORTH);
        }
        @Override
        public Direction rotateRight() {
            return new Direction(SOUTH);
        }
    };

    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();
    public abstract Position goForward(Position position);
    }
