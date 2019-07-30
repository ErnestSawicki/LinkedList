package pl.beder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleLinkedListTest {

    private final SimpleLinkedList linekedList = new SimpleLinkedList();

    @Test
    public void shouldInsertValuesCorrectly() {
        //when
        linekedList.insertAt(0, 1);
        linekedList.insertAt(0, 2);
        linekedList.insertAt(0, 3);

        //then
        Assertions.assertThat(linekedList.getHolderView()).containsExactly(3, 2, 1);

    }

    @Test
    public void shouldInsertValuesCorrectly2() {
        //when
        initializeHolderWith_3_4_5_2_1();

        //then
        Assertions.assertThat(linekedList.getHolderView()).containsExactly(3, 4, 5, 2, 1);

    }

    @Test
    public void shouldInsertCorrectlyAtTheEnd() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        linekedList.insertAt(5, 6);

        //then
        Assertions.assertThat(linekedList.getHolderView()).containsExactly(3, 4, 5, 2, 1, 6);

    }

    @Test
    public void shouldReturnMinusOneAsIndexWhenValueIsNotPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = linekedList.firstIndexWith(7L);

        //then
        assertThat(index_with_value_7).isEqualTo(-1);
    }

    @Test
    public void shouldReturnCorrectIndexWhenValueIsPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = linekedList.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnFirstIndexWhenValueIsRepeated() {
        //given
        initializeHolderWith_3_4_5_2_1();
        linekedList.insertAt(2, 5);
        linekedList.insertAt(5, 5);

        //when
        long index_with_value_7 = linekedList.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnIndexSameAsSizeWhenThereIsNoHigherValuePresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index = linekedList.firstIndexWithGivenOrHigherValue(6);

        //then
        assertThat(index).isEqualTo(-1L);
    }

    @Test
    public void shouldReturnIndexThatHasHigherValue() {
        //given
        initializeHolderWith_3_4_5_2_1();
        linekedList.insert(10L);

        //when
        long index = linekedList.firstIndexWithGivenOrHigherValue(6);

        //then
        assertThat(index).isEqualTo(5L);
    }

    @Test
    public void shouldBeSortedWhenUsingOnlyInsertSortedMethod() {
        //when
        linekedList.insertSorted(5);
        linekedList.insertSorted(8);
        linekedList.insertSorted(12);
        linekedList.insertSorted(345);
        linekedList.insertSorted(1);
        linekedList.insertSorted(-65);

        //then
        Assertions.assertThat(linekedList.getHolderView()).containsExactly(-65L, 1L, 5L, 8L, 12L, 345L);
    }

    private void initializeHolderWith_3_4_5_2_1() {
        linekedList.insertAt(0, 1);
        linekedList.insertAt(0, 2);
        linekedList.insertAt(0, 3);
        linekedList.insertAt(1, 4);
        linekedList.insertAt(2, 5);
    }


}