package data;

public enum Direction {

    N {
        @Override
        public Direction rotate(Instruction instruction) {
            if(instruction == Instruction.R){
                return E;
            }
            return W;
        }
    },
    S {
        @Override
        public Direction rotate(Instruction instruction) {
            if(instruction == Instruction.R){
                return W;
            }
            return E;
        }
    },
    E {
        @Override
        public Direction rotate(Instruction instruction) {
            if(instruction == Instruction.R){
                return S;
            }
            return N;
        }
    },
    W {
        @Override
        public Direction rotate(Instruction instruction) {
            if(instruction == Instruction.R){
                return N;
            }
            return S;
        }
    };


    public abstract Direction rotate(Instruction instruction);
}
