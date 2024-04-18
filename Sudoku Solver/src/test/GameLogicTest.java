import com.wiseassblog.sudoku.computationlogic.GameLogic;
import com.wiseassblog.sudoku.constants.GameState;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class GameLogicTest {

    /**
     * Start with the basic logic to validate a valid Sudoku puzzle
     */
    
    public void onValidateValidPuzzle() {
        assert (GameState.COMPLETE ==
                GameLogic.checkForCompletion(
                        TestData.getSolved().getCopyOfGridState()
                )
        );
    }

    public void onValidateActivePuzzle() {
        assert (GameState.ACTIVE ==
                GameLogic.checkForCompletion(
                        TestData.getValidStart().getCopyOfGridState()
                )
        );
    }

    /**
     * Expected value: True (i.e. squares are indeed not all filled
     */
    
    public void gameSquaresAreNotFilled() {
        assert (GameLogic.tilesAreNotFilled(TestData.getValidStart().getCopyOfGridState()));
    }

    /**
     * Expected value: false
     */
   
    public void gameSquaresAreFilled() {
        assert (!GameLogic.tilesAreNotFilled(TestData.getSolved().getCopyOfGridState()));
    }

    /**
     * Expected value: true
     */
    
    public void gameSquaresAreInvalid() {
        int[][] invalid = TestData.getInvalid().getCopyOfGridState();

        boolean isInvalid = GameLogic.squaresAreInvalid(invalid);
        assert (isInvalid);
    }

    /**
     * Expected value: false
     */
    
    public void gameSquaresAreValid() {
        int[][] valid = TestData.getSolved()
                .getCopyOfGridState();

        boolean isInvalid = GameLogic.squaresAreInvalid(
                valid
        );

        assert (!isInvalid);
    }

    /**
     * Expected value: true
     */
    
    public void gameColumnsAreInvalid() {
        int[][] invalid = TestData.getInvalid()
                .getCopyOfGridState();

        boolean isInvalid = GameLogic.columnsAreInvalid(
                invalid
        );
        assert (isInvalid);
    }

    /**
     * Expected value: false
     */
   
    public void gameColumnsAreValid() {
        int[][] valid = TestData.getSolved().getCopyOfGridState();

        boolean isInvalid = GameLogic.columnsAreInvalid(valid);
        assert (!isInvalid);
    }

    /**
     * Expected value: true
     */
   
    public void gameRowsAreInvalid() {
        int[][] invalid = TestData.getInvalid().getCopyOfGridState();

        boolean isInvalid = GameLogic.rowsAreInvalid(invalid);
        assert (isInvalid);
    }

    /**
     * Expected value: false
     */
 
    public void gameRowsAreValid() {
        int[][] valid = TestData.getSolved().getCopyOfGridState();

        boolean isInvalid = GameLogic.rowsAreInvalid(valid);
        assert (!isInvalid);
    }

    /**
     * Collection does have repeated integer values (this will be either a row or a column)
     * Expected value: true
     */
    
    public void collectionHasRepeats() {
        List<Integer> testList = Arrays.asList(0, 0, 0, 1, 1, 0, 0, 0, 0);
        boolean hasRepeats = GameLogic.collectionHasRepeats(testList);

        assert (hasRepeats);

    }

    /**
     * Expected value: false
     */
  
    public void collectionHasNoRepeats() {
        List<Integer> testListOne = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> testListTwo = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean hasRepeatsOne = GameLogic.collectionHasRepeats(testListOne);
        boolean hasRepeatsTwo = GameLogic.collectionHasRepeats(testListTwo);

        assert (!hasRepeatsOne);
        assert (!hasRepeatsTwo);
    }
}
