package project.CodingChallenge;

import junit.framework.TestCase;

public class CircularArrayTest extends TestCase {

    public void testGet() {
        CircularArray<String> list = new CircularArray<>(3);
        list.add("One");
        assertEquals("One", list.get(0));
    }

    public void testSize(){
        CircularArray<String> list = new CircularArray<>(3);
        assertEquals(3,list.size());
    }

    public void testAdd() {
        CircularArray<String> list = new CircularArray<>(3);
        list.add("One");
        list.add("Two");
        CircularArray<String> test = new CircularArray<>(3);
        test.add("One");
        test.add("Two");

        assertEquals(list.get(0),test.get(0));
        assertEquals(list.get(1),test.get(1));
    }

    public void testPop() {
        CircularArray<String> test = new CircularArray<>(3);
        test.add("One");
        test.add("Two");
        test.pop();

        assertNull(test.get(0));
        assertEquals("Two", test.get(1));
    }

    public void testResize(){
        CircularArray<String> test = new CircularArray<>(3);
        test.add("One");
        test.add("Two");
        test.add("Three");
        test.add("Four");

        assertEquals(6,test.size());
    }

    public void testRotateForward(){
        CircularArray<String> test = new CircularArray<>(3);
        test.rotateForward();

        assertEquals(1,test.getHead());
    }

    public void testRotateBackward(){
        CircularArray<String> test = new CircularArray<>(3);
        test.rotateBackward();

        assertEquals(2,test.getHead());
    }

    public void testForEach(){
        CircularArray<String> test = new CircularArray<>(3);
        String result = "";

        test.add("One");
        test.add("Two");
        test.add("Three");

        for(String word : test)
            result += word;

        assertEquals("OneTwoThree",result);
    }

    public void testShiftFoward(){
        CircularArray<String> test = new CircularArray<>(3);
        test.add("One");
        test.add("Two");
        test.add("Three");

        test.shiftForward();
        assertEquals("Three",test.get(0));
    }

    public void testShiftBackward(){
        CircularArray<String> test = new CircularArray<>(3);
        test.add("One");
        test.add("Two");
        test.add("Three");

        test.shiftBackward();
        assertEquals("Two", test.get(0));
    }

}