package dk.easv.bll.bot;

import dk.easv.bll.game.IGameState;
import dk.easv.bll.move.IMove;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mrgl_mrgl implements IBot{

    @Override
    public IMove doMove(IGameState state) {
        List<IMove> moves = state.getField().getAvailableMoves();
        Random random = new Random();


        List<IMove> moveList = winningMoves(moves, state, true);


        if (moveList.size() > 0){
            return moveList.get(random.nextInt(moveList.size()));
        }
        
        List<IMove> blockingMoves = winningMoves(moves,state, false);
        if (blockingMoves.size() > 0){
            return blockingMoves.get(random.nextInt(blockingMoves.size()));
        }
        return moves.get(random.nextInt(moves.size()));
    }
    
    private List<IMove> winningMoves(List<IMove> moves, IGameState state, boolean isPlayer){
        int[][] fields = new int[3][3];
        List<IMove> wm = new ArrayList<>();
        String player;
        if (isPlayer){
            player = state.getMoveNumber()%2+"";

        }
        else {
            player = (1+state.getMoveNumber())%2+"";

        }

        for (IMove move:
             moves) {
            int bigX = moves.get(0).getX()/3;
            int bigY = moves.get(0).getY()/3;




            //Check  0,0
            if (move.getX()%3 == 0 && move.getY()%3 == 0){
                //diagonal
                if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+2).equals(player)){
                    wm.add(move);
                    //Vertical
                } else if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+2).equals(player)) {
                    wm.add(move);
                    //Horizontal
                } else if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+0).equals(player)){
                    wm.add(move);
                }
                //check 1,0
            } else if (move.getX()%3 == 1 && move.getY()%3 == 0) {
                //Hori
                if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+0).equals(player)){
                    wm.add(move);
                }
                //verti
                else if(state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+2).equals(player)){
                    wm.add(move);
                }
                //Check 2,0
            } else if(move.getX()%3 == 2 && move.getY()%3 == 0){
                //Diag
                if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+2).equals(player)){
                    wm.add(move);
                    //Hori
                } else if(state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+0).equals(player)){
                    wm.add(move);
                    //Verti
                } else if(state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+2).equals(player)){
                    wm.add(move);
                }
                //Check 0,1
            } else if (move.getX()%3 == 0 && move.getY()%3 == 1){
                //hori
                if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+1).equals(player)){
                    wm.add(move);
                    //Verti
                } else if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+2).equals(player)){
                    wm.add(move);
                }
                //Check 1,1
            } else if (move.getX()%3 == 1 && move.getY()%3 == 1){
                //Diag 1
                if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+0).equals(player)){
                    wm.add(move);
                    //Diag2
                } else if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+2).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+0).equals(player)){
                    wm.add(move);
                    //Verti
                } else if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+2).equals(player)){
                    wm.add(move);
                    //Hori
                } else if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+1).equals(player)){
                    wm.add(move);
                }
                //Check 2,1
            } else if (move.getX()%3 == 2 && move.getY()%3 == 1){
                //Verti
                if (state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+2).equals(player)){
                    wm.add(move);
                    //Hori
                } else if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player)){
                    wm.add(move);
                }
                //Check 0,2
            } else if(move.getX()%3 == 0 && move.getY()%3 == 2){
                //Diag
                if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+0).equals(player)){
                    wm.add(move);
                    //Verti
                } else if(state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+1).equals(player)){
                    wm.add(move);
                    //Hori
                } else if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+2).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+2).equals(player)){
                    wm.add(move);
                }
                //Check 1,2
            } else if (move.getX()%3 == 1 && move.getY()%3 == 2){
                //verti
                if (state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player)){
                    wm.add(move);
                    //Hori
                } else if(state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+2).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+2).equals(player)){
                    wm.add(move);
                }
                //Check 2,2
            } else if (move.getX()%3 == 2 && move.getY()%3 == 2){
                //Diag
                if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+1).equals(player)){
                    wm.add(move);
                    //Verti
                } else if (state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+0).equals(player) && state.getField().getPlayerId(((3*bigX)+2),(3*bigY)+1).equals(player)){
                    wm.add(move);
                    //Hori
                } else if (state.getField().getPlayerId(((3*bigX)+0),(3*bigY)+2).equals(player) && state.getField().getPlayerId(((3*bigX)+1),(3*bigY)+2).equals(player)){
                    wm.add(move);
                }
            }
        }
        return wm;
    }
    


    @Override
    public String getBotName() {
        return "Mrgl-Mrgl";
    }
}
