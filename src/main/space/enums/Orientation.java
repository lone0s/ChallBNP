package main.space.enums;

import main.space.Position;

public enum Orientation {
    // J'ai jugé pertinent d'appliquer un élément que j'ai appris lors de mon alternance
    // Pour éviter d'avoir quatre fichiers supplémentaires, j'ai tout condensé ici
    N
        {
        @Override
        public Position goForward(Position position) {
            return new Position(position.x, position.y + 1);
        }
        @Override
        public Orientation rotateLeft() {
            return W;
        }
        @Override
        public Orientation rotateRight() {
            return E;
        }
    },

    S {
        @Override
        public Position goForward(Position position) {
            return new Position(position.x, position.y - 1);
        }
        @Override
        public Orientation rotateLeft() {
            return E;
        }
        @Override
        public Orientation rotateRight() {
            return W;
        }
    },

    W {
        @Override
        public Position goForward(Position position) {
            return new Position(position.x - 1, position.y);
        }
        @Override
        public Orientation rotateLeft() {
            return S;
        }
        @Override
        public Orientation rotateRight() {
            return N;
        }
    },

    E {
        @Override
        public Position goForward(Position position) {
            return new Position(position.x + 1, position.y);
        }
        @Override
        public Orientation rotateLeft() {
            return N;
        }
        @Override
        public Orientation rotateRight() {
            return S;
        }
    };

    public abstract Orientation rotateLeft();
    public abstract Orientation rotateRight();
    public abstract Position goForward(Position position);
    }
