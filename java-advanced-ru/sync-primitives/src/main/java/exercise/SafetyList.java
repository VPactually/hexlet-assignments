package exercise;

class SafetyList {
    // BEGIN
    private int[] array = new int[0];

    public SafetyList() {
    }

    public synchronized void add(int num) {

        if (array.length == 0) {
            array = new int[1];
            array[0] = num;
        } else {
            var res  = new int[array.length + 1];
            System.arraycopy(array, 0, res, 0, array.length);
            res[res.length - 1] = num;
            array = res;
        }
    }

    public int get (int index) {
        return array[index];
    }

    public int getSize() {
        return array.length;
    }

// END
}
