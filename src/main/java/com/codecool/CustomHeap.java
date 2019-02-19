package com.codecool;

/*
 *   Implementaion of a max heap
 */

public class CustomHeap {

    private int numberCapacity = 10;
    private int size = 0;
    private int[] numbers;

    private final int ZERO = 0;
    private final int ONE = 1;
    private final int TWO = 2;


    public CustomHeap() {
        this.numbers = new int[numberCapacity];
    }

    /*
     *   Heap methods: add, peek, poll, clear, contains, size and toString
     */

    public boolean add(int number) {
        extendCapacity();
        this.numbers[this.size] = number;
        this.size++;
        heapifyUp();
        return true;
    }

    public int peek() throws EmptyHeapException {
        if (this.size == this.ZERO) throw new EmptyHeapException("Heap is empty!");
        return this.numbers[this.ZERO];
    }

    public int poll() throws EmptyHeapException {
        if (this.size == this.ZERO) throw new EmptyHeapException("Heap is empty!");
        int item = this.numbers[this.ZERO];
        this.numbers[this.ZERO] = this.numbers[this.size - this.ONE];
        this.size--;
        heapifyDown();
        return item;
    }

    public void clear() {
        this.numbers = new int[numberCapacity];
        this.size = this.ZERO;
    }

    public boolean contains(int number) {
        for (int index = this.ZERO; index < this.size; index++) {
            if (number == this.numbers[index]) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = this.ZERO; index < this.size; index++) {
            stringBuilder.append(String.format(" %d,", this.numbers[index]));
        }
        return stringBuilder.toString();
    }

    /*
     *   Helper methods
     */

    private int getLeftChildIndex(int parentIndex) { return this.TWO * parentIndex + this.ONE; }
    private int getRightChildIndex(int parentIndex) { return this.TWO * parentIndex + this.TWO; }
    private int getParentIndex(int childIndex) { return (childIndex - this.ONE) / this.TWO; }

    private boolean hasLeftChild(int index) { return  getLeftChildIndex(index) < this.size; }
    private boolean hasRightChild(int index) { return  getRightChildIndex(index) < this.size; }
    private boolean hasParent(int index) { return  getParentIndex(index) >= this.ZERO; }

    private int getLeftChild(int index) { return this.numbers[getLeftChildIndex(index)]; }
    private int getRightChild(int index) { return this.numbers[getRightChildIndex(index)]; }
    private int getParent(int index) { return this.numbers[getParentIndex(index)]; }

    private void swapNumbers(int indexOne, int indexTwo) {
        int temp = this.numbers[indexOne];
        this.numbers[indexOne] = this.numbers[indexTwo];
        this.numbers[indexTwo] = temp;
    }

    private void extendCapacity() {
        if (size == numberCapacity) {
            int[] newNumbers = new  int[this.numberCapacity * this.TWO];

            for (int index = this.ZERO; index < this.size; index++) {
                newNumbers[index] = this.numbers[index];
            }
            this.numbers = newNumbers;
            this.numberCapacity *= this.TWO;
        }
    }

    private void heapifyUp() {
        int index = this.size - this.ONE;
        while (hasParent(index) && getParent(index) < this.numbers[index]) {
            swapNumbers(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = this.ZERO;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (this.numbers[index] > numbers[smallerChildIndex]) {
                break;
            } else {
                swapNumbers(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }




}
